package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class n077_Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();  
		List<Integer> tmp = new ArrayList<Integer>();  
		dfs(res, tmp, k, n, 1);  //because it need to begin from 1
		return res;  
	}
	public void dfs(List<List<Integer>> res, List<Integer> tmp, int k, int n, int start){  
		for(int i=start; i<=n; i++) {  //F: need start can't use '1', // try each possibility number in current position
			tmp.add(i); 
			if(tmp.size() == k) {
				res.add(new ArrayList<Integer>(tmp));  
			}
			dfs(res,tmp,k,n,i+1);  // after selecting number for current position, process next position 
			tmp.remove(tmp.size()-1); //clear the current position to try next possible number 
		}  
	} 
	public static void main(String[] args) {
		n077_Combinations obj = new n077_Combinations();
		System.out.println(obj.combine(4, 2));
	}
}
