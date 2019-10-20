package LeetCode;

import java.util.Arrays;

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
	/*    0 1 2 3 4
	 *    1,3,4,2,2 len=5
	 *    mid=2, count=3
	*/
	//cs time:O(nlogn) space:O(1)
	public int findDuplicate(int[] nums) {
		int min = 0;
		int max = nums.length-1;
		while(min <= max) {
			int mid = (max - min)/2 + min;
			int count = 0;
			for(int i=0; i<nums.length; i++) {
				if(nums[i] <= mid) {
					count++;
				}
			}
			if(count > mid) {
				max = mid-1;
			} else {
				min = mid+1;
			}
		}
		return min;
	}
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
	public static void main(String[] args) {
		n287_Find_the_Duplicate_Number obj = new n287_Find_the_Duplicate_Number();
		System.out.println(obj.findDuplicate(new int[] {1,3,4,2,2}));
		System.out.println(obj.findDuplicate(new int[] {3,1,3,4,2}));
		System.out.println(obj.findDuplicate2(new int[] {1,3,4,2,2}));
		System.out.println(obj.findDuplicate2(new int[] {3,1,3,4,2}));
	}
}
