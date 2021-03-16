package LeetCode;

/*
Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
It is guaranteed that the answer will fit in a 32-bit integer.
A subarray is a contiguous subsequence of the array.

Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

Constraints:
1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
 */
public class n152_Maximum_Product_Subarray {
	public int maxProduct(int[] nums) {
		int[] Max_local = new int[nums.length];
		int[] min_local = new int[nums.length];
		
		Max_local[0] = nums[0];		//default first element			need int[] to store the product 
		min_local[0] = nums[0];		//default first element
		
		int global = nums[0];		//default first element
		
		//careful about the max and min
		for(int i=1; i<nums.length; i++) {			//i=1, cuz we don't need to check first element  
			if(nums[i] > 0) {
				Max_local[i] = Math.max(nums[i], nums[i]*Max_local[i-1]);			//F: is max[i-1]
				min_local[i] = Math.min(nums[i], nums[i]*min_local[i-1]);
			} else {
				Max_local[i] = Math.max(nums[i], nums[i]*min_local[i-1]);			//when deal with Neg, switch min and Max local
				min_local[i] = Math.min(nums[i], nums[i]*Max_local[i-1]);
			}
			
			global = Math.max(global, Max_local[i]);
		}
		return global;
	}
	public static void main(String[] args) {
		n152_Maximum_Product_Subarray obj = new n152_Maximum_Product_Subarray();
		int[] nums = {2, 3, -2, 4};
		System.out.println(obj.maxProduct(nums));
	}
}
