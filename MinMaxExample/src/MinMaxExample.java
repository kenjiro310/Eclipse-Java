
class MinMaxExample {

	public static void main(String[] args) {
		int array[] = new int[]{10, 11, 88, 2, 12, 120};
		
		//Call: Method for getting max value will be called getMax()
		int max = getMax(array);
		System.out.println("Maximum value: " +max);
		
		//Call: Method for getting max value will be called getMin()
		int min = getMin(array);
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