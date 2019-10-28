package LeetCode;

public class n033_Search_in_Rotated_Sorted_Array {
	//sol1: Iterative
	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;

		while(left<=right) {						//Boundary <=
			int mid = (left+right)/2;
			if(nums[mid] == target) 
				return mid;

			if(nums[left] <= nums[mid]) {						//Boundary <=
				if(nums[left]<=target && target < nums[mid]) {	//Boundary <=
					right = mid-1;
				} else
					left = mid +1;
			}else {
				if(nums[right]>=target && target > nums[mid]) {	//Boundary >=
					left = mid+1;
				} else
					right = mid-1;
			}
		}
		return -1;
	}

	//sol2: Recursive
	public int search2(int[] nums, int target) {
		return binarySearch(nums, 0, nums.length-1, target);
	}
	
	private int binarySearch(int[] nums, int left, int right, int target) {
		if(left > right) return -1;
		
		int mid = (left+right)/2;
		
		if(nums[mid] == target ) 
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

	public static void main(String[] args) {
		n033_Search_in_Rotated_Sorted_Array obj = new n033_Search_in_Rotated_Sorted_Array();
		int[] nums = {4,5,6,7,0,1,2};
		System.out.println(obj.search(nums, 5));
		System.out.println(obj.search2(nums, 5));
	}
}
