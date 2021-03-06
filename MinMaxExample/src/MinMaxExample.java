import java.util.*;


public class MinMaxExample {

	public static void main(String[] args) {
		//int[] intArray = new int[]{10, 11, 88, 2, 12, 120};
		int num;
		
		Scanner input = new Scanner(System.in);
		System.out.println("How many numbers will be in the array?");
		num = input.nextInt();
		int[] intArray = new int[num];
		
		for(int counter = 0; counter < num; counter++) {
			System.out.println("Enter the number " + (counter+1));
			intArray[counter] = input.nextInt();		
		}
		
		input.close();
		
		System.out.println(Arrays.toString(intArray));
		
		//Bubblesort
		int temp;
		boolean fixed = false;
		
		while(fixed==false){
			fixed=true;
			
		  for(int i = 0; i < intArray.length-1; i++) {
			
			if(intArray[i] > intArray[i+1]) {
			  temp = intArray[i+1];	
			  intArray[i+1] = intArray[i];
			  intArray[i] = temp;
			  fixed = false;
			}
		  }	
					
		}
		
		for(int i = 0; i < intArray.length; i++) {
			System.out.println(intArray[i]);
		}
		
		//Call: Method for getting max value will be called getMax()
		int max = getMax(intArray);
		System.out.println("Maximum value: " +max);
		
		//Call: Method for getting max value will be called getMin()
		int min = getMin(intArray);
		System.out.println("Minimum value: " +min);

	}
	
	//Method for getting the maximum value
	public static int getMax(int[] inputArray){
		int maxValue = inputArray[0];
		
		for(int i=1; i < inputArray.length; i++){
			if(inputArray[i] > maxValue){
				maxValue = inputArray[i];
			}
		}
		return maxValue;
	}
	
	//Method for getting the minimum value
		public static int getMin(int[] inputArray){
			int minValue = inputArray[0];
			
			for(int i=1; i < inputArray.length; i++){
				if(inputArray[i] < minValue){
					minValue = inputArray[i];
				}
			}
			return minValue;
		}

}
