/*Design and create a hospital information system with the following scenarios.
-> Register a new patient.
-> Each patient is assigned to one doctor, but a doctor can have any number of patients. Patients check in to the
hospital and assigned a doctor if they don't already have one.
-> While in the hospital, doctors record various observations about each patient at various times. Examples of
observations are blood pressure and temperature. Record test results for a patient.
-> The hospital keeps track of all the observations for a given patient until they check out of the hospital. Obtain
all of a patient’s information given the social security number.
NOTE: Patients id will be auto generated*/ 

package java_assignments.Assignment06;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        String buff ="";
        int choice;
        do{
            System.out.println("____________________________________________________________");
            System.out.println("|         :::::::::::::::   Menu   :::::::::::::::         |");
            System.out.println("|             1. Register a new Patient                    |");
            System.out.println("|             2. Recruit a new Doctor                      |");
            System.out.println("|             3. Record Observations of a Patient          |");
            System.out.println("|             4. Discharge a Patient                       |");
            System.out.println("|             5. View All Doctors                          |");
            System.out.println("|             6. View all Patients                         |");
            System.out.println("|                         0 to exit                        |");
            System.out.println("|__________________________________________________________|");
            System.out.print("Enter choice: "); 
            choice = scan.nextInt();
            buff = scan.nextLine();
            switch(choice) {
            case 0: break;
            case 1:
                if(Hospital.RegisterPatient()) System.out.println("The operation completed successfully.");
                else System.err.println("The operation did not complete successfully."); 
                break;
            case 2:
                if(Hospital.RecruitDoctor()) System.out.println("The operation completed successfully.");
                else System.err.println("The operation did not complete successfully."); 
                break;
            case 3:
                System.out.println("Enter Patient id :");
                String ID= scan.nextLine();
                if(Hospital.RecordObservations(ID)) System.out.println("The operation completed successfully.");
                else System.err.println("The operation did not complete successfully.");
                break;
            case 4:
                System.out.println("Enter Patient id :");
                ID= scan.nextLine();
                if(Hospital.DischargePatient(ID)) System.out.println("The operation completed successfully.");
                else System.err.println("The operation did not complete successfully.");
                break;
            case 5:
                System.out.println("\t Doctors : ");
                Hospital.ViewAllDocs();
                break;
            case 6:
                System.out.println("\t Patirnts : ");
                Hospital.ViewAllPatients();
                break;
            default: System.out.println("\t!!!  Invalid Option  !!! "); 
            } 
        } while (choice != 0);    

    }
}
