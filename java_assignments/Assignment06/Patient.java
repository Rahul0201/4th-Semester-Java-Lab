package java_assignments.Assignment06;

import java.util.Scanner;

public class Patient {
    
    Observations Ob;
    personalInformation pinfo;
    Doctor Dr;
    String id;

    Patient(){
        Ob = new Observations();
        pinfo = new personalInformation();
        Dr = null;
        id = null;
    }
    void SetOb(){ Ob.set(); }
    void Setpinfo(){ pinfo.set(); }
    void setid(String newID){ id = newID; }
    void view(){
        System.out.println("Id : " + id);
        pinfo.view();
        Ob.view();
        System.out.println("Assigned Doctor : " + Dr.name);
    }
    
    
    
}
class Observations{
    Float temparature;
    String BloodPreassure;
    Observations(){
        temparature = null;
        BloodPreassure = null;
    }
    void set(){
        Scanner scan = new Scanner(System.in);
        String buff = "";
        System.out.print("Tempatarure in fahrenheit : "); temparature = scan.nextFloat();
        buff = scan.nextLine();
        System.out.print("Blood Preassure : "); BloodPreassure = scan.nextLine().trim();
    }
    void view(){
        if(temparature != null && BloodPreassure != null){
            System.out.println("Tempatarure in fahrenheit : "+temparature);
            System.out.println("Blood Preassure : "+BloodPreassure);
        }else{
            System.out.println("\t No observation records");
        }
    }
    
}
class personalInformation{
    String name;
    Float age;
    String ContactNo;
    String SSN;
    personalInformation(){
        name = null;
        age = null;
        ContactNo = null;
        SSN = null;
    }
    void set(){
        Scanner scan = new Scanner(System.in); String buff ="";
        System.out.print("Name : "); name = scan.nextLine().trim();
        System.out.print("Social Security Number : "); SSN = scan.nextLine().trim();
        System.out.print("Age : "); age = scan.nextFloat(); buff = scan.nextLine();
        System.out.print("Contact no : "); ContactNo = scan.nextLine().trim();
    }
    void view(){
        System.out.println("Name : "+name);
        System.out.println("Social Security Number : "+SSN);
        System.out.println("Age : "+age);
        System.out.println("Contact no : "+ContactNo);
    }
}
