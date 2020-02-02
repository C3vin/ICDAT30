package LeetCode;

/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:
Input: [1,3,5,6], 5
Output: 2

Example 2:
Input: [1,3,5,6], 2
Output: 1

Example 3:
Input: [1,3,5,6], 7
Output: 4

Example 4:
Input: [1,3,5,6], 0
Output: 0
 */
public class n035_Search_Insert_Position {
	public int searchInsert(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		int left = 0;
		int right = nums.length-1;
		
		while(left <= right) {
			int Mid = (left+right)/2;
			if(nums[Mid] == target) {
				return Mid;
			}
			if(nums[Mid] < target) {
				left = Mid+1;
			} else
				right = Mid-1;
		}
		return left;								//return left
	}
	
	public static void main(String[] args) {
		n035_Search_Insert_Position obj = new n035_Search_Insert_Position();
		int[] nums = {1,3,5,6};
		System.out.println(obj.searchInsert(nums, 5));
	}
}
