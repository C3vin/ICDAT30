package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class n078_Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();  
		List<Integer> tmp = new ArrayList<Integer>();  
		//Arrays.sort(nums);  
		res.add(tmp);  
		dfs(res,tmp,nums,0);  
		return res;  
	}
	public void dfs(List<List<Integer>> res, List<Integer> tmp, int[] S, int pos){  
		for(int i=pos; i<S.length; i++){  
			tmp.add(S[i]); 
			res.add(new ArrayList<Integer>(tmp));  
			dfs(res, tmp, S, i+1);  
			tmp.remove(tmp.size()-1);  
		}  
	}  
	public static void main(String[] args) {
		n078_Subsets obj = new n078_Subsets();
		int[] nums = {1, 2, 3};
		System.out.println(obj.subsets(nums));
	}
}
