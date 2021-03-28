package LeetCode;

/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. 
All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, 
adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:
Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.

Example 2:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 3:
Input: nums = [0]
Output: 0 
 */
public class n213_House_Robber_II {
	//https://www.cnblogs.com/grandyang/p/4518674.html
	//[LC198-LC213]
	public int rob(int[] nums) {
        // if(nums == null || nums.length == 0) {
        //     return 0;
        // }
        
        if(nums.length <= 1) {
            return nums[0];
        }
        
        return Math.max(helper(nums, 0, nums.length-1), helper(nums, 1, nums.length));
    }
    
    //LC 198. House Robber
    private int helper(int[] nums, int start, int end) {
        int robOdd = 0;
        int robEven = 0;
        
        for(int i=start; i<end; i++) {
            if(i % 2 == 0) {
                robEven = Math.max(robEven+nums[i], robOdd);		//robEven + nums[i] !!!
            } else {
                robOdd = Math.max(robOdd+nums[i], robEven);
            }
        }
        
        return Math.max(robOdd, robEven);
    }
}
