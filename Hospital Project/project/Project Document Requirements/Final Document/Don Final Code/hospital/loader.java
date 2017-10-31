
package drug;

import java.util.*;
import java.io.*;
import java.sql.Timestamp;
import java.io.File;
import java.io.FileNotFoundException;

public class loader {

    public static int loadDrugDB(){
        try {
           File file = new File("C:\\Documents and Settings\\Administrator\\Desktop\\drugdb.txt");
           Scanner scanner = new Scanner(file);
           while (scanner.hasNext()) {
               if(scanner.next().equals("[")){
                   drug a = new drug();
                   String incoming = scanner.next();
                   while(!incoming.equals("]")){
                       a.dName = incoming;
                       if(scanner.next().equals("*")){
                           String marker = scanner.next();
                           while(!marker.equals("$")){
                           a.incompatible.add(marker);
                           marker = scanner.next();
                           }
                       }
                       a.uses = scanner.next();
                       String quantity = scanner.next();
                       double quant = Double.parseDouble(quantity);
                       a.quantity = quant;
                       String maxDose = scanner.next();
                       double max = Double.parseDouble(maxDose);
                       a.maxDose = max;
                       String durration = scanner.next();
                       double durr = Double.parseDouble(durration);
                       a.durration = durr;
                       incoming = scanner.next();
                   }
                   DrugMain.drugList.add(a);
                   //System.out.println("---------");
               }

           }
           scanner.close();
      } catch (FileNotFoundException e) {
       e.printStackTrace();
      }



        return 0;
    }
    public static int loadPatientDB(){
     
    try {
           File file = new File("C:\\Documents and Settings\\Administrator\\Desktop\\patientdb.txt");
           Scanner scanner = new Scanner(file);
           while (scanner.hasNext()) {
               if(scanner.next().equals("[")){
                   patient a = new patient();
                   String incoming = scanner.next();
                   while(!incoming.equals("]")){
                       a.fName = incoming;
                       a.lName = scanner.next();
                       a.tel = scanner.next();
                       a.address = scanner.next();
                       a.insurance = scanner.next();
                       String social = scanner.next();
                       int str = Integer.parseInt(social);
                       a.SSN = str;
                       a.doctor = scanner.next();
                       String room = scanner.next();
                       str = Integer.parseInt(room);
                       a.roomNumber = str;
                       a.currentDiagnosis = scanner.next();
                       String iD = scanner.next();
                       str = Integer.parseInt(iD);
                       a.patientId = str;
                       incoming = scanner.next();
                   }
                   DrugMain.patientList.add(a);
                   //System.out.println("---------");
               }

           }
           scanner.close();
      } catch (FileNotFoundException e) {
       e.printStackTrace();
      }
        
        return 0;
    }
    
    public static int loadUserDB(){
        
        try {
           File file = new File("C:\\Documents and Settings\\Administrator\\Desktop\\userdb.txt");
           Scanner scanner = new Scanner(file);
           while (scanner.hasNext()) {
               if(scanner.next().equals("[")){
                   user a = new user();
                   String incoming = scanner.next();
                   while(!incoming.equals("]")){
                       a.username = incoming;
                       a.password = scanner.next();
                       a.lastName = scanner.next();
                       a.permission = scanner.next();
                       a.page = scanner.next();
                       incoming = scanner.next();
                   }
                   DrugMain.userList.add(a);
                   //System.out.println("---------");
               }

           }
           scanner.close();
      } catch (FileNotFoundException e) {
       e.printStackTrace();
      }

        return 0;
    }

}
