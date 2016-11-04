package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Alg(type="DFS", com="LL&M$", level="med", num=046)
public class n046_Permutations {
	 public List<List<Integer>> permute(int[] nums) {
		 List<List<Integer>> res = new ArrayList<List<Integer>>();
		 boolean[] used = new boolean[nums.length];
		 List<Integer> tmp = new LinkedList<Integer>();
		 helper(nums, res, tmp, used);
		 return res;
	 }
	 //DFS
	 private void helper(int[] nums, List<List<Integer>> res, List<Integer> tmp, boolean[] used) {
		 if(tmp.size() == nums.length) {
			 List<Integer> list = new LinkedList<Integer>(tmp);		//why? cuz tmp will be change
			 res.add(list);
		 } else {
			 for(int idx=0; idx<nums.length; idx++) {
				 if(used[idx])
					 continue;
				 //add element and do check next 
				 used[idx] = true;
				 tmp.add(nums[idx]);
				 helper(nums, res, tmp, used);
				 tmp.remove(tmp.size()-1); 	
				 used[idx] = false;  //!!! reset
			 }
		 }
	}
	public static void main(String[] args) {
		 n046_Permutations obj = new n046_Permutations();
		 int[] nums = {1,2,3};
		System.out.println(obj.permute(nums));
	 }
}
