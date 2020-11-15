package LeetCode;

/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.
You may assume no duplicate exists in the array.
Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
 */
public class n033_Search_in_Rotated_Sorted_Array {
	//LC33 - LC81 template 
	//sol1: Iterative
	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;

		while(left <= right) {										//Boundary <=
			int mid = left + (right-left)/2; 	//we can changed this rather than (left+right)/2;
			
			if(nums[mid] == target) 								//nums[mid] not only mid !!!
				return mid;

			if(nums[left] <= nums[mid]) {		//e.g. 3,4,5,6,1,2			
				if(nums[left] <= target && target < nums[mid]) {	//Boundary <=
					right = mid-1;
				} else {
					left = mid +1;
				}
			} else {							//e.g. 5,6,1,2,3,4
				//Pivot element is smaller than the first element of the array, i.e. the rotation index is somewhere between 0 and mid. 
				//That means that the part of array from the pivot element to the last one is non-rotated.
				if(nums[mid] < target && target <= nums[right]) {	
					left = mid+1;
				} else {
					right = mid-1;
				}
			}
		}
		
		return -1;
	}

	//sol2: Recursive
	public int search2(int[] nums, int target) {
		return binarySearch(nums, 0, nums.length-1, target);
	}
	
	private int binarySearch(int[] nums, int left, int right, int target) {
		if(left > right) {
			return -1;
		}
		
		int mid = left + (right-left)/2;
		
		if(nums[mid] == target) {
			return mid;
		}
		
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
		System.out.println(obj.search(nums, 0));
		System.out.println(obj.search2(nums, 5));
		
		System.out.println(obj.search(new int[] {5,1,3}, 3));
	}
}
