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
	//backtrack: DFS
	//LC39 - LC40 template
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		
		Arrays.sort(candidates);		//no need it, but looks more sorted
		
		helper(candidates, target, res, tmp, 0);
		
		return res;
	}

	//explain well: https://dzone.com/articles/stackoverflowerror-causes-amp-solutions
	private void helper(int[] candidates, int target, List<List<Integer>> res, List<Integer> tmp, int start) {
		if(target < 0) {			//deal negative case and return (cuz we are minus each time, or StackOverflowError)
			return;		
		}
		
		if(target == 0) {		//meet the target request, and return [2,2,3]
			res.add(new ArrayList<Integer>(tmp));			//can't use res.add(tmp) need new instance, cuz tmp will remove later and will change the res value 

			return;			//F: Don't forget! 
		}
		
		for(int i=start; i<candidates.length; i++) {
//			if(i>0 && candidates[i] == candidates[i-1]) {
//				continue;		//no need for LC 39, not contain duplicate combinations. for LC40
//			}
			tmp.add(candidates[i]);
			
			helper(candidates, target-candidates[i], res, tmp, i);	//why not i+1,the same repeated number may be use unlimited 
			
			tmp.remove(tmp.size()-1);
		}
	}

	public static void main(String[] args) {
		n039_Combination_Sum obj = new n039_Combination_Sum();
		int[] candidates = {2,3,6,7};
		int target = 7;
		int[] candidates1 = {8,7,4,3};
		int target1 =11;
		System.out.println(obj.combinationSum(candidates, target));
		System.out.println(obj.combinationSum(candidates1, target1));
	}
}
