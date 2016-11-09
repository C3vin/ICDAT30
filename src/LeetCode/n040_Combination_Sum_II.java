package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Alg(type="NP", com="Snap", level="Med", num=40)
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

	public static void main(String[] args) {
		n040_Combination_Sum_II obj = new n040_Combination_Sum_II();
		int[] candidates = {10,1,2,7,6,1,5};
		int target = 8;
		System.out.println(obj.combinationSum2(candidates, target));
	}
}
