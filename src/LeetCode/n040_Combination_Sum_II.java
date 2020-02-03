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

	//LC39 - LC40 template, diff with LC39, i>start and add i+1 to helper()
	public List<List<Integer>> combinationSum2_2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		Arrays.sort(candidates);							//need sort first
		dfs(candidates, target, res, tmp, 0);
		return res;
	}

	//dfs
	private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> tmp, int start) {
		if(target < 0) {
			return;
		}

		if(target == 0) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}

		for(int i=start; i<candidates.length; i++) {
			if(i>start  && candidates[i] == candidates[i-1]) {			//i > start, not the first num, e.g. 1134 diff 1s	
				continue;
			}
			tmp.add(candidates[i]);
			dfs(candidates, target-candidates[i], res, tmp, i+1);		//why i+1, make sure no duplicates! no like LC39
			tmp.remove(tmp.size()-1);
		}
	}

	public static void main(String[] args) {
		n040_Combination_Sum_II obj = new n040_Combination_Sum_II();
		int[] candidates = {10,1,2,7,6,1,5};
		int target = 8;
		System.out.println(obj.combinationSum2(candidates, target));
		System.out.println(obj.combinationSum2_2(candidates, target));

		int[] candidates1 = {14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12};
		int target1 = 27;
		System.out.println(obj.combinationSum2(candidates1, target1));
		System.out.println(obj.combinationSum2_2(candidates1, target1));
	}
}
