package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class n078_Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>> ();
		List	<Integer> item = new ArrayList<Integer>();
		if(nums.length==0||nums==null)
			return res;

		Arrays.sort(nums);
		for(int len = 1; len<= nums.length; len++)
			dfs(nums, 0, len, item, res);

		res.add(new ArrayList<Integer>());

		return res;
	}
	public static void dfs(int[] S, int start, int len, List<Integer> item,List<List<Integer>> res){
		if(item.size()==len){
			res.add(new ArrayList<Integer>(item));
			return;
		}
		for(int i=start; i<S.length; i++){
			item.add(S[i]);
			dfs(S, i+1, len, item, res);
			item.remove(item.size()-1);
		}
	}

	public List<List<Integer>> subsets2(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();  
		List<Integer> tmp = new ArrayList<Integer>();  
		Arrays.sort(nums);  
		res.add(tmp);  
		dfs(res,tmp,nums,0);  
		return res;  
	}
	public void dfs(List<List<Integer>> res, List<Integer> tmp, int[] S, int pos){  
		for(int i=pos; i<S.length; i++){  
			tmp.add(S[i]); 
			res.add(new ArrayList<Integer>(tmp));  
			dfs(res,tmp,S,i+1);  
			tmp.remove(tmp.size()-1);  
		}  
	}  
	public static void main(String[] args) {
		n078_Subsets obj = new n078_Subsets();
		int[] nums = {1, 2, 3};
		System.out.println(obj.subsets(nums));
		System.out.println(obj.subsets2(nums));
	}
}
