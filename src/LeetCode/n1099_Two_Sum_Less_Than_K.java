package LeetCode;

import java.util.Arrays;

/*
Given an array nums of integers and integer k, return the maximum sum such that there exists i < j with nums[i] + nums[j] = sum and sum < k. If no i, j exist satisfying this equation, return -1.
Example 1:
Input: nums = [34,23,1,24,75,33,54,8], k = 60
Output: 58
Explanation: We can use 34 and 24 to sum 58 which is less than 60.
Example 2:

Input: nums = [10,20,30], k = 15
Output: -1
Explanation: In this case it is not possible to get a pair sum less that 15.
 */
public class n1099_Two_Sum_Less_Than_K {
	//O(nlogn)  O(n)
	public int twoSumLessThanK(int[] nums, int k) {
		int res = -1;       //not '0', handle special case, ex2 not possible to get a pair sum

		Arrays.sort(nums);

		int left = 0;
		int right = nums.length-1;

		while(left < right) {
			int sum = nums[left] + nums[right];

			if(sum < k) {
				res = Math.max(res, sum);
				left++;
			} else {
				right--;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		n1099_Two_Sum_Less_Than_K obj = new n1099_Two_Sum_Less_Than_K();
		System.out.println(obj.twoSumLessThanK(new int[] {34,23,1,24,75,33,54,8}, 60));
	}
}
