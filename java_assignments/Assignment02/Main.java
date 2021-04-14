/*Design a system for the following scenario:
1. An item list contains item code, name, rate, and quantity for several items.
2. Whenever a new item is added in the list uniqueness of item code is to be checked. Register a new product
with its price.
3. Time to time rate of the items may change.
4. Whenever an item is issued or received existence of the item is checked and quantity is updated.
5. In case of issue, availability of quantity is also to be checked.
6. User may also like to know price/quantity available for an item.
7. Find how many items cost more than a given amount. The amount will be a parameter. 8. Remember
that the methods have to return an error code if for example an invalid item code is given NOTE:
-> The system should be maintained by two types of user, one is Stock entry operator(SEO) and other is
Shopkeeper (SK) and SEO will be the first operator in default case.
-> The SEO primarily maintain first 3 operations but SEO users can also maintain all operations (1 to 8)
-> SK users can only operates on 4 to 8.
-> System should be used for a specific shop type. Ex. Electronics, Book, Grocer etc.. You can design your
system for any one.
-> Item Code should be auto generated that includes item name and entry order(1,2,3...)
Example: for Electronics shop
Item name entry order Item Code
Laptop 3 LAP003
Mobile 2 MOB002
Monitor 10 MON010
Mouse 1 MOU001*/

package java_assignments.Assignment02;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int choice;
        do{
            System.out.println("_____________________________________________________________");
            System.out.println("|         :::::::::::::::Choose User:::::::::::::::         |");
            System.out.println("|             1. Stock Entry Operartor                      |");
            System.out.println("|             2. Shop Keeper                                |");
            System.out.println("|                         0 to exit                         |");
            System.out.println("|___________________________________________________________|");
            System.out.print("Enter choice: "); 
            choice = scan.nextInt();
            switch(choice) {
            case 0: break;
            case 1:
                User.SEO();
                break;
            case 2:
                User.SK();
               break;
            default: System.out.println("\t!!!  Invalid Option  !!! "); 
            }
        } while (choice != 0);    
    }
    
}
