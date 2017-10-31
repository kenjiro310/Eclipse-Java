
package drug;
import java.util.*;
import static drug.DrugMain.drugList;
import static drug.DrugMain.filledList;
import static drug.DrugMain.pharmList;
import static drug.DrugMain.patientList;
//Patient Object 
//Each Patient object represents one patient in the hospital. Each object contains all of the patient's 
//information, such as their name, phone number, address, social security number, room number, the 
//doctor assigned to them, the nurse station corresponding to their room number, previous medical 
//diagnoses, previous and current medications, the times of their next scheduled checkup and 
//medication, and so on. 
public class patient {
    public int patientId;
    public String fName; 
    public String lName; 
    public String tel; 
    public String address; 
    public String insurance; 
    public int SSN; 
    public String doctor; 
    private int nurseStation; 
    public int roomNumber; 
    public String currentDiagnosis;     
    public LinkedList<drug> medications = new LinkedList<drug>();      //stores drug objects of each drug that the //patient is currently taking 
    public LinkedList<String> diagnosisHistory = new LinkedList<String>(); //stores each each diagnosis from most //recent to least 
    private double nextCheckup;                 //time of next checkup 
    private double nextMedication;              //time next medication will be administered 
    private double lastMedication;              //time last medication was administered 
      
    /*public Patient(String fN, String lN, int pN, String adrs, String iP, int social, String doc, int nS, int rN, String cD) { 
        firstName = fN; 
        lastName = lN; 
        phoneNumber = pN; 
        address = adrs; 
        insuranceProvider = iP; 
        SSN = social; 
        doctor = doc; 
        nurseStation = nS; 
        roomNumber = rN; 
        currentDiagnosis = cD;   
    }*/ 
    public static int addPatient(){
        patient a = new patient();
        System.out.println("Enter Patient's First Name: ");
        Scanner in = new Scanner(System.in);
        a.fName = in.next();
        System.out.println("Enter Patient's Last Name: ");
        a.lName = in.next();
        System.out.println("Enter Patient's Telephone Number: ");
        a.tel = in.next();
        System.out.println("Enter Patient's Address: ");
        a.address = in.next();
        System.out.println("Enter Patient's Insureance Provider: ");
        a.insurance = in.next();
        System.out.println("Enter Patient's SSN: ");
        a.SSN = in.nextInt();
        System.out.println("Enter Patient's Doctor: ");
        a.doctor = in.next();
        System.out.println("Enter Patient's Room Number: ");
        a.roomNumber = in.nextInt();
        //adds current medication the patient is on
        System.out.println("Is Patient On Current Medications?(y/n");
        int c = 0;
        String command = in.next();
            if(command.equals("y")){
                while (c<100){
                    System.out.println("Enter A Medication");
                    drug current = new drug();
                    current.dName = in.next();
                    a.medications.add(current);
                    System.out.println("Any Other Medications?(y/n)");
                    command = in.next();
                    if(command.equals("n")){
                        c=500;
                    }
            }
        }
        a.patientId = DrugMain.patientList.size()+1;
        System.out.println("Patient ID: "+a.patientId);
        patientList.add(a);
        return 0;
    }
    public static int showPatientInfo(){
        showPatientIds();
        //patient find = new patient();
        System.out.println("Enter The Patient ID For Which You Wish To View: ");
        Scanner in = new Scanner(System.in);
        //find.patientId = in.nextInt();
        int find = in.nextInt();
        for(int i=0; i<patientList.size();i++){
            patient check = patientList.get(i);
            if(find == check.patientId){
                System.out.println("Patient Found");
                System.out.println("Patient ID: "+check.patientId);
                System.out.println("Name: "+check.fName+" "+ check.lName);
                System.out.println("Doctor: "+check.doctor);
                System.out.println("Room Number: "+check.roomNumber);
                System.out.println("Current Diagnosis: "+check.currentDiagnosis);
                System.out.println("Current Meds: ");
                int c = 0;
                while(c<check.medications.size()){
                    drug med = check.medications.get(c);
                    System.out.println(med.dName);
                    c++;
                }
            return 0;    
            }
        }
        System.out.println("Patient Not Found");
        return 0;
    }
    public static int editPatientInfo(){
        showPatientIds();
        System.out.println("Enter The Patient ID For Which You Wish To View: ");
        Scanner in = new Scanner(System.in);
        int find = in.nextInt();
        for(int i = 0; i<patientList.size(); i++){
            patient check = patientList.get(i);
            if(check.patientId == find){
                System.out.println("patient Found");
                System.out.println("Enter a property to edit: ");
                System.out.println("1 For First Name");
                System.out.println("2 For Last Name");
                System.out.println("3 For Phone Number");
                System.out.println("4 For Address");
                System.out.println("5 For Insurance Provider");
                System.out.println("6 For SSN");
                System.out.println("7 For Doctor");
                System.out.println("8 For Room Number");
                System.out.println("9 For current Diagnosis");
                System.out.println("10 For Current Medications");
                System.out.println("11 For diagnosis History");
                String command = in.next();
                if(command.equals("1")){
                    System.out.println("Enter New Patient First Name: ");
                    String update = in.next();
                    check.fName = update;
                    return 0;
                }
                if(command.equals("2")){
                    System.out.println("Enter New Patient Last Name: ");
                    String update = in.next();
                    check.lName = update;
                    return 0;
                }
                if(command.equals("3")){
                    System.out.println("Enter New Patient Phone Number: ");
                    String update = in.next();
                    check.tel = update;
                    return 0;
                }
                if(command.equals("4")){
                    System.out.println("Enter New Patient Address: ");
                    String update = in.next();
                    check.address = update;
                    return 0;
                }
                if(command.equals("5")){
                    System.out.println("Enter New Patient Insureance Provider: ");
                    String update = in.next();
                    check.insurance = update;
                    return 0;
                }
                if(command.equals("6")){
                    System.out.println("Enter New Patient SSN: ");
                    int update = in.nextInt();
                    check.SSN = update;
                    return 0;
                }
                if(command.equals("7")){
                    System.out.println("Enter New Patient Doctor: ");
                    String update = in.next();
                    check.doctor = update;
                    return 0;
                }
                if(command.equals("8")){
                    System.out.println("Enter New Patient Room Number: ");
                    int update = in.nextInt();
                    check.roomNumber = update;
                    return 0;
                }
                if(command.equals("9")){
                    System.out.println("Enter New Patient Diagnosis: ");
                    String update = in.next();
                    check.currentDiagnosis = update;
                    check.diagnosisHistory.add(update);
                    return 0;
                }
                if(command.equals("10")){
                    System.out.println("Are You Sure You Wish To Re-Write All Current Medications? (y/n)");
                    command = in.next();
                    if(command.equals("n")){
                        return 0;
                    }
                    check.medications.clear();
                    System.out.println("Enter All Current Medications: ");
                    while(command.equals("y")){
                        drug update = new drug();
                        update.dName = in.next();
                        int c = 0;
                        while(c<drugList.size()){
                            drug lookup = new drug();
                            lookup = drugList.get(c);
                            if(update.dName.equals(lookup.dName)){
                                System.out.println("Match Found");
                                check.medications.add(lookup);
                                System.out.println("Enter Another Medication? (y/n)");
                                command = in.next();
                                System.out.println("Enter Next Medication: ");
                            }
                            c++;
                        }
                    }
                    return 0;
                }
                if(command.equals("11")){
                    System.out.println("Are Your Sure You Wish To RE-WRITE This Patient's Diagnosis History? (y/n): ");
                    command = in.next();
                    if(command.equals("n")){
                        return 0;
                    }
                    check.diagnosisHistory.clear();
                    while(command.equals("y")){
                        System.out.println("Enter a Diagnosis: ");
                        String update = in.next();
                        check.diagnosisHistory.add(update);
                        System.out.println("Add Another Diagnosis?(y/n)");
                        command = in.next();
                    }
                    return 0;
                }
                
            }
        }
        
        return 0;
    }
    public static int showDiagnosisHistory(){
        showPatientIds();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter The Patient ID For Which You Wish To View: ");
        int find = in.nextInt();
        int c = 0;
        while(c < patientList.size()){
            patient check = patientList.get(c);
            if(find == check.patientId){
                System.out.println("Diagnosis History for "+check.fName+" "+check.lName+": ");
                int d = 0;
                while(d < check.diagnosisHistory.size()){
                    String diag = check.diagnosisHistory.get(d);
                    System.out.println(diag);
                    d++;
                }
            }
            c++;
        }
        return 0;
    }
    public static int addDiagnosis(){
        showPatientIds();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter The Patient ID For Which You Wish To View: ");
        int find = in.nextInt();
        int c = 0;
        while(c < patientList.size()){
            patient check = patientList.get(c);
            if(find == check.patientId){
                System.out.println("Patient Found");
                System.out.println("Enter new Diagnosis for "+check.fName+" "+check.lName+": ");
                String overwrite = in.next();
                check.currentDiagnosis = overwrite;
                check.diagnosisHistory.add(overwrite);
            }
            c++;
        }  
        return 0;
    }
    public static int showPatientIds(){
        
        for(int i=0;i<patientList.size();i++){
            patient look = patientList.get(i);
            System.out.println(look.patientId+" "+look.fName+" "+look.lName);
        }        
        return 0;
    }
    public String getFirstName() { 
        return fName; 
    } 
      
    public String getLastName() { 
        return lName; 
    } 
      
    public String getPhoneNumber() { 
        return tel; 
    } 
      
    public String getAddress() { 
        return address; 
    } 
  
    public String getInsuranceProvider() { 
        return insurance; 
    } 
      
    public int getSSN() { 
        return SSN; 
    } 
  
    public String getDoctor() { 
        return doctor; 
    } 
  
    public int getNurseStation() { 
        return nurseStation; 
    } 
  
    public int getRoomNumber() { 
        return roomNumber; 
    } 
      
    public String getCurrentDiagnosis() { 
        return currentDiagnosis; 
    } 
  
    public LinkedList getMedications() { 
        return medications; 
    } 
      
    public double getNextCheckup() { 
        return nextCheckup; 
    } 
  
    public double getNextMedication() { 
        return nextMedication; 
    } 
      
    public void changeFirstName(String newFirstName) { 
        fName = newFirstName ; 
    } 
      
    public void changeLastName(String newLastName) { 
        lName = newLastName; 
    } 
      
    public void changePhoneNumber(String newPhoneNumber) { 
        tel = newPhoneNumber; 
    } 
      
    public void changeAddress(String newAddress) { 
        address = newAddress; 
    } 
  
    public void changeInsuranceProvider(String newInsuranceProvider) { 
        insurance = newInsuranceProvider; 
    } 
      
    public void changeSSN(int newSSN) { 
        SSN = newSSN; 
    } 
  
    public void changeDoctor(String newDoctor) { 
        doctor = newDoctor; 
    } 
  
    public void changeNurseStation(int newNurseStation) { 
        nurseStation = newNurseStation; 
    } 
  
    public void changeRoomNumber(int newRoomNumber) { 
        roomNumber = newRoomNumber; 
    } 
      
    public void setNextCheckup(int newCheckupTime) { 
        nextCheckup = newCheckupTime; 
    } 
      
    public void setNextMed(int newMedTime) { 
        lastMedication = nextMedication; 
        nextMedication = newMedTime; 
    } 
      
    public void newCurrentDiagnosis(String cD) { 
        currentDiagnosis = cD; 
        diagnosisHistory.addFirst(currentDiagnosis); 
    } 
      
    public void newMedication(drug d) { 
        medications.addFirst(d); 
    } 
}
