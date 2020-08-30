package LeetCode;

/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:
Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true

Example 2:
Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false

Follow up:
This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
Would this affect the run-time complexity? How and why?
 */
public class n081_Search_in_Rotated_Sorted_Array_II {
	public boolean search(int[] nums, int target) {
		int left=0;
		int right=nums.length-1;

		while(left<=right) {
			int mid = left + (right - left)/2; //(left+right)/2;
			
			if(nums[mid]==target) {
				return true;
			}

			if(nums[left] < nums[mid]) {			//cant' use LC33 <=, need <
				if(nums[left] <= target && target < nums[mid]){			//e.g. [1,3,5] for <=
					right = mid-1;
				} else {
					left = mid+1;
				}
			}else if (nums[left] > nums[mid]) {
				if(nums[mid] < target && target <= nums[right]){		//e.g. [5,1,3] for <=
					left = mid+1;
				}else {
					right = mid-1;
				}
			}else {			
				left++;				//this diff for deal with duplicate number
			}    
		}
		
		return false; 
	}
	
	public static void main(String[] args) {
		n081_Search_in_Rotated_Sorted_Array_II obj = new n081_Search_in_Rotated_Sorted_Array_II();
		int[] nums = {2,3,4,1,1,2};
		int target = 1;
		//System.out.println(obj.search(nums, target));
		
		//System.out.println(obj.search(new int[] {1,3,1,1,1}, 3));
		System.out.println(obj.search(new int[] {1,3,5}, 1));
		System.out.println(obj.search(new int[] {5,1,3}, 3));
	}
}
