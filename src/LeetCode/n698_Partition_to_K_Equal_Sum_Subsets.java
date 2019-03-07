package LeetCode;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.

Example 1:
Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.

Note:
1 <= k <= len(nums) <= 16.
0 < nums[i] < 10000.
 */
public class n698_Partition_to_K_Equal_Sum_Subsets {	
	public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		for(int num : nums) {
			sum += num;
		}
		if(k<=0 || sum%k != 0) {
			return false;
		}
		boolean[] visited = new boolean[nums.length];
		int target = sum/k;
		
		//Arrays.sort(nums);
		return dfs(nums, k, 0, visited, target, 0);
	}
	
	//Ref: https://www.youtube.com/watch?v=qpgqhp_9d1s
	//https://github.com/bephrem1/backtobackswe/blob/master/Dynamic%20Programming%2C%20Recursion%2C%20%26%20Backtracking/partitionIntoKEqualSumSubsets.java
	private boolean dfs(int[] nums, int k, int start, boolean[] visited, int target, int curSum) {
		if(k == 1) {
			return true;
		}
		
		//Bucket full. continue the recursion with k - 1 as the new k value, 
		//BUT the target stays the same. We just have 1 less bucket to fill.
		if(curSum == target) {
			return dfs(nums, k-1, 0, visited, target, 0);
		}
		
		//Try all values from 'iterationStart' to the end of the array ONLY if:
		//1.) They have not been used up to this point in the recursion's path
	    //2.) They do not overflow the current bucket we are filling
		for(int i=start; i<nums.length; i++) {
			if(!visited[i] && curSum+nums[i] <= target) {
				visited[i] = true;		 
				if(dfs(nums, k, i+1, visited, target, curSum+nums[i])) {			 
					return true;
				}
				visited[i] = false;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		n698_Partition_to_K_Equal_Sum_Subsets obj = new n698_Partition_to_K_Equal_Sum_Subsets();
		int[] nums = {4, 3, 2, 3, 5, 2, 1};
		int k = 4;
		System.out.println(obj.canPartitionKSubsets(nums, 4));
	}
}
