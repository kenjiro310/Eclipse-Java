
package drug;

import static drug.DrugMain.drugList;
import static drug.DrugMain.filledList;
import static drug.DrugMain.pharmList;
import static drug.DrugMain.patientList;
import static drug.DrugMain.administeredList;
import java.util.*;
import java.io.*;
import java.sql.Timestamp;

public class perscription {
    static List<drug> perscribedDrugs = new ArrayList<drug>();
    public LinkedList<drug> currentMeds = new LinkedList<drug>();
    String perscribedDrug;//
    String PatientDoctor;//
    String patientName;
    int Id;
    Timestamp timePerscribed;//
    Timestamp timeAdministered;
    Timestamp timeFilled;
    boolean isCompatible;//
    double dosePerDay;//
    double perscriptionDuration;//
    
    public static int perscribeNew(){
        perscription a = new perscription();
        Scanner in = new Scanner(System.in);
        drug perscribe = new drug();
        patient lookup = new patient();
        int z = 0;
        System.out.println("Enter The Patient ID For Which You Wish To Make A Percription For: ");
        a.Id = in.nextInt();
        //looks up patient and gets patient doctor and other info
        for(int q = 0; q < patientList.size();q++){
            lookup = patientList.get(q);
            if(a.Id == lookup.patientId){
                System.out.println("patient found");
                z = q;
                a.PatientDoctor = lookup.getDoctor();
                a.currentMeds = lookup.medications;
                //get list of incompatible drugs for the patient
                /*int c = 0;
                while(c<lookup.medications.size()){
                    System.out.println("size of med list is"+lookup.medications.size());
                    System.out.println(c);
                    drug bad = a.currentMeds.get(c);
                    System.out.println("current med list: "+bad.dName);
                    a.currentMeds.add(bad);
                    c++;
                }*/
            }
        }
        //Gets the drug user wants to add
        System.out.println("Enter The Drug You Would Like To Perscribe: ");
        a.perscribedDrug = in.next();
        //check the database to find the drug
        for(int i=0;i<drugList.size();i++){
            drug current = drugList.get(i);     
            if(a.perscribedDrug.equals(current.dName)){
                System.out.println("Drug match Found");
                //check and update drug stock
                if(current.quantity < 1){
                    System.out.println("Drug OUT OF STOCK");
                    System.out.println("Perscription cancled!");
                    return 0;
                }
                current.quantity = current.quantity - 1;
                //get doseage and check
                System.out.println("Enter The Dose To Perscribe: (dose/day)");
                a.dosePerDay = in.nextDouble();
                if(current.maxDose < a.dosePerDay){
                    System.out.println("The dose perscribed is too high continue? (y/n)");
                    String confirm = in.next();
                    if(confirm.equals("n")){
                        current.quantity = current.quantity + 1;
                        return 0;
                    }
                }
                //check for incompatibility
                int c = 0;
                while(c < current.incompatible.size()){
                    System.out.println("Made it!");
                    String test = current.incompatible.get(c);
                    System.out.println("checking the incompatibility of "+test);
                    int d = 0;
                    while( d < a.currentMeds.size()){
                        drug incomp = a.currentMeds.get(d);
                        System.out.println("comparing with "+incomp.dName);
                        if(incomp.dName.equals(test)){
                            System.out.println("Incompatibility Found!");
                            System.out.println("Continue With Perscription?(y/n)");
                            String command = in.next();
                            if(command.equals("n")){
                                current.quantity = current.quantity + 1;
                                return 0;
                            }    
                        }
                        d++;
                    }
                    c++;
                }                       
                //adds perscribed drug to the current meds list and patient medication
                    a.currentMeds.add(current);
                    patientList.get(z).medications = a.currentMeds;
                    
                //get the rest of the attributes for the perscription
                System.out.println("Enter The Durration For This Perscription: ");
                a.perscriptionDuration = in.nextDouble();
                //get time stamp
                java.util.Date date= new java.util.Date();
                a.timePerscribed = new Timestamp(date.getTime());
                //System.out.println(a.timePerscribed);
                //perscription.perscribedDrugs.add(current);
                pharmList.add(a);
                return 0;
                
            }
        }
        System.out.println("Drug Not Found");
        return 0;
    }
    public static int fillPerscription(){
        Scanner in = new Scanner(System.in);
        perscription toFill = new perscription();
        //checks to see if the perscription is valid
        System.out.println("Enter The Perscription You Wish To Fill: ");
        toFill.patientName = in.next();
        for(int i=0;i<pharmList.size();i++){
            perscription check = pharmList.get(i);
            if(toFill.patientName.equals(check.patientName)){
                System.out.println("Perscription Found");
                System.out.println("Do You Wish to Fill?(y/n)");
                String confirm = in.next();
                if(confirm.equals("n")){
                    return 0;
                }
                java.util.Date date= new java.util.Date();
                check.timeFilled = new Timestamp(date.getTime());
                filledList.add(check);
                pharmList.remove(i);
                System.out.println("Perscription is Ready for pickup in the pharmacy");
                return 0;
            }
        }
        System.out.println("Perscription Not Found");
        return 0;
    }
    public static int showPharmList(){    
        for(int i=0;i<pharmList.size();i++){
            System.out.println(pharmList.get(i).patientName+" | "+pharmList.get(i).timePerscribed+" | "+pharmList.get(i).dosePerDay+"mg of "+pharmList.get(i).perscribedDrug);
        }
        return 0;
    }
    public static int showFilledList(){    
        for(int i=0;i<filledList.size();i++){
            System.out.println(filledList.get(i).patientName+" | "+filledList.get(i).timeFilled);
        }
        return 0;
    }
    public static int removePerscription(){
        Scanner in = new Scanner(System.in);
        perscription d = new perscription();
        System.out.println("Enter The Perscription You Would Like To Delete");
        d.patientName = in.next();
        for(int i=0;i<pharmList.size();i++){
            perscription check = pharmList.get(i);
            if(d.patientName.equals(check.patientName)){
                System.out.println("Sure You Wish To Delete Perscription For "+check.patientName+"? (y/n)");
                String confirm = in.next();
                if(confirm.equals("n")){
                    return 0;
                }
                //remove drug from current meds
                //pat.fName = d.patientName;
                int c = 0;
                while(c<patientList.size()){
                    patient pat = patientList.get(c);
                    if(pat.fName.equals(d.patientName)){
                        int e = 0;
                        while(e < pat.medications.size()){
                            drug old = pat.medications.get(e);
                            if(old.dName.equals(check.perscribedDrug)){
                                pat.medications.remove(check.perscribedDrug);
                            }
                            e++;
                        }
                    }
                    c++;
                }
                check.currentMeds.remove();
                //remove perscription from list
                pharmList.remove(i);
                return 0;
            }
        }
        System.out.println("Perscription Not Found");
        return 0;
    }
    public static int administerPerscription(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the patient name: ");
        String find = in.next();
        int c = 0;
        while(c<filledList.size()){
            perscription check = filledList.get(c);
            if(check.patientName.equals(find)){
               java.util.Date date= new java.util.Date();
               check.timeAdministered = new Timestamp(date.getTime());
               System.out.println(check.dosePerDay+ " of "+check.perscribedDrug+" has been perscribed to "+check.patientName+ " on "+check.timeAdministered);
               filledList.remove(check);
               administeredList.add(check);
               return 0;
            }
            c++;
        }
        return 0;
    }
    public static int showAdministered(){
        for(int i=0;i<DrugMain.administeredList.size();i++){
            perscription show = DrugMain.administeredList.get(i);
            System.out.println(show.dosePerDay+" of "+show.perscribedDrug+ " For "+show.patientName+" at "+show.timeAdministered);
        }
        return 0;
    }
}

