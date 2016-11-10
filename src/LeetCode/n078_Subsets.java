package LeetCode;

import java.util.ArrayList;
import java.util.List;

@Alg(type="NP", com="AA,FB", level="Med", num=90)
/**
nums = [1,2,3]
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]  
 */
public class n078_Subsets {
	//DFS
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();  
		List<Integer> tmp = new ArrayList<Integer>();  
		//Arrays.sort(nums);  
		//res.add(tmp);  
		dfs(res,tmp,nums,0);  
		return res;  
	}
	public void dfs(List<List<Integer>> res, List<Integer> tmp, int[] S, int start){  
		List<Integer> list = new ArrayList<Integer>(tmp);
		res.add(list);  

		for(int i=start; i<S.length; i++){  
			tmp.add(S[i]); 
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
