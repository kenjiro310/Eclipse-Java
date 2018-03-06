import java.util.*;

public class Demo {

    public static void main(String[] args) {

        /* This reads the input provided by user
         * using keyboard
         */
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter any number: ");

        // This method reads the number provided using keyboard
        int num = scan.nextInt();

        // Closing Scanner after the use
        scan.close();
        
        // Displaying the number 
        System.out.println("The number entered by user: "+num);
        
        int num2 = num + num;
        System.out.println("The sum of the number entered by twice: "+num2);
        
        int num3 = num - num;
        System.out.println("The difference of the number entered by twice: "+num3);
        
        // Test if num is even or odd..even if divisible 2
        if(num % 2 == 0)
        	System.out.println("Entered number is even");
        else
        	System.out.println("Entered number is odd");
        
        
        if(num > 0)
        {
            System.out.println(num+" is a positive number");
        }
        else if(num < 0)
        {
            System.out.println(num+" is a negative number");
        }
        else
        {
            System.out.println(num+" is neither positive nor negative");
        }
    }
}