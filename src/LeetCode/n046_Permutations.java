package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given a collection of distinct integers, return all possible permutations.

Example:
Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
public class n046_Permutations {
	//sol: backtrack classic 
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		dfs(nums, tmp, res);
		
		return res;
	}
	private void dfs(int[] nums, List<Integer> tmp, List<List<Integer>> res) {
		if(tmp.size() == nums.length) {
			res.add(new ArrayList<Integer>(tmp));
			return;										//don't forget
		}
		
		for(int i=0; i<nums.length; i++) {
			if(tmp.contains(nums[i])) {					//smart! not need used! use List contains() API
				continue;
			}
			
			tmp.add(nums[i]);
			
			dfs(nums, tmp, res);
			
			tmp.remove(tmp.size()-1);
		}
		
	}
	
	public static void main(String[] args) {
		n046_Permutations obj = new n046_Permutations();
		int[] nums = {1,2,3};
		System.out.println(obj.permute(nums));
	}
}
