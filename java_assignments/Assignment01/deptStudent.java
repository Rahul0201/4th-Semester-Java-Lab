package java_assignments.Assignment01;

import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;

class deptStudent extends STUDENT{
    private String dept_code; // 4 letter capitalised format
    private int code;
    static final int NumberOfDepartments = 4; // 1:BCSE 2:MECH 3:ETCE 4:BELE
    static final int MaxStudentsPerDept = 100;
    static int dept_count[] = {0,0,0,0};
    static String dept_name[] = {"BCSE","MECH","ETCE","BELE"};
    static deptStudent[][] dept = new deptStudent[NumberOfDepartments][MaxStudentsPerDept];

    deptStudent(){
        super();
        dept_code = null;
    }

    void input() {
        Scanner scan = new Scanner(System.in);
        String buff = "";
        super.input();
        System.out.println("Choose department : ");
        System.out.println("1:BCSE 2:MECH 3:ETCE 4:BELE");
        System.out.print("Enter department number : ");
        code = scan.nextInt();
        buff = scan.nextLine();
        code--;
        if(code<4 && code>=0){dept_code = dept_name[code];}
        else{System.out.println("Invalid department, Error in input!");}     
    }
    void admit() {
        if(dept_count[code] <= MaxStudentsPerDept){
            super.admit();
            dept[code][dept_count[code]] = this;
            roll = String.format("%4s%ty%04d", dept_code, super.getAdmissionDate(), dept_count[code]+1);
            dept_count[code]++;
        }else{
            System.out.println("No room for new student in this department");
        }
        
    }
    boolean printMarkSheet() {
        System.out.println("\nStudent Department Code: "+dept_code);
        return super.printMarkSheet();
    }
    static int StudentsAdmittedinDept(int code){return dept_count[code];}
    static final Comparator<deptStudent> Rank = new Comparator<deptStudent>() {
        public int compare(deptStudent a, deptStudent b) 
            {return Float.compare(b.TotalMarks(), a.TotalMarks());}
    };
    static void RankbyDept(){
        int code;
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose department : ");
        System.out.println("1:BCSE 2:MECH 3:ETCE 4:BELE");
        System.out.print("Enter department number : ");
        code = scan.nextInt();
        code--;
        if(code<4 && code>=0){
            Arrays.sort(dept[code],0,dept_count[code],Rank);
            System.out.println("Sorted List : ");
            for(int i=0; i<dept_count[code]; i++){
                System.out.println("Roll : "+dept[code][i].getRoll()+"\tTotal Marks : "+dept[code][i].TotalMarks()+"\tName : "+dept[code][i].getName());
            }
        }
        else{System.out.println("Invalid department, Error in input!");}   
    }
    static void RemoveBasedOnMarks(){
        String buff = "";
        float required;
        Scanner scan = new Scanner(System.in);
        System.out.print("Required total marks not to be remove  :  ");
        required = scan.nextFloat();
        buff = scan.nextLine();
        for(int i=0; i< admitted; i++){
            if( StudentList.get(i).marked() && StudentList.get(i).TotalMarks()<required ){
                StudentList.remove(i);
                i--;
                admitted--;   
            }
        }
        for(int i=0; i<4; i++){
            int count = 0;
            for(int j=0;j<dept_count[i]; j++)
                if( dept[i][j].marked() && dept[i][j].TotalMarks()<required ){
                    continue;
                }else{
                    dept[i][count]=dept[i][j];
                    count++;
                }
            dept_count[i] = count;
        }
        
        
    }
}
