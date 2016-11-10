package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
nums = [1,2,2]
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */
@Alg(type="NP", com="FB", level="Med", num=90)
public class n090_SubsetsII {
	//DFS
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>(); 
		Arrays.sort(nums);
		//res.add(tmp);
		helper(nums, res, tmp, 0);
		return res;
	}

	private void helper(int[] nums, List<List<Integer>> res, List<Integer> tmp, int start) {
		//if(start == nums.length) return;
		List<Integer> list = new ArrayList<Integer>(tmp);
		res.add(list);

		for(int i=start; i<nums.length; i++) {
/*			if(i>start && nums[i]==nums[i-1])
				continue;*/
			tmp.add(nums[i]);
			helper(nums, res, tmp, i+1);
			tmp.remove(tmp.size()-1);
			while(i<nums.length-1 && nums[i] == nums[i+1])
				i++;
		}
	}

	public static void main(String[] args){
		n090_SubsetsII obj = new n090_SubsetsII();
		int[] nums = {1,2,2};
		System.out.println(obj.subsetsWithDup(nums));
	}
}
