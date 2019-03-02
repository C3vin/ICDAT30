package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
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
public class n090_SubsetsII {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		Arrays.sort(nums);								//must sort first, cuz n78 is distinct num
		dfs(nums, 0, tmp, res);
		return res;
	}
	//dfs
	private void dfs(int[] nums, int start, List<Integer> tmp, List<List<Integer>> res) {
		res.add(new ArrayList<Integer>(tmp));
		
		for(int i=start; i<nums.length; i++) {
			if(i > start && nums[i] == nums[i-1]) {		//i > start, not the first num	
				continue; 
			}
			tmp.add(nums[i]);
			dfs(nums, i+1, tmp, res);
			tmp.remove(tmp.size()-1);
		}
	}

	public static void main(String[] args){
		n090_SubsetsII obj = new n090_SubsetsII();
		int[] nums = {1,2,2};
		int[] nums1 = {4,4,4,1,4};
		System.out.println(obj.subsets(nums));
		System.out.println(obj.subsets(nums1));
	}
}
