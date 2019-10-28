package HackingtheCodingInterview.Arrays;

public class Search_Rotated_Array {
	public static int binary_search(int[] arr, int st, int end, int key) {
		// assuming all the keys are unique.
		if (st > end) {
			return -1;
		}

		int mid = st + (end-st)/2;
		
		if (arr[mid] == key) {
			return mid;
		}

		if (arr[st] <= arr[mid] && key <= arr[mid] && key >= arr[st]) {
			return binary_search(arr, st, mid-1, key);
		} else if (arr[mid] <= arr[end] && key >= arr[mid] && key <= arr[end]) {
			return binary_search(arr, mid+1, end, key);
		} else if (arr[end] <= arr[mid]) {
			return binary_search(arr, mid+1, end, key);
		} else if (arr[st] >= arr[mid]) {
			return binary_search(arr, st, mid-1, key);
		}
		return -1;
	}
	
	//LC33: Recursive 
	public static int search2(int[] nums, int target) {
		return binarySearch(nums, 0, nums.length-1, target);
	}
	
	private static int binarySearch(int[] nums, int left, int right, int target) {
		if(left > right) return -1;
		
		int mid = (left+right)/2;
		
		if(nums[mid] == target) 
			return mid;
		
		if(nums[left] <= nums[mid]) {	//e.g. 3,4,5,6,1,2
			if(nums[left] <= target && target <nums[mid]) {		//check the sorted side ONLY, no = for mid
				return binarySearch(nums, left, mid-1, target);		 
			} else {
				return binarySearch(nums, mid+1, right, target);	 
			}
		} else {						//e.g. 5,6,1,2,3,4
			if(nums[mid] < target && target <= nums[right ]) {	//check the sorted side ONLY, no = for mid		
				return binarySearch(nums, mid+1, right, target);
			} else 
				return binarySearch(nums, left, mid-1, target);		 
		}
	}
	static int binary_search_rotated(int[] arr, int key) {
		return binary_search( arr, 0, arr.length-1, key);
	}
	public static void main(String []args){
		int[] v1 = {6, 7, 1, 2, 3, 4, 5};
		System.out.println("Key(3) found at: "+binary_search_rotated(v1, 3));
		System.out.println("Key(6) found at: "+binary_search_rotated(v1, 6));
		System.out.println("Key(3) found at: "+search2(v1, 3));
		System.out.println("Key(6) found at: "+search2(v1, 6));
		int[] v2 = {4, 5, 6, 1, 2, 3};
		System.out.println("Key(3) found at: "+binary_search_rotated(v2, 3));
		System.out.println("Key(6) found at: "+binary_search_rotated(v2, 6));   
		System.out.println("Key(3) found at: "+search2(v2, 3));
		System.out.println("Key(6) found at: "+search2(v2, 6));
		
		System.out.println("Key(6) found at: "+search2(new int[] {5,1,2,3,4}, 1));
	}
}
