package LeetCode;

import java.util.Arrays;

/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
Your algorithm's runtime complexity must be in the order of O(log n).
If the target is not found in the array, return [-1, -1].

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 */
public class n034_Search_for_a_Range {
	//https://leetcode.wang/leetCode-34-Find-First-and-Last-Position-of-Element-in-Sorted-Array.html
	public int[] searchRange(int[] nums, int target) {
		int[] res = {-1,-1};
		if(nums==null || nums.length==0) return res; 

		int ll = 0;
		int lr = nums.length-1;
		while(ll <= lr) {						
			int m = (ll + lr)/2;
			if(nums[m] < target) {				//F: <
				ll = m+1;
			} else {
				lr = m-1;
			}
		}

		int rl =0;
		int rr = nums.length-1;
		while(rl <= rr) {
			int m = (rl + rr)/2;
			if(nums[m] <= target) {				//F: <=
				rl = m+1;
			} else {
				rr = m-1;
			}
		}
		
		if(ll <= rr) {
			res[0] = ll;
			res[1] = rr;
		}
		return res;
	}

	public static void main(String[] args) {
		n034_Search_for_a_Range obj = new n034_Search_for_a_Range();
		int[] nums = {5,7,7,8,8,10};
		System.out.println(Arrays.toString(obj.searchRange(nums, 8)));
	}
}
