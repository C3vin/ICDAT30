package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
prove that at least one duplicate number must exist. Assume that there is only one duplicate number, 
find the duplicate one.

Example 1:
Input: [1,3,4,2,2]
Output: 2

Example 2:
Input: [3,1,3,4,2]
Output: 3

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class n287_Find_the_Duplicate_Number {
	//time:O(nlogn) space:O(1)
	public int findDuplicate2(int[] nums) {
		Arrays.sort(nums);
		
		for(int i=1; i<nums.length; i++) {
			if(nums[i] == nums[i-1]) {
				return nums[i];
			}
		}
		return -1;
	}
	
	//O(n) O(n) space		//LC 142
	public int findDuplicate4(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        
        for(int num : nums) {
            if(set.contains(num)) {
                return num;
            }
            
            set.add(num);
        }

        return -1;
    }
	
	//https://leetcode.com/problems/find-the-duplicate-number/discuss/72846/My-easy-understood-solution-with-O(n
	//Floyd's Tortoise and Hare (Cycle Detection)
	//O(n) O(1) space !!!
	//the beauty of this problem is that nums[0] is always the entrance to the cycle which has duplicate numbers, because no one can jump back to nums[0]. 
	public int findDuplicate3(int[] nums) {
		int slow = nums[0];
		int fast = nums[nums[0]];		//s&f not the same!!!
		//寻找相遇点
		while(slow != fast) {			//!= not <
			slow = nums[slow];
			fast = nums[nums[fast]];
		}
		
		//slow 从起点出发, fast 从相遇点出发, 一次走一步			
		slow = 0;						//0 not nums[0]
		while(slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		
		return slow;
	}
	
	/*    0 1 2 3 4
	 *    1,3,4,2,2 len=5
	 *    mid=2, count=3
	*/
	//cs time:O(nlogn) space:O(1)    Don't use it
	public int findDuplicate(int[] nums) {
		int left = 0;
		int right = nums.length-1;
		while(left <= right) {
			int mid = left + (right - left)/2;
			int count = 0;
			
			for(int i=0; i<nums.length; i++) {
				if(nums[i] <= mid) {
					count++;
				}
			}
			
			if(count > mid) {
				right = mid-1;
			} else {
				left = mid+1;
			}
		}
		return left;
	}
	
	public static void main(String[] args) {
		n287_Find_the_Duplicate_Number obj = new n287_Find_the_Duplicate_Number();
//		System.out.println(obj.findDuplicate(new int[] {1,3,4,2,2}));
//		System.out.println(obj.findDuplicate(new int[] {3,1,3,4,2}));
//		System.out.println(obj.findDuplicate2(new int[] {1,3,4,2,2}));
//		System.out.println(obj.findDuplicate2(new int[] {3,1,3,4,2}));
//		System.out.println(obj.findDuplicate3(new int[] {1,3,4,2,2}));
		System.out.println(obj.findDuplicate3(new int[] {3,1,3,4,2}));
	}
}
