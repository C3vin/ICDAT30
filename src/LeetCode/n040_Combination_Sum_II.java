package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of candidate numbers (candidates) and a target number (target), 
find all unique combinations in candidates where the candidate numbers sums to target.
Each number in candidates may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

Example 2:
Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
 */
public class n040_Combination_Sum_II {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		Arrays.sort(candidates);						//Sort first
		boolean[] used = new boolean[candidates.length];
		helper(candidates, target, res, tmp, 0, used);
		return res;
	}

	private void helper(int[] candidates, int target, List<List<Integer>> res, List<Integer> tmp, int start, boolean[] used) {
		if(target < 0)
			return;
		if(target == 0) {
			List<Integer> list = new ArrayList<Integer>(tmp);
			res.add(list);
			return;
		}
		for(int i=start; i<candidates.length; i++) {
			if(!used[i]) {
				if(i>0 && candidates[i] == candidates[i-1] && used[i-1] == false)
					continue;
				tmp.add(candidates[i]);
				used[i] = true;
				helper(candidates, target-candidates[i], res, tmp, i+1, used);
				used[i] = false;
				tmp.remove(tmp.size()-1);
			}
		}
	}

	public List<List<Integer>> combinationSum2_2(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] cand, int remain, int start) {
		if(remain < 0) {
			return; /** no solution */
		} else if(remain == 0) {
			list.add(new ArrayList<>(tempList));
		}
		else {
			for (int i = start; i < cand.length; i++) {
				if(i > start && cand[i] == cand[i-1]) continue; /** skip duplicates */
				tempList.add(cand[i]);
				backtrack(list, tempList, cand, remain - cand[i], i+1);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		n040_Combination_Sum_II obj = new n040_Combination_Sum_II();
		int[] candidates = {10,1,2,7,6,1,5};
		int target = 8;
		System.out.println(obj.combinationSum2(candidates, target));
		System.out.println(obj.combinationSum2_2(candidates, target));
	}
}
