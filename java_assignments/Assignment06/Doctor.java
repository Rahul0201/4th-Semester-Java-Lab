package java_assignments.Assignment06;


public class Doctor {
    String name;
    String id;
    Doctor(){
        name = null;
        id = null;
    }
    void view(){
        System.out.println("\tDoctor id : "+id);
        System.out.println("Name = "+name);
    }
    
}
