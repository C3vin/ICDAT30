package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), 
find all unique combinations in candidates where the candidate numbers sums to target.
The same repeated number may be chosen from candidates unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]

Example 2:
Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 */
public class n039_Combination_Sum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		helper(candidates, target, res, tmp, 0);
		return res;
	}

	private void helper(int[] candidates, int target, List<List<Integer>> res, List<Integer> tmp, int start) {
		if(target < 0) 			//deal Neg and return 
			return;				
		if(target == 0) {		//meet the target request, and return [2,2,3]
			List<Integer> list = new ArrayList<Integer>(tmp);
			res.add(list);
			return;				//F: Don't forget! 
		}
		for(int i=start; i<candidates.length; i++) {
			if(i>0 && candidates[i] == candidates[i-1]) {
				continue;
			}
			tmp.add(candidates[i]);
			helper(candidates, target-candidates[i], res, tmp, i);	//why not i+1,the same repeated number may be use unlimited 
			tmp.remove(tmp.size()-1);
		}
	}

	//sol1: backtrack:dfs
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		Arrays.sort(candidates);
		dfs(candidates, target, 0, tmp, res);

		return res;
	}

	private void dfs(int[] candidates, int target, int start, List<Integer> tmp, List<List<Integer>> res) {
		if(target == 0) {
			//List<Integer> list = new ArrayList<Integer>(tmp);		//need new list, cuz will remove the old value from tmp
			//res.add(list);
			res.add(new ArrayList<Integer>(tmp));
			return;
		}

		for(int i=start; i<candidates.length; i++) {
			if(target < candidates[i]) {
				continue;
			}
			tmp.add(candidates[i]);
			dfs(candidates, target-candidates[i], i, tmp, res);
			tmp.remove(tmp.size()-1);
		}
	}

	//sol3
	public List<List<Integer>> combinationSum3(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(candidates);
		backtrack(res, new ArrayList<Integer>(), candidates, target, 0);
		return res;
	}

	private void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] cand, int remain, int start) {
		if (remain < 0) {
			return; /** no solution */
		}
		else if (remain == 0) {
			res.add(new ArrayList<>(tempList));
		}
		else {
			for (int i = start; i < cand.length; i++) { 
				tempList.add(cand[i]);
				backtrack(res, tempList, cand, remain-cand[i], i);
				tempList.remove(tempList.size()-1);
			} 
		}

	}

	public static void main(String[] args) {
		n039_Combination_Sum obj = new n039_Combination_Sum();
		int[] candidates = {2,3,6,7};
		int target = 7;
		int[] candidates1 = {8,7,4,3};
		int target1 =11;
		System.out.println(obj.combinationSum(candidates, target));
		System.out.println(obj.combinationSum2(candidates, target));
		System.out.println(obj.combinationSum3(candidates, target));
		
		System.out.println(obj.combinationSum(candidates1, target1));
		System.out.println(obj.combinationSum2(candidates1, target1));
		System.out.println(obj.combinationSum3(candidates1, target1));
	}
}
