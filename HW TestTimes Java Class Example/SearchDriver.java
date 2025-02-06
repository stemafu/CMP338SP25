
public class SearchDriver {

	//TestTimes 
	
	
	public static int sum(int n) {

		return n * (n + 1) / 2;
	}
	
	
	public TestTimes runLinearSearch(int[] listOfNumbers, int target, int numberOfTimes){
		
		
		TestTimes testTimes = new TestTimes();



		for(int i = 0; i <numberOfTimes; i++) {
			//Before the operation is started, you can obtain the start time:
			long startTime = System.nanoTime();

			// We will place the code that we would like to measure

			
			//int index = linearSearch(listOfNumbers, target);

			int total = sum(1000000);

			//After the operation is completed, you can obtain the end time:
			long endTime = System.nanoTime();

			//Test Time can then be computed:
			long testTime = endTime - startTime;
			testTimes.addTestTime(testTime);
		}
		
		/*
		 * You may need to complete this according to hw instructions
		 */
		
		
		return testTimes;
		
	}

	public static void main(String[] args) {






	}

}
