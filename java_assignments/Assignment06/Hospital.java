package java_assignments.Assignment06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

import javax.print.Doc;

public class Hospital {
    static int pidcount = 0;
    static int docidcount = 0;
    static int assigndoc = 0;
    static ArrayList<Doctor> DocList = new ArrayList<Doctor>();
    static HashMap<Doctor,HashSet<Patient>> DocPatMap = new HashMap<Doctor,HashSet<Patient>>();


    static boolean SearchPatSSN(String SoSeq){
        for(var PatSet : DocPatMap.values()){
            for(Patient P : PatSet){
                if(P.pinfo.SSN.equalsIgnoreCase(SoSeq))
                    return true;
            }
        }
        return false;
    }
    static boolean RegisterPatient(){
        Scanner scan = new Scanner(System.in);
        Patient tempPatient = new Patient();
        System.out.println("Enter Patient Details :");
        tempPatient.Setpinfo();
        
        if(SearchPatSSN(tempPatient.pinfo.SSN)){
            System.out.println("Social Sequrity Number is not UNIQUE");
            return false;
        }

        System.out.println("\n\tInformation recorded");
        System.out.print("Admit Patient? [y/n] "); 
        char choice2 = Character.toLowerCase(scan.next().charAt(0));
        if(choice2 == 'y') {
            String tempID = String.format("PATIENT%04d", ++pidcount);
            tempPatient.setid(tempID);
            if(DocList.isEmpty()){ System.out.println("Non doctor to assign"); return false;}
            tempPatient.Dr = DocList.get(assigndoc % DocList.size());
            assigndoc++;
            HashSet<Patient> Patsetfordoc = DocPatMap.containsKey(tempPatient.Dr) ? DocPatMap.get(tempPatient.Dr) : new HashSet<Patient>();
            Patsetfordoc.add(tempPatient);
            DocPatMap.put(tempPatient.Dr, Patsetfordoc);

        }else {System.out.println("Input Cancelled. Not admitted");}
        return true;

    }
    static boolean RecruitDoctor(){
        Scanner scan = new Scanner(System.in);
        Doctor tempdoc = new Doctor();
        System.out.print("Name of Doctor : ");
        tempdoc.name = scan.nextLine().trim();

        for(Doctor D : DocList){
            if(D.name.equalsIgnoreCase(tempdoc.name)){
                System.out.println("Doctor already exists with this name.");
                return false;
            }
        }

        System.out.print("Recruit Doctor? [y/n] "); 
        char choice2 = Character.toLowerCase(scan.next().charAt(0));
        if(choice2 == 'y') {
            tempdoc.id = String.format("Doctor%04d", ++docidcount);
            DocList.add(tempdoc);
        }else {System.out.println("Input Cancelled. Not admitted");}
        return true;
        
    }
    static boolean RecordObservations(String patientID){
        Patient temp = new Patient();
        boolean found = false;
        for(var PatSet : DocPatMap.values())
            for(Patient P : PatSet){
                if(P.id.equalsIgnoreCase(patientID)){
                    temp = P;
                    found = true;
                }
            }
        
        if(found){
            temp.SetOb();
            HashSet<Patient> patset = DocPatMap.get(temp.Dr);
            patset.add(temp);

        }else{System.out.println("\tPatient not found");}


        
        return found;

    }
    static boolean DischargePatient(String patientID){
        Patient temp = new Patient();
        boolean found = false;
        for(var PatSet : DocPatMap.values())
            for(Patient P : PatSet){
                if(P.id.equalsIgnoreCase(patientID)){
                    temp = P;
                    found = true;
                }
            }
        
        if(found){
            HashSet<Patient> patset = DocPatMap.get(temp.Dr);
            patset.remove(temp);

        }else{System.out.println("\tPatient not found");}

        return found;

    }
    static void ViewAllDocs(){
        for(Doctor D : DocList){
            D.view();
        }
    }
    static void ViewAllPatients(){
        for(var PatSet : DocPatMap.values())
            for(Patient P : PatSet){
                System.out.println("\n");
                P.view();
            }
    }
}
