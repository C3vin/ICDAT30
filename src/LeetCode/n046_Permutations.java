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
	//Need one res, tmp, used(visited) for dfs
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		boolean[] used = new boolean[nums.length];
		List<Integer> tmp = new LinkedList<Integer>();
		helper(nums, res, tmp, used);
		return res;
	}
	//DFS
	//Need one list to create space [A,B,C] and add to res
	private void helper(int[] nums, List<List<Integer>> res, List<Integer> tmp, boolean[] used) {
		if(tmp.size() == nums.length) {
			List<Integer> list = new LinkedList<Integer>(tmp);		//why? cuz tmp will be change
			res.add(list);
		}
		for(int i=0; i<nums.length; i++) {
			if(used[i])
				continue;
			//add element and do check next 
			used[i] = true;
			tmp.add(nums[i]);
			helper(nums, res, tmp, used);
			tmp.remove(tmp.size()-1); 	
			used[i] = false;  //!!! reset
		}
	}

	//sol2
	public List<List<Integer>> permute2(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		boolean[] used = new boolean[nums.length];
		dfs(nums, used, tmp, res);
		return res;
	}

	//dfs
	private void dfs(int[] nums, boolean[] used, List<Integer> tmp, List<List<Integer>> res) {
		if(tmp.size() == nums.length) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}
		for(int i=0; i<nums.length; i++) {
			if(used[i]) {
				continue;
			}
			tmp.add(nums[i]);
			used[i] = true;
			dfs(nums, used, tmp, res);
			tmp.remove(tmp.size()-1);
			used[i] = false;
		}
	}
	public static void main(String[] args) {
		n046_Permutations obj = new n046_Permutations();
		int[] nums = {1,2,3};
		System.out.println(obj.permute(nums));
		System.out.println(obj.permute2(nums));
	}
}
