package LeetCode;

/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.

Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:
Input: target = 4, nums = [1,4,4]
Output: 1

Example 3:
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 */
public class n209_Minimum_Size_Subarray_Sum {
	//Good!!!
	//Ref: https://www.cnblogs.com/grandyang/p/4501934.html
	/*
	先来看 O(n) 的解法，需要定义两个指针 left 和 right，分别记录子数组的左右的边界位置，
	然后让 right 向右移，直到子数组和大于等于给定值或者 right 达到数组末尾，此时更新最短距离，
	并且将 left 像右移一位，然后再 sum 中减去移去的值，然后重复上面的步骤，直到 right 到达末尾，
	且 left 到达临界位置，即要么到达边界，要么再往右移动，和就会小于给定值。
	 */
	public int minSubArrayLen(int target, int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		int left = 0;
		int right = 0;
		
		int sum = 0;
		int res = Integer.MAX_VALUE;
		
		while(right < nums.length) {
			while(sum < target && right < nums.length) {
				sum = sum + nums[right];
				right++;
			}
			
			while(sum >= target) {						//sum is greater than or equal to target
				res = Math.min(res, right-left);		//get the min length
				
				sum = sum - nums[left];					//remove the left val and move left
				left++;
			}
		}
		
		return res == Integer.MAX_VALUE ? 0 : res; 		//handle case all sum still smaller than target e.g. ex3
	}
	
	public static void main(String[] args) {
		n209_Minimum_Size_Subarray_Sum obj = new n209_Minimum_Size_Subarray_Sum();
		System.out.println(obj.minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
		System.out.println(obj.minSubArrayLen(11, new int[] {1,1,1,1,1,1,1,1}));
	}
}
