package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
Given a set of distinct integers, nums, return all possible subsets (the power set).
Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
public class n078_Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		dfs(nums, 0, tmp, res);
		return res;
	}
	//dfs
	private void dfs(int[] nums, int start, List<Integer> tmp, List<List<Integer>> res) {
		res.add(new ArrayList<Integer>(tmp));
		
		for(int i=start; i<nums.length; i++) {
			tmp.add(nums[i]);
			dfs(nums, i+1, tmp, res);
			tmp.remove(tmp.size()-1);
		}
	}
	public static void main(String[] args) {
		n078_Subsets obj = new n078_Subsets();
		int[] nums = {1, 2, 3};
		System.out.println(obj.subsets(nums));
	}
}
