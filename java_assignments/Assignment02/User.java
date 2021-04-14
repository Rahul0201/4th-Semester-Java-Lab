package java_assignments.Assignment02;

import java.util.Scanner;

public class User {
    private static final Scanner scan = new Scanner(System.in);
    private static final String SEOpassword = "admin";
    static void SEO(){
        //Operartions for SEO
        System.out.println("Log in as SEO");
        System.out.println("Enter password");
        String password = scan.nextLine();
        if( !(SEOpassword.equals(password)) ){
            System.out.println("Wrong Password");
            return;
        }
        
        int choice;
        String Buff = "";
        do {
            System.out.println("_____________________________________________________________");
            System.out.println("|  :::::::::::::::Stock Entry Operator Menu:::::::::::::::  |");
            System.out.println("|        1. Add item                                        |");
            System.out.println("|        2. Update rate of existing item                    |");
            System.out.println("|        3. Receive units to stock                          |");
            System.out.println("|        4. Issue units from stock                          |");
            System.out.println("|        5. Check details of item                           |");
            System.out.println("|        6. Filter items costing more than given amount     |");
            System.out.println("|        7. List all Items.                                 |");
            System.out.println("|        0. Exit from this menu                             |");
            System.out.println("|___________________________________________________________|");
            System.out.print("Enter choice: "); 
            choice = scan.nextInt();
            Buff = scan.nextLine();
            switch(choice) {
            case 0: break;
            case 1:
                if(Item.AddItem()) System.out.println("The operation completed successfully.");
                else System.err.println("The operation did not complete successfully."); break;
            case 2:
                if(Item.UpdateRate()) System.out.println("The operation completed successfully.");
                else System.err.println("The operation did not complete successfully."); break;
            case 3:
                if(Item.RecieveItem()) System.out.println("The operation completed successfully.");
                else System.err.println("The operation did not complete successfully."); break;
            case 4:
                if(Item.IssueItem()) System.out.println("The operation completed successfully.");
                else System.err.println("The operation did not complete successfully."); break;
            case 5:
                if(Item.ShowItem()) System.out.println("The operation completed successfully.");
                else System.err.println("The operation did not complete successfully."); break;
            case 6:
                System.out.print("Enter amount: "); 
                Item.FilterCost(scan.nextFloat()); 
                break;
            case 7: Item.ShowAll(); break;
            default: System.err.println("\tInvalid Option! ");
             
            }
        } while (choice != 0);    
    }
  
    static void SK(){
        //Operations for SK
        
        int choice;
        String Buff = "";
        do {
            System.out.println("_____________________________________________________________");
            System.out.println("|      :::::::::::::::Shop Keeper Menu:::::::::::::::       |");
            System.out.println("|        1. List all Items.                                 |");
            System.out.println("|        2. Check details of item                           |");
            System.out.println("|        3. Filter items costing more than given amount     |");
            System.out.println("|        0. Exit from this menu                             |");
            System.out.println("|___________________________________________________________|");

            System.out.print("Enter choice: "); 
            choice = scan.nextInt();
            Buff = scan.nextLine();
            switch(choice) {
            case 0: break;
            case 1:
                Item.ShowAll(); break;
            case 2:
                if(Item.ShowItem()) System.out.println("The operation completed successfully.");
                else System.err.println("The operation did not complete successfully."); break;
            case 3:
                System.out.print("Enter amount: "); 
                Item.FilterCost(scan.nextFloat()); 
                break;
            default: System.err.println("\tInvalid Option! ");
             
            }
        } while (choice != 0);    
    }
}
