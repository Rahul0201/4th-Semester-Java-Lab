/*
Each customer of a bank has customer id, name, and current loan amount and phone number.
One can change the attributes like name, phone number. A customer may ask for loan of certain
amount. It is granted provided the sum of current loan amount and asked amount does not
exceed credit limit (fixed amount for all customer). A customer may be a privileged amount.
For such customers credit limit is higher. Once a loan is sanctioned necessary updates should 
be made. Any type of customer should be able to find his credit limit, current loan amount and 
amount of loan he can seek. Design and implement the classes.
*/


import java.util.HashMap;
import java.util.Scanner;


class Customer{
    private String name, customer_id, phone_number;
    private float current_loan;
    static final float credit_limit = 100000.0f;
    static final float credit_limit_privileged = 500000.0f;
    private static String id_generator = "BNK2021XX";
    private static int count = 0;
    private boolean privileged;

    Customer(){
        name = null;
        phone_number = null;
        customer_id = null;
        current_loan = 0;
        privileged = false;
    }
    boolean isPrivileged(){ return privileged;}
    void makePrivileged(){ privileged = true; }
    void setName(String name){ this.name = name;}
    void setPhone(String num){ phone_number = num; }
    String getName(){ return name; }
    String getPhoneNum(){ return phone_number; }
    boolean updateLoan(float amt){
        float limit = credit_limit;
        if(privileged) limit = credit_limit_privileged;
        if( (current_loan+amt) > limit ) return false;
        else{
            current_loan += amt;
            return true;
        }
    }
    void generate_id(){ customer_id = String.format("%s%05d", id_generator,++count);}
    String getID(){ return customer_id; }
    float crLim(){
        if(privileged) return credit_limit_privileged;
        else return credit_limit;
    }
    float currentLoan(){ return current_loan; }

}
class Bank{
    private HashMap<String,Customer> Accounts = new HashMap<>();
    private Scanner scan = new Scanner(System.in);
    
    boolean AddCustomer(){
        String temp;
        Customer fresh = new Customer();
        System.out.print("Enter name of Customer : ");
        temp = scan.nextLine().trim();
        fresh.setName(temp);
        System.out.print("Enter phone number : ");
        temp = scan.nextLine().trim();
        fresh.setPhone(temp);
        System.out.println("\nAdd customer ? [y/n]");
        char choice = Character.toLowerCase(scan.next().charAt(0));
        if(choice == 'y') {
            fresh.generate_id();
            Accounts.put(fresh.getID(),fresh);
            System.out.println("Account created with account number : "+fresh.getID());
            return true;
        }
        else {
            System.out.println("Input Cancelled. No account created");
            return false;
        }
    }
    boolean makePrivileged(String ID){
        if(Accounts.containsKey(ID)){
            Accounts.get(ID).makePrivileged();
            return true;
        }
        System.out.println("No customer found");
        return false;
    }
    boolean grantLoan(String ID,float ammount){
        if(Accounts.containsKey(ID)){
            if(Accounts.get(ID).updateLoan(ammount)){
                System.out.println("\tLoan granted.");
                return true;
            }else{
                System.out.println("\tLoan cannot be granted.\n\tCredit Limit = Rs "+Accounts.get(ID).crLim());
                System.out.println("\tCurrent Loan = Rs "+Accounts.get(ID).currentLoan());
            }
        }
        System.out.println("No customer found");
        return false;
    }
    boolean searchDetails(String ID){
        if(Accounts.containsKey(ID)){
            System.out.println("\tCustomer id :     "+Accounts.get(ID).getID());
            System.out.println("\tCustomer name :   "+Accounts.get(ID).getName());
            System.out.println("\tPhone Number :    "+Accounts.get(ID).getName());
            System.out.println("\tCredit Limit = Rs "+Accounts.get(ID).crLim());
            System.out.println("\tCurrent Loan = Rs "+Accounts.get(ID).currentLoan());
            System.out.println("Ammount of loan can be sought = Rs "+ ( Accounts.get(ID).crLim()-Accounts.get(ID).currentLoan() ));     
        }
        System.out.println("No customer found");
        return false;
    }

}


public class Problem05 {
    public static void main(String args[]){
        Bank bank = new Bank();
        Scanner scan = new Scanner(System.in);
        int choice;
        String buff = "";
        do{
            System.out.println("______________________________________________________________");
            System.out.println("|         :::::::::::::::    Menu    :::::::::::::::         |");
            System.out.println("|             1. Add customer                                |");
            System.out.println("|             2. Make a customer privileged                  |");
            System.out.println("|             3. Grant Loan to a customer                    |");
            System.out.println("|             4. view customer details                       |");
            System.out.println("|                          0 to exit                         |");
            System.out.println("|____________________________________________________________|");
            System.out.print("Enter choice: "); 
            choice = scan.nextInt();
            buff = scan.nextLine();
            switch(choice) {
                case 0: break;
                case 1:
                    bank.AddCustomer();
                    break;
                case 2:
                    String ID;
                    System.out.print("Enter customer id : ");
                    ID = scan.nextLine().trim();
                    bank.makePrivileged(ID);
                    break;
                case 3:
                    System.out.print("Enter customer id : ");
                    ID = scan.nextLine().trim();
                    System.out.print("Enter ammount : ");
                    float ammount = scan.nextFloat();
                    buff = scan.nextLine();
                    bank.grantLoan(ID, ammount);
                    break;
                case 4:
                    System.out.print("Enter customer id : ");
                    ID = scan.nextLine().trim();
                    bank.searchDetails(ID);
                    break;
                default: System.out.println("\t!!!  Invalid Option  !!! "); 
            }
        } while (choice != 0);
    }
}
