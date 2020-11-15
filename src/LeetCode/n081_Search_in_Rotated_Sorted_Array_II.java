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
	
	public boolean search2(int[] nums, int target) {
		return helper(nums, target, 0, nums.length-1);
	}
	
	private boolean helper(int[] nums, int target, int left, int right) {
         if(left > right) {
             return false;    
         }
        
        int mid = left + (right-left)/2;        //(left+right)/2
        
        if(nums[mid] == target) {
            return true;
        }
        
        if(nums[left] < nums[mid]) {   //e.g. 3,4,5,6,1,2
            if(nums[left] <= target && target < nums[mid]) {
                 helper(nums, target, left, mid-1);
            } else {
                 helper(nums, target, mid+1, right);
            }
        } else if(nums[left] > nums[mid]){                        //e.g. 5,6,1,2,3,4
            if(nums[mid] < target && target <= nums[right]) {
                 helper(nums, target, mid+1, right);
            } else {
                 helper(nums, target, left, mid-1);
            }
        } else {
        	helper(nums, target, left+1, mid);					  //e.g. 3,3,5,0,0,1,2
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
		
		System.out.println(obj.search2(new int[] {3,1}, 1));
	}
}
