package LeetCode;

import java.util.ArrayList;
import java.util.List;
/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:
Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
public class n077_Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		
		int start = 1;
		
		dfs2(n, k, tmp, res, start);						//because it need to begin from 1~n
		
		return res;
	}
	private void dfs2(int n, int k, List<Integer> tmp, List<List<Integer>> res, int start) {
		if(tmp.size() > k) {							//this will speed up and no need to add > k element
			return;
		}
		for(int i=start; i<=n; i++) {					//need <= not just < !!!
			tmp.add(i);
			
			if(tmp.size() == k) {
				res.add(new ArrayList<Integer>(tmp));
			}
			
			dfs2(n, k, tmp, res, i+1);					//after selecting number for current position, process next position 
			
			tmp.remove(tmp.size()-1);					//clear the current position to try next possible number 

		}
	}
	public static void main(String[] args) {
		n077_Combinations obj = new n077_Combinations();
		System.out.println(obj.combine(4, 2));
	}
}
