package LeetCode;

/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class n053_Maximum_Subarray {
	public int maxSubArray(int[] nums) {
		if(nums == null || nums.length==0) {  
			return 0;  
		}
		int global = nums[0];  					//default, will update later
		int local = nums[0];  					//default
		for(int i=1; i<nums.length; i++) {		//i=1, cuz we don't need to check first element  
			local = Math.max(nums[i], local+nums[i]);  		//find MAX between "cur" & "cur+past"
			global = Math.max(local, global);
		}  
		return global;  
	}

	//DP basic Q                             G ---- L 
	//http://mropengate.blogspot.com/2015/01/algorithm-ch2-dynamic-programming.html
	public int maxSubArray2(int[] nums) {
		int[] dp = new int[nums.length];
		int max = nums[0];
		
		for(int i=1; i<nums.length; i++) {
			if(dp[i-1] < 0) {
				dp[i] = 0 + nums[i];			//0 (negative) + cur  
			} else {
				dp[i] = dp[i-1] + nums[i];		//past + cur
			}
			max = Math.max(max, dp[i]);
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		n053_Maximum_Subarray obj = new n053_Maximum_Subarray();
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println("Max: " + obj.maxSubArray(nums));
		System.out.println("Max: " + obj.maxSubArray2(nums));
	}
}
