package java_assignments.Assignment01;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class STUDENT { 
    private String name;
    private String course;
    private float[] marks;
    protected String roll;
    protected Date admission_date;
    protected static int admitted = 0;
    public static ArrayList<STUDENT> StudentList = new ArrayList<STUDENT>();

    STUDENT(){
        String roll = null;
        String name = null;
        String course = null;
        Date admission_date = null;
        marks = null;
    }

    String getRoll() {return roll;}
    String getName() {return name;}
    String getCourse() {return course;}
    Date getAdmissionDate() {return admission_date;}

    boolean marked(){ return (marks != null); }
    float TotalMarks() {
        if(marks == null) return -1;
        float sum = 0; 
        for(float m : marks) sum += m; 
        return sum;
    }
    static int numStudentsAdmitted() { return admitted; }
    static STUDENT search(String r) {
        int i;
        for( i = 0; i < admitted; i++)
            if(StudentList.get(i).roll.equals(r))
                return StudentList.get(i);
        return null; 
    }

    void input(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter datails of the student : \n");
        System.out.print("Name : ");
        name = scan.nextLine();
        System.out.print("Course : ");
        course = scan.nextLine();
    }
    void admit(){
        admission_date = new Date();
        StudentList.add(this);
        admitted++;
    }
    void setMarks(){
        marks = new float[5];
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter marks of five subjects : ");
        for(int i=0; i<5; i++){
            System.out.printf("\tSubject %d  :  ",(i+1));
            marks[i] = scan.nextFloat();
        }
    }
    boolean printMarkSheet() {       
        System.out.println("\n\n\tName :   \t"+name);
        System.out.println("\tCourse : \t"+course);
        System.out.println("\tRoll no : \t"+roll);
        System.out.printf("\tAdmission date:\t%td %tB %tY\n", admission_date, admission_date, admission_date);
        if(!marked()){
            System.out.println("Student not evaluated yet.\n");
            return false;
        }
        System.out.println("Marks of 5 subjects: ");
        for(int i = 0; i < 5; i++){
            System.out.printf("\tSubject %d : %5.2f ",i+1, marks[i]);
            System.out.println();
        }
        System.out.println("\n");
        return true;
    }

}

