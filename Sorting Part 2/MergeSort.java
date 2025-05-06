
public class MergeSort {
	
	public static void mergeSort(int [] nums) {
		int [] tempArray = new int[nums.length];
		mergeSort(nums, tempArray, 0, nums.length - 1);
	}
	
	
	private static void mergeSort(int [] nums, int [] tempArray, int low, int high) {
		/*
		 * This method is recursive. It calls itself.
		 * Any recursive method contains a base case.
		 * The base case is the part the causes the method to stop calling
		 * itself. If you have no base case, then you end up with stackoverflow.
		 * 
		 * And the recursive method also contains a recursive part where the 
		 * method calls itself.
		 */
		//int
		
		// This is the base case that would cause this method to stop calling itself
		if(low >= high) {
			return; 
		}
		
		
		
		int mid = (low + high) / 2;
		//mergeSort(nums, low, mid);
		
		mergeSort(nums, tempArray, low, mid);
		mergeSort(nums, tempArray, mid + 1, high);
		
		merge(nums, tempArray, low, mid, high);
		
		/*System.out.println();
		System.out.println();

		for(int i = low; i <= high; i++) {
			System.out.print(nums[i] + " ");
		
		}
		System.out.println();
		System.out.println();
	*/
		
	}
	
	private static void merge(int [] nums, int [] tempArray, int first, int mid, int last) { 
		/*
		 * We will use this method to merge the two sub array into one subarray at 
		 * each step.
		 * As we are merging the values, we will ensure that each value is placed in 
		 * a sorted order.
		 * We will continue until the entire array has been merged back and we have a sorted
		 * array
		 */
		
		// We need to create local variables that will indicate the subarrays.
		
		
		// This store the low index of the first subarray. 
		int first1 = first;
		int last1 = mid;
		
		int first2 = mid + 1;
		int last2 = last;
		
		int index = first1;
		
		while(first1 <= last1 && first2 <= last2) {
			
			if(nums[first1] < nums[first2]) {
				tempArray[index] = nums[first1];
				first1++;
			}else {
				tempArray[index] = nums[first2];
				first2++;
			}
			index++;
		}
		
		// We want to copy the unfinished subarray - first subarray
		// This for the first sub array
		
		while(first1 <= last1) {
			tempArray[index] = nums[first1];
			first1++;
			index++;
		}
		
		// We want to copy the remaining values from the second sub-array
		while(first2 <= last2) {
			tempArray[index] = nums[first2];
			first2++;
			index++;
			
		}
		
		// We now need copy the values from the temp array back to the original array
		for(index = first; index <= last; index++) {
			nums[index] = tempArray[index];
		}
		
		
		
	}

	public static void main(String[] args) {
		
		
		int [] nums = {4, 2, 1, 6, 7};
		System.out.println("");
		//mergeSort(nums, 0, nums.length - 1);
		
		mergeSort(nums);

	}

}
