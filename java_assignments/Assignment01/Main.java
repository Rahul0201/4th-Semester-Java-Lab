/*Design a STUDENT class to store roll, name, course, admission date and marks in 5 subjects taken from user.
Create an array of STUDENT objects. Provide methods corresponding to admission date and receiving marks,
preparing mark sheet. Support must be there to show the number of students who have taken admission.

Inherit Student class and override the input method so as to input the department of each student. Search and
display a sorted list of students of one department or students ​ based on scoring criteria. Create an arraylist of
students and remove a student based on certain criterion and then call gc()​and check for free memory.
​ 
NOTE: Student roll/ID should be fixed length which include department name, admission year and roll and it
should be auto generated (no random roll no will be accepted). Consider at least four departments. 1st four
characters: dept, 2nd two characters : year, last three characters: roll no
Example: ​ if a student is in dept. Of Computer Science and Engg.
1st admission : BCSE​ 18 001 ​(considering max 100 students in each dept.)
2nd admission : BCSE1​8002
if a student is in dept. Of Electronics and Telecommunication Engg.
1st admission : ETCE​ 18001​(considering max 100 students in each dept.)
3rd admission : ETCE​ 18003*/

package java_assignments.Assignment01;

import java.util.Scanner;

class Main {
    public static void main (String args[]){
       deptStudent s;
       boolean showMenu = true;
       Scanner scan = new Scanner(System.in);

       while(showMenu){
            System.out.println("_____________________________________________________________________");
            System.out.println("|                 ::::Choices available in menu::::                 |");
            System.out.println("|     1. Add Student                                                |");
            System.out.println("|     2. Assign marks to student (evaluate)                         |");
            System.out.println("|     3. Print Mark Sheet of Student                                |");
            System.out.println("|     4. How many students have taken admission?                    |");
            System.out.println("|     5. Get Ranked List by Department (on total/average marks)     |");
            System.out.println("|     6. remove all students with total marks less than required    |");
            System.out.println("|     0. Exit                                                       |");
            System.out.println("|___________________________________________________________________|");
            System.out.print("\nEnter choice : ");
            int choice = scan.nextInt();
            switch(choice){
                case 0 : showMenu = false; break;
                case 1 :
                    s = new deptStudent();
                    s.input();
                    System.out.println("");
                    System.out.print("Admit Student? [y/n] "); 
                    char choice2 = Character.toLowerCase(scan.next().charAt(0));
                    if(choice2 == 'y') {s.admit(); System.out.println("Student Admitted, Roll : "+s.getRoll());}
                    else {System.out.println("Input Cancelled. Not admitted");}
                    break;
                case 2 :
                    System.out.print("Enter Roll Number: "); 
                    String roll = scan.next();
                    STUDENT s1 = STUDENT.search(roll);
                    if( s1 == null) System.err.println("Student Not Found");
                    else {System.out.println(s1.getName()+": "); s1.setMarks();}
                    break;
                case 3 :
                    System.out.print("Enter Roll Number: "); 
                    roll = scan.next();
                    s1 = STUDENT.search(roll);
                    if( s1 == null){System.err.println("Student Not Found");}
                    else {s1.printMarkSheet();}
                    break;
                case 4 :
                    System.out.println("Total students admitted = "+STUDENT.numStudentsAdmitted());
                    for(int i=0; i<deptStudent.NumberOfDepartments; i++)
                        System.out.println("Students admitted in "+deptStudent.dept_name[i]+" = "+deptStudent.StudentsAdmittedinDept(i));
                    break;
                case 5 : 
                    deptStudent.RankbyDept();
                    break;
                case 6 :
                    Runtime r = Runtime.getRuntime();
                    deptStudent.RemoveBasedOnMarks();
                    long mem = r.freeMemory();
                    System.out.println("Free memory before calling gc : "+mem+" bytes");
                    r.gc();
                    mem = r.freeMemory();
                    System.out.println("Free memory after calling gc : "+mem+" bytes");
                    break;
                default: System.out.println("\n\tError! Invalid choice.");
            }

       }
        
    }
}