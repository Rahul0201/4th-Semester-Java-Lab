package java_assignments.Assignment02;

import java.util.ArrayList;
import java.util.Scanner;

public class Item {
    public static ArrayList<Item> ItemList = new ArrayList<Item>();
    private static int entryOrder = 0;
    private static final Scanner scan = new Scanner(System.in);

    private String name;
    private String code;
    private int quantity;
    private float rate;

    Item(){
        name = null;
        code = null;
        quantity = -1;
        rate = -1;
    }
    Item(Item old){
        name = old.name;
        code = old.code;
        quantity = old.quantity;
        rate = old.rate;
    }
    static int searchByCode(String code){
        int i;
        for( i = 0; i < ItemList.size(); i++)
            if(ItemList.get(i).code.equalsIgnoreCase(code))
                return i;
        return -1; 
    }
    static int searchByName(String name){
        int i;
        for( i = 0; i < ItemList.size(); i++)
            if(ItemList.get(i).name.equalsIgnoreCase(name))
                return i;
        return -1; 
    }
    
    String getName() {return name;}
    String getCode() {return code;}
    int getQuantity() {return quantity;}
    float getRate() {return rate;}
 
    boolean setName(String name){
        if(name.length() == 0){
            System.out.println("\tName cannot be empty"); 
            return false;
        }
        int i;
        if( (i=searchByName(name)) != -1 ) {
            System.out.println("\tItem already present with code : " +ItemList.get(i).getCode() );
            System.out.println("\tQuantity at stock : " +ItemList.get(i).getQuantity()); 
            System.out.println("If you want to add this to stock, try updating quantity in \"Recieve Item\".");
            return false;
        }
        this.name = name;
        return true;
    }
    void setCode(){
        String formattedname = name.toUpperCase();
        code = String.format("%s%03d",formattedname,++entryOrder);
    }
    boolean setQuantity(int new_quantity) {
        if(new_quantity< 0) return false;
        quantity = new_quantity; 
        return true;
    }
    boolean setRate(float new_rate) {
        if(new_rate <= 0) return false;
        rate = new_rate; 
        return true;
    }
    

    static boolean AddItem(){
        String buff = "";
        Item item = new Item(); 
        String name; 
        float rate;
        int quantity;
        System.out.print("\nEnter new item name: "); 
        name = scan.nextLine();
        name = name.trim();
        if(!item.setName(name)){ return false; }
        while (true){
            System.out.print("Enter item rate: "); 
            rate = scan.nextFloat();
            buff = scan.nextLine();
            if(!item.setRate(rate)) System.out.println("\n\tInvalid rate. Try again.\n");
            else break;
        }
        while (true){
            System.out.print("Enter number of units to add (0 if none): ");
            quantity = scan.nextInt();
            buff = scan.nextLine();
            if(!item.setQuantity(quantity)) System.out.println("\n\tInvalid quantity. Try again.\n");
            else break;
        }
        item.setCode();
        System.out.println("\nItem added with code : "+item.getCode());
        ItemList.add(item);
        return true;
    }
    static boolean RecieveItem(){ 
        String buff = "";     
        String code;
        int quantity;
        System.out.print("\nEnter item code: "); 
        code = scan.nextLine();
        code.trim();
        int i;
        if( (i=searchByCode(code)) == -1 ) {
            System.out.println("\tItem does not exist with code : " + code);
            System.out.println("Try \"Add Item\" to add new item to stock");    
            return false;
        }
        System.out.println("\nItem present with code : " +ItemList.get(i).getCode() );
        System.out.println("Quantity at stock : " +ItemList.get(i).getQuantity());
        while (true){
            System.out.print("Enter number of units to add : ");
            quantity = scan.nextInt();
            buff = scan.nextLine();
            if(quantity<0) System.out.println("\n\tInvalid quantity. Try again.\n");
            else break;
        }
        Item item = new Item(ItemList.get(i));
        ItemList.remove(i);
        item.setQuantity(item.getQuantity() + quantity);
        System.out.println("Updated Quantity : " + item.getQuantity());
        ItemList.add(i, item);
        return true;
    }
    static boolean IssueItem(){   
        String buff = "";   
        String code;
        int quantity;
        System.out.print("\nEnter item code: "); 
        code = scan.nextLine();
        code.trim();
        int i;
        if( (i=searchByCode(code)) == -1 ) {
            System.out.println("\tItem does not exist with code : " + code);
            System.out.println("Try \"Add Item\" to add new item to stock");    
            return false;
        }
        System.out.println("Item present with code : " +ItemList.get(i).getCode() );
        System.out.println("Quantity at stock : " +ItemList.get(i).getQuantity());
        if(ItemList.get(i).getQuantity() < 1){
            System.out.println("\n\tNo item can be issued. Stock Empty\n");
            return false;
        }
        while (true){
            System.out.print("Enter number of units to issue : ");
            quantity = scan.nextInt();
            buff = scan.nextLine();
            if(quantity<0) System.out.println("\n\tInvalid quantity. Try again.\n");
            else if(quantity > ItemList.get(i).getQuantity()) System.out.println("\n\tCan not issue that many Units. Try a lesser ammount.\n");
            else break;
        }
        Item item = new Item(ItemList.get(i));
        ItemList.remove(i);
        item.setQuantity(item.getQuantity() - quantity);
        System.out.println("\n\tUnits left in stock : " + item.getQuantity());
        ItemList.add(i, item);
        return true;
    }
    static boolean UpdateRate(){
        String buff = "";
        String code;
        float rate;
        System.out.print("\nEnter item code: "); 
        code = scan.nextLine();
        code.trim();
        int i;
        if( (i=searchByCode(code)) == -1 ) {
            System.out.println("\tItem does not exist with code : " + code);
            return false;
        }
        System.out.println("Item present with code : " +ItemList.get(i).getCode() );
        System.out.println("Current Rate : Rs" +ItemList.get(i).getRate());
        Item item = new Item(ItemList.get(i));
        ItemList.remove(i);
        while (true){
            System.out.print("Enter new rate: "); 
            rate = scan.nextFloat();
            buff = scan.nextLine();
            if(!item.setRate(rate)) System.out.println("\n\tInvalid rate. Try again.\n");
            else break;
        }
        item.setRate(rate);
        System.out.println("\n\tUpdated rate : Rs" + item.getRate());
        ItemList.add(i, item);
        return true;
    }
    static boolean ShowItem() {
        String code;
        System.out.print("\nEnter item code: ");
        code = scan.next();
        int i;
        if( (i=searchByCode(code)) == -1 ) {
            System.out.println("\tItem does not exist with code : " + code);
            System.out.println("Try \"Add Item\" to add new item to stock");    
            return false;
        }
        System.out.println("\nItem present with code : " +ItemList.get(i).getCode() );
        System.out.println("Item Name : " +ItemList.get(i).getName());
        System.out.println("Quantity at stock : " +ItemList.get(i).getQuantity());
        System.out.println("Item Rate: RS"+ ItemList.get(i).getRate());
        return true;
    }
    static void FilterCost(float amt) {
        System.out.println("\nItems which cost more than : Rs" + amt);
        int count = 0;
        for(Item item : ItemList) 
            if(item.getRate() > amt) {
                System.out.println("Cost : Rs"+ item.getRate() +"\tName : "+item.getName()+"\tcode : "+item.getCode());
                count++;
            }
        if(count == 0) System.out.println("\tNo items Available");
    }
    static void ShowAll(){
        if(ItemList.size() == 0){
            System.out.println("\n\tNo Items Registered\n");
        }else{
            for(Item item : ItemList) 
                System.out.println("Cost : Rs"+ item.getRate() +"\tQuantity : "+item.getQuantity()+"\tName : "+item.getName()+"\tcode : "+item.getCode());
        }
    }

}
