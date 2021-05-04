/*
For every person in an institute details like name, address (consists of premises number, 
street, city, pin and state), phone number, e-mail id are maintained. A person is either 
a student or a faculty. For student roll number and course of study are also be maintained. 
For faculty employee id, department and specialisation are to be stored. One should be able 
to view the object details and set the attributes. For address, one may change it partially 
depending on the choice. Design and implement the classes.
*/

import java.util.HashMap;
import java.util.Scanner;

class Person{
    protected String name;
    protected String premises_no, street, city, state, pin;
    protected String phoneNum;
    protected String emailID;
    protected Scanner scan = new Scanner(System.in);
    Person(){
        name = null;
        premises_no = null;
        state = null;
        street = null;
        city = null;
        pin = null;
        phoneNum = null;
        emailID = null;
    }
    
    void setData(){
        System.out.println("Enter personal details :");
        System.out.print("\tName : ");
        name = scan.nextLine().trim();
        System.out.print("\tPhone number : ");
        phoneNum = scan.nextLine().trim();
        System.out.print("\tE-mail id : ");
        emailID = scan.nextLine().trim();
        System.out.println("Enter address :");
        System.out.print("\tPremises_no : ");
        premises_no = scan.nextLine().trim();
        System.out.print("\tStreet : ");
        street = scan.nextLine().trim();
        System.out.print("\tCity : ");
        city = scan.nextLine().trim();
        System.out.print("\tState : ");
        state = scan.nextLine().trim();
        System.out.print("\n\tPIN : ");
        pin = scan.nextLine().trim();
    }
    void changeAddress(){
        int choice;
        String buff ="";
        System.out.print("Press:\n\t1. To change premises number\n\t2. To change street\n\t3. To change city");
        System.out.println("\t4. To change state\n5. To change pin\nEnter your choice:");
        choice = scan.nextInt();
        buff = scan.nextLine();
        switch(choice){
        case 1:
            System.out.print("Enter new premises number: ");
            premises_no = scan.nextLine().trim();
            break;
        case 2:
            System.out.print("Enter new street name: ");
            street = scan.nextLine().trim();
            break;
        case 3:
            System.out.print("Enter new city name: ");
            city = scan.nextLine().trim();
            break;
        case 4:
            System.out.print("Enter new state name: ");
            state = scan.nextLine().trim();
            break;
        case 5:
            System.out.print("Enter new pin: ");
            pin = scan.nextLine().trim();
            break;
        default : System.out.println("Wrong choice. Exiting...");
        }
    }
    void show(){
        System.out.println("\nPersonal details :");
        System.out.println("\tName: " + name + "\n\tPhone number: " + phoneNum + "\n\tEmail: " + emailID);
        System.out.println("\nAddress:" + "\n\tPremises number: " + premises_no + "\n\tStreet: " + street + "\n\tCity: " + city + "\n\tState: " + state + "\n\tPin: " + pin);
    }

}
class Student extends Person{
    private String roll;
    private String course;

    Student(){
        super();
        roll = null;
        course = null;
    }
    void setData(){
        super.setData();
        System.out.print("\n\tRoll number: ");
        roll = scan.nextLine().trim();
        System.out.print("\tCourse of study: ");
        course = scan.nextLine().trim();
    }
    void show(){
        super.show();
        System.out.println("\nStudent details : ");
        System.out.println("\tRoll: " + roll + "\n\tCourse of study: " + course);
    }
    boolean match(String search){ return search.equals(roll); }
    String mapAgainst(){ return roll; }

}
class Faculty extends Person{
    private String id;
    private String dept;
    private String specialisation;

    Faculty(){
        super();
        id = null;
        dept = null;
        specialisation = null;
    }
    void setData(){
        super.setData();
        System.out.print("\n\tEmployee id: ");
        id = scan.nextLine().trim();
        System.out.print("\tDepartment: ");
        dept = scan.nextLine().trim();
        System.out.print("\tSpecialisation: ");
        specialisation = scan.nextLine().trim();
    }

    void show(){
        super.show();
        System.out.println("\nFaculty details :");
        System.out.println("\tEmployee id: " + id + "\n\tDepartment: " + dept + "\n\tSpecialisation: " + specialisation);
    }
    boolean match(String search){ return search.equals(id); }
    String mapAgainst(){ return id; }

}
class Institute{
    private HashMap<String,Person> personmap = new HashMap<>();
    private Scanner scan = new Scanner(System.in);

    void addStudent(){
        Student stu = new Student();
        stu.setData();
        if(personmap.containsKey(stu.mapAgainst())){
            System.out.println("Someone already present with this roll/id\nCould not add");
            return;
        }else{
            personmap.put(stu.mapAgainst(), stu);
            System.out.println("Student added with id/roll = "+stu.mapAgainst());
        }
    }
    void addFaculty(){
        Faculty fac = new Faculty();
        fac.setData();
        if(personmap.containsKey(fac.mapAgainst())){
            System.out.println("Someone already present with this roll/id\nCould not add");
            return;
        }else{
            personmap.put(fac.mapAgainst(), fac);
            System.out.println("Faculty added with id = "+fac.mapAgainst());
        }
    }
    void chngAddress(String search){
        if(personmap.containsKey(search)){
            personmap.get(search).show();
            System.out.println("\nChange address ? [y/n]");
            char choice = Character.toLowerCase(scan.next().charAt(0));
            if(choice == 'y') {
                personmap.get(search).changeAddress();
                return;
            }
            else {
                System.out.println("Input Cancelled. Address not changed.");
                return;
            }
        }else{
            System.out.println("No person found with this id/roll");
            return;
        }          
    }
    void showPerson(String search){
        if(personmap.containsKey(search)){
            personmap.get(search).show();
            return;
        }else{
            System.out.println("No person found with this id/roll");
            return;
        }          
    }
}
public class Problem06 {
    public static void main(String args[]){
        Institute INS = new Institute();
        Scanner scan = new Scanner(System.in);
        int choice;
        String buff = "";
        do{
            System.out.println("______________________________________________________________");
            System.out.println("|         :::::::::::::::    Menu    :::::::::::::::         |");
            System.out.println("|             1. Add faculty                                 |");
            System.out.println("|             2. Add student                                 |");
            System.out.println("|             3. Show Person                                 |");
            System.out.println("|             4. Change address                              |");
            System.out.println("|                          0 to exit                         |");
            System.out.println("|____________________________________________________________|");
            System.out.print("Enter choice: "); 
            choice = scan.nextInt();
            buff = scan.nextLine();
            switch(choice) {
                case 0: break;
                case 1:
                    INS.addFaculty();;
                    break;
                case 2:
                    INS.addStudent();
                    break;
                case 3:
                    String ID;
                    System.out.print("Enter id/roll to show details : ");
                    ID = scan.nextLine().trim();
                    INS.showPerson(ID);
                    break;
                case 4:
                    System.out.print("Enter id/roll to change address : ");
                    ID = scan.nextLine().trim();
                    INS.chngAddress(ID);
                    break;
                default: System.out.println("\t!!!  Invalid Option  !!! "); 
            }
        } while (choice != 0);
    }
}
