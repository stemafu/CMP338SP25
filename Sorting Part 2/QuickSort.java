
public class QuickSort {
	public static void quickSort(int [] nums) {
		quickSort(nums, 0, nums.length-1);
	}
	
	
	private static void quickSort(int [] nums, int low, int high) {
		
		/*
		 * This will be used to sort values in ascending order.
		 */
		
		int pivotIndex;
		
		if(low < high) {
			
			// compute the pivot index
			/* Once we compute the pivot index all values less that the pivot
			 * go to the left and all values greater that the pivot are 
			 * placed on the right to form the left and right subarrays 
			 * respectively. 
			 */
			
			pivotIndex = partition(nums,  low, high);
			quickSort(nums,  low, pivotIndex - 1); // left sub-array
			quickSort(nums, pivotIndex + 1, high ); // right sub-array
			
			
		}
		
		
	}
	
	private static int partition(int [] nums, int low, int high) {
		
		int pivot = nums[low];
		
		int low1 = low;
		
		for(int i = low + 1; i <= high; i++) {
			
			if(nums[i] < pivot) {
				low1++;	
				int temp = nums[i];
				nums[i] = nums[low1];
				nums[low1] = temp;
				
			}
		}
		
		int temp = nums[low];
		nums[low] = nums[low1];
		nums[low1] = temp;
		
		
		return low1;
	}
	
	public static void main(String [] args) {
		int [] nums = {10, 3, 7, 15, 20, 30, 9};
		
		quickSort(nums);
		
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

}
