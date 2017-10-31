
package drug;

import static drug.DrugMain.drugList;
import java.util.*;
import java.io.*;
import java.sql.Timestamp;

public class drug {
    String uses;
    String dName;
    public LinkedList<String> incompatible = new LinkedList<String>();
    double quantity;
    double maxDose;
    double durration;    

    public static int addNew(String command){    
        drug a = new drug();
        System.out.println("Enter A Name For New Drug: ");
        Scanner in = new Scanner(System.in);
        a.dName = in.next();
        System.out.println("Enter The Use For New Drug: ");
        a.uses = in.next();
        System.out.println("Are Any Medications Incompatible With New Drug?(y/n");
        int c = 0;
        command = in.next();
            if(command.equals("y")){
                while (c<100){
                    System.out.println("Enter An Incompatible Medication");
                    drug current = new drug();
                    current.dName = in.next();
                    a.incompatible.add(current.dName);
                    System.out.println("Any Other Incompatible Medications?(y/n)");
                    command = in.next();
                        if(command.equals("n")){
                            c=500;
                        }
                }
            }
        System.out.println("Enter The Max Doseage For New Drug(in ml): ");
        a.maxDose = in.nextDouble();
        System.out.println("Enter The Durration For New Drug: ");
        a.durration = in.nextDouble();
        System.out.println("Enter The Quantity Of New Durg On Hand: ");
        a.quantity = in.nextDouble();
        drugList.add(a);
        System.out.println(drugList.size());    
        return 0;        
    }
    public static int editDrug(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter The Drug You Would Like To Edit: ");
        drug select = new drug();
        select.dName = in.next();
        for(int i=0;i<drugList.size();i++){
            drug current = drugList.get(i);
            System.out.println(current.dName);
            if(current.dName.equals(select.dName)){
                System.out.println("Match found");
                System.out.println("Enter a Feild You Would Like To Edit");
                System.out.println("1 For Name");
                System.out.println("2 For Incompatible");
                System.out.println("3 For Max Dose");
                System.out.println("4 For Durration");
                System.out.println("5 For Quantity");
                System.out.println("E for Escape");
                String command = in.next();
                if(command.equals("1")){
                    System.out.println("Enter The Drug's New Name: ");
                    current.dName = in.next();
                }
                if(command.equals("2")){
                    System.out.println("Enter Revised List of Incompatible Drugs: ");
                    int c = 0;
                    command = in.next();                        
                        while (c<100){
                            System.out.println("Enter An Incompatible Medication");
                            drug edit = new drug();
                            edit.dName = in.next();
                            current.incompatible.add(current.dName);
                            System.out.println("Any Other Incompatible Medications?(y/n)");
                            command = in.next();
                                if(command.equals("n")){
                                    c=500;
                                }
                            }                        
                }
                if(command.equals("3")){
                    System.out.println("Enter The Max Dose: ");
                    current.maxDose = in.nextDouble();
                }
                if(command.equals("4")){
                    System.out.println("Enter The Durration ");
                    current.durration = in.nextDouble();
                }
                if(command.equals("5")){
                    System.out.println("Enter The Quantity: ");
                    current.quantity = in.nextDouble();
                }
                if(command.equals("E")){
                    return 0;
                }
                return 0;
            }
        }
        System.out.println("No Match Found Please Try Again");
        editDrug();
        return 0;
        }
    public static int showList(){
        for(int i=0;i<drugList.size();i++){
            drug current = drugList.get(i);
            System.out.println(current.dName);
        }
        return 0;
    }
    public static int removeDrug(){
        Scanner in = new Scanner(System.in);
        String confirm;
        System.out.println("Enter The Drug You Would Like To Delete: ");
        drug select = new drug();
        select.dName = in.next();
        for(int i=0;i<drugList.size();i++){
            drug current = drugList.get(i);
            System.out.println(current.dName);
            if(current.dName.equals(select.dName)){
                System.out.println("Match found");
                System.out.println("Are You Sure You Want To Delete "+current.dName+"?(y/n)");
                confirm = in.next();
                if(confirm.equals("y")){
                    drugList.remove(i);
                    return 0;
                }
            }
        }
    System.out.println("Drug Not Found");
    return 0;
    }
    public static int showStock(){
        for(int i=0;i<drugList.size();i++){
            drug current = drugList.get(i);
            System.out.println("Currently "+current.quantity+" of "+current.dName+" on hand");
        }
        return 0;
    }
}


