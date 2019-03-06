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
		int[] visited = new int[nums.length];
		int target = sum/k;
		
		Arrays.sort(nums);
		return dfs(nums, k, 0, visited, target, 0, 0);
	}
	
	private boolean dfs(int[] nums, int k, int start, int[] visited, int target, int curSum, int curCount) {
		if(k == 1) {
			return true;
		}
		
		//match the target, so k-1 to the next 
		if(curSum == target && curCount > 0) {
			System.out.println(k + " : " +curCount);
			for(int v : visited) 
				System.out.print(v);
			System.out.println("\n");
			return dfs(nums, k-1, 0, visited, target, 0, 0);
		}
		
		for(int i=start; i<nums.length; i++) {
			if(visited[i] == 0) {
				visited[i] = 1;				//use curCount to record the number of elements in the current subset
				if(dfs(nums, k, i+1, visited, target, curSum+nums[i], curCount++)) {			//why curCount++? 
					return true;
				}
				visited[i] = 0;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		n698_Partition_to_K_Equal_Sum_Subsets obj = new n698_Partition_to_K_Equal_Sum_Subsets();
		int[] nums = {4, 3, 2, 3, 5, 2, 1};
		int k = 4;
		System.out.println(obj.canPartitionKSubsets(nums, k));
	}
}
