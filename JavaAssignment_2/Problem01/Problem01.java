/*
Design a BankAcct class with account number, balance and interest rate as attribute. Interest 
rate is same for all account. Support must be there to initialize, change and display the interest
rate. Also supports are to be there to return balance and calculate interest. 
*/

import java.util.HashMap;
import java.util.Scanner;

class BankAcc{
    private String accNo;
    private String accHolderName;
    private float ballance;
    private static float intRate = 6.5f;
    private static final String AccGenerator = "0BNK0BRNCH";
    private static int accounts_opened_ever = 0;

    BankAcc(){
        accNo = null;
        accHolderName = null;
        ballance = 0.0f;
    }

    String getAccNo(){ return accNo; }
    float getBallance(){ return ballance; }
    String getName(){ return accHolderName; }
    static float getInterestRate(){ return intRate; }

    boolean updateBallance(float b){
        if(b<0 && -b < ballance ) return false;
        ballance += b;
        return true;   
    }
    static boolean changeInterestrate(float newIntRate){
        if(newIntRate < 0 ) return false;
        intRate = newIntRate; 
        return true; 
    }
    void setAccNo(){
        if(accNo == null) accNo = String.format("%s%05d", AccGenerator, ++accounts_opened_ever);
    }
    void setName(String name){ accHolderName = String.copyValueOf(name.toCharArray()); }
}

public class Problem01 {
    public static void main(String args[]){
        HashMap<String,BankAcc> Accounts =new HashMap<>();
        Scanner scan = new Scanner(System.in);
        int choice;
        String buff = "";
        do{
            System.out.println("______________________________________________________________");
            System.out.println("|         :::::::::::::::    Menu    :::::::::::::::         |");
            System.out.println("|             1. Create new account                          |");
            System.out.println("|             2. View interest rate                          |");
            System.out.println("|             3. Change interest rate                        |");
            System.out.println("|             4. View account details                        |");
            System.out.println("|             5. Calculate interest                          |");
            System.out.println("|                          0 to exit                         |");
            System.out.println("|____________________________________________________________|");
            System.out.print("Enter choice: "); 
            choice = scan.nextInt();
            buff = scan.nextLine();
            switch(choice) {
                case 0: break;
                case 1:
                    BankAcc temp = new BankAcc();
                    System.out.println("Enter name of account holder : ");
                    temp.setName(scan.nextLine().trim());
                    System.out.print("Ballance : Rs ");
                    float b = scan.nextFloat();
                    buff = scan.nextLine();
                    temp.updateBallance(b);
                    System.out.println("Create Account ? [y/n]");
                    char choice2 = Character.toLowerCase(scan.next().charAt(0));
                    if(choice2 == 'y') {
                        temp.setAccNo();
                        Accounts.put(temp.getAccNo(), temp);
                        System.out.println("Account created with account number : "+temp.getAccNo());
                    }
                    else {System.out.println("Input Cancelled. No account created");}
                    break;
                case 2:
                    System.out.println("\tInterest rate is : "+BankAcc.getInterestRate()+" %");
                    break;
                case 3:
                    System.out.println("\nEnter new interest rate : ");
                    float newintrate = scan.nextFloat();
                    buff = scan.nextLine();
                    if(BankAcc.changeInterestrate(newintrate)) System.out.println("Interest rate changed!");
                    else System.out.println("Couldn't change interest rate. Invalid rate chosen.");
                    break;
                case 4:
                    System.out.println("Enetr account number : ");
                    String num =  scan.nextLine().trim();
                    if(Accounts.containsKey(num)){
                        BankAcc show;
                        show = Accounts.get(num);
                        System.out.println("\n\tAccount number : "+show.getAccNo()+"\n\tName : "+show.getName());
                        System.out.println("\tCurrent Ballance = Rs "+show.getBallance()+"\n");
                    }else{
                        System.out.println("\tNo account found\n");
                    }
                    break;
                case 5:
                    System.out.println("Enetr account number : ");
                    num =  scan.nextLine().trim();
                    if(Accounts.containsKey(num)){
                        BankAcc show;
                        show = Accounts.get(num);
                        System.out.println("\tCurrent Ballance = Rs "+show.getBallance()+"\n");
                        System.out.println("\tYearly interest =  Rs "+show.getBallance()*BankAcc.getInterestRate()/100);
                    }else{
                        System.out.println("\tNo account found\n");
                    }
                    break;
                default: System.out.println("\t!!!  Invalid Option  !!! "); 
            }
        } while (choice != 0);    

    }
}
