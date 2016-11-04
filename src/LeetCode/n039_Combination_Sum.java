package LeetCode;

import java.util.ArrayList;
import java.util.List;

@Alg(type="NP", com="NA", level="Med", num=39)
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
	
	public static void main(String[] args) {
		n039_Combination_Sum obj = new n039_Combination_Sum();
		int[] candidates = {2,3,6,7};
		int target = 7;
		System.out.println(obj.combinationSum(candidates, target));
	}
}
