import java.util.Scanner;

class fibonacci {
	static int fib(int n) {
		// Declare an array to store FIB no#.
		//Time Complexity: O(n)
		//Extra Space: O(n)
		int f[] = new int[n + 1];
		int i;
		
		// 0th and 1st number of the series are 0 and 1
		f[0] = 0;
		f[1] = 1;
		
		for (i = 2; i <= n; i++) {
			// Add the previous 2 numbers in the series and store it
			f[i] = f[i - 1] + f[i - 2];
		}
		
		return f[n];
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
