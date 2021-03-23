package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination 
should be a unique set of numbers.
Note:
All numbers will be positive integers.
The solution set must not contain duplicate combinations.

Example 1:
Input: k = 3, n = 7
Output: [[1,2,4]]

Example 2:
Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]
*/
public class n216_Combination_Sum_III {
	//Good!
	public List<List<Integer>> combinationSum3_2(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        
        int start = 1;
        
        helper(k, n, tmp, res, start);
        
        return res;
	}
	
	private void helper(int k, int n, List<Integer> tmp, List<List<Integer>> res, int start) {
        if(tmp.size() == k && n == 0) {
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        
        for(int i=start; i<=9; i++) {
            tmp.add(i);
            
            helper(k, n-i, tmp, res, i+1);
            
            tmp.remove(tmp.size()-1);
        }
    }
	
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		
		dfs(k, n, 1, tmp, res);
		
		return res;
	}
	
	//[LC39-LC40]
	private void dfs(int k, int n, int start, List<Integer> tmp, List<List<Integer>> res) {
		if(k == 0 && n == 0) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}
		
		for(int i=start; i<=9; i++) {
			if(i > n) {				//check 
				return;
			}
			
			tmp.add(i);
			
			dfs(k-1, n-i, i+1, tmp, res); 	//why i+1, make sure no duplicates!
			
			tmp.remove(tmp.size()-1);
		}
	}
	public static void main(String[] args) {
		n216_Combination_Sum_III obj = new n216_Combination_Sum_III();
		System.out.println(obj.combinationSum3(3, 7));
		System.out.println(obj.combinationSum3(3, 9));
		
		System.out.println(obj.combinationSum3_2(3, 7));
		System.out.println(obj.combinationSum3_2(3, 9));
		
	}
}
