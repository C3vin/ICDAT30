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
		
		if(nums[left] <= nums[mid]) {
			if(nums[left] <= target && target <nums[mid]) {
				return binarySearch(nums, left, mid-1, target);		//return
			} else {
				return binarySearch(nums, mid+1, right, target);	//F: left=mid+1
			}
		} else {
			if(target <= nums[right] && nums[mid] < target) {
				return binarySearch(nums, mid+1, right, target);
			} else 
				return binarySearch(nums, left, mid-1, target);		//F: right=mid-1
		}
	}

	public static void main(String[] args) {
		n033_Search_in_Rotated_Sorted_Array obj = new n033_Search_in_Rotated_Sorted_Array();
		int[] nums = {4,5,6,7,0,1,2};
		for(int i=0; i<nums.length; i++) 
			System.out.println(obj.search(nums, nums[i]));
		for(int i=0; i<nums.length; i++) 
			System.out.println(obj.search2(nums, nums[i]));
	}
}
