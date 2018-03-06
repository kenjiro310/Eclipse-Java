import java.util.*;

//Fibonacci using recursion
public class fibonacci {
	
	//Method that performs recursive fib calculation
	static int fib(int n) {
		if(n <= 1)
			return n;
		//Time Complexity: T(n) = T(n-1) + T(n-2) which is exponential. this implementation does a lot of repeated work 
		//(see the following recursion tree). So this is a bad implementation for nth Fibonacci number.
		
		/*		fib(5)   
        		/                  
  			fib(4)                fib(3)   
			/                      /     
		fib(3)      fib(2)         fib(2)    fib(1)
		/             /           /      
	fib(2)   fib(1)  fib(1) fib(0) fib(1) fib(0)
		/    
	fib(1) fib(0) */
		
		
		return fib(n-1) + fib(n-2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		 Scanner scan = new Scanner(System.in);
	     System.out.print("Enter any number: ");
	     
	     // This method reads the number provided using keyboard
	     int n = scan.nextInt();
	     
	     // Closing Scanner after the use
	     scan.close();
	     
	     //Prints out the fib recursive output
	     System.out.println("The " + n + " fibonacci number is " + fib(n));
	     

	}

}
