package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:
Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 */
public class n047_Permutations_II {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		boolean[] used = new boolean[nums.length];
		List<Integer> tmp = new LinkedList<Integer>();
		Arrays.sort(nums);
		helper(nums, res, tmp, used);
		return res;
	}

	private void helper(int[] nums, List<List<Integer>> res, List<Integer> tmp, boolean[] used) {
		if(tmp.size() == nums.length) {
			List<Integer> list = new LinkedList<Integer>(tmp);			//don't miss tmp
			res.add(list);
		} 
		for(int i=0; i<nums.length; i++) {
			if(used[i])
				continue;

			used[i] = true;
			tmp.add(nums[i]);
			helper(nums, res, tmp, used);
			tmp.remove(tmp.size()-1);
			used[i] = false;

			//ignore duplicate 
			while(i<nums.length-1 && nums[i] == nums[i+1]) {
				i++;
			}
		}
	}

	//sol2
	public List<List<Integer>> permuteUnique2(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		boolean[] used = new boolean[nums.length];
		
		Arrays.sort(nums);										//need sort first!!!
		
		dfs(nums, used, tmp, res);
		
		return res;
	}
	//dfs
	private void dfs(int[] nums, boolean[] used, List<Integer> tmp, List<List<Integer>> res) {
		if(tmp.size() == nums.length) {
			// if(res.contains(tmp)) {
			// 	return;                         //ps: works but too slow
			// }
			
			res.add(new ArrayList<Integer>(tmp));
			
			return;
		}
		for(int i=0; i<nums.length; i++) {
            // if(used[i]) {
            //     continue;                    //ps: works but too slow
            // }
			
			//why length-1? cuz handle later array i+1
			if(used[i] || i<nums.length-1 && nums[i] == nums[i+1] && !used[i+1]) {			//need !used[i+1] to check if next use or not	
				continue;										//remove duplicates
			}
			
			tmp.add(nums[i]);
			used[i] = true;
			
			dfs(nums, used, tmp, res);
			
			tmp.remove(tmp.size()-1);
			used[i] = false;
		}
	}

	public static void main(String[] args) {
		n047_Permutations_II obj = new n047_Permutations_II();
		int[] nums = {1,1,2};
		System.out.println(obj.permuteUnique(nums));
		System.out.println(obj.permuteUnique2(nums));
	}
}
