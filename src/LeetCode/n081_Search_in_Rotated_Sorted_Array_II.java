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
	
	//Good!!! 
	/* https://www.cnblogs.com/grandyang/p/4325840.html
	现在数组中允许出现重复数字，这个也会影响我们选择哪半边继续搜索，由于之前那道题不存在相同值，
	我们在比较中间值和最右值时就完全符合之前所说的规律：如果中间的数小于最右边的数，则右半段是有序的，
	若中间数大于最右边数，则左半段是有序的。而如果可以有重复值，就会出现来面两种情况，[3 1 1] 和 [1 1 3 1]，
	对于这两种情况中间值等于最右值时，目标值3既可以在左边又可以在右边，那怎么办么，对于这种情况其实处理非常简单，
	只要把最右值向左一位即可继续循环，如果还相同则继续移，直到移到不同值为止，然后其他部分还采用 Search in Rotated Sorted Array 中的方法
	 */
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
