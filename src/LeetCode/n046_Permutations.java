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
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		boolean[] used = new boolean[nums.length];
		dfs(nums, used, tmp, res);
		return res;
	}
	//dfs  [LC46 & LC47] Must study this sol for the LC47.
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
			used[i] = false;							//reset
		}
	}
	
	//sol2
	public List<List<Integer>> permute2(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		dfs2(nums, tmp, res);
		
		return res;
	}
	private void dfs2(int[] nums, List<Integer> tmp, List<List<Integer>> res) {
		if(tmp.size() == nums.length) {
			res.add(new ArrayList<Integer>(tmp));
			return;										//don't forget
		}
		
		for(int i=0; i<nums.length; i++) {
			if(tmp.contains(nums[i])) {					//smart! not need used!
				continue;
			}
			
			tmp.add(nums[i]);
			
			dfs2(nums, tmp, res);
			
			tmp.remove(tmp.size()-1);
		}
		
	}
	
	//sol3
	public List<List<Integer>> permute3(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		dfs3(nums, 0, res);
		return res;
	}
	private void dfs3(int[] nums, int index, List<List<Integer>> res) {
		if(index == nums.length) {
			List<Integer> tmp = new ArrayList<Integer>();
			for(int num : nums) {
				tmp.add(num);
			}
			res.add(new ArrayList<Integer>(tmp));
			return;
		}
		for(int i=index; i<nums.length; i++) {
			swap(nums, index, i);
			dfs3(nums, index+1, res);
			swap(nums, index, i);
		}
	}
	private void swap(int[] nums, int l, int r) {
		int tmp = nums[l];
		nums[l] = nums[r];
		nums[r] = tmp;
	}
	public static void main(String[] args) {
		n046_Permutations obj = new n046_Permutations();
		int[] nums = {1,2,3};
		System.out.println(obj.permute(nums));
		System.out.println(obj.permute2(nums));
		System.out.println(obj.permute3(nums));
	}
}
