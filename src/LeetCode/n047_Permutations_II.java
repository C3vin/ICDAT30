package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Alg(type="DFS", com="LL&M$", level="med", num=047)
public class n047_Permutations_II {
	//Need one res, tmp, used(visited) for dfs
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		boolean[] used = new boolean[nums.length];
		List<Integer> tmp = new LinkedList<Integer>();
		Arrays.sort(nums);
		helper(nums, res, tmp, used);
		return res;
	}
	//DFS
	private void helper(int[] nums, List<List<Integer>> res, List<Integer> tmp, boolean[] used) {
		if(tmp.size() == nums.length) {
			List<Integer> list = new LinkedList<Integer>(tmp);			//don't miss tmp
			res.add(list);
		} else {
			for(int i=0; i<nums.length; i++) {
				if(used[i])
					continue;

				used[i] = true;
				tmp.add(nums[i]);
				helper(nums, res, tmp, used);
				tmp.remove(tmp.size()-1);
				used[i] = false;

				//ignore duplicate !!!
				while(i<nums.length-1 && nums[i] == nums[i+1]) {
					i++;
				}
			}
		}
	}

	public static void main(String[] args) {
		n047_Permutations_II obj = new n047_Permutations_II();
		int[] nums = {1,1,2};
		System.out.println(obj.permuteUnique(nums));
	}
}
