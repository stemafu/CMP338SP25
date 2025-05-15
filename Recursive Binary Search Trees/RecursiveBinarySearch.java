
public class RecursiveBinarySearch {
	
	public static int binarySearch(int [] nums, int target) {
		return binarySearch(nums,  target, 0, nums.length - 1);
	}

	private static int binarySearch(int [] nums, int target, int low, int high) {
		int mid = (low + high) / 2;

		if(low > high) {
			return -1;
		}else if(target < nums[mid]) {
			high = mid - 1;
			return binarySearch(nums, target, low, high);
		}else if (target > nums[mid]){
			low = mid + 1;
			return binarySearch(nums, target, low, high);
		}else {
			return mid;
		}


		//return mid;
	}

	public static void main(String[] args) {
		int  [] nums = {10, 20, 30, 40, 50, 100, 120, 130, 150};

		int index = binarySearch(nums, 10);
		
		System.out.println(index);

	}

}
