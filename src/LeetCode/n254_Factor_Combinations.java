package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class n254_Factor_Combinations {
	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		int start = 2;
		int product = 1;
		helper(start, product, n, res, tmp);
		return res;
	}
	public void helper(int start, int product, int n, List<List<Integer>> res, List<Integer> tmp) {
		if(start > n || product > n) 		//need start > n to deal with n=1
			return;
		//met req
		if(product == n) {
			List<Integer> list = new ArrayList<Integer>(tmp);
			res.add(list);
			return;
		}
		for(int i=start; i<n; i++) {
			if(i*product>n)             //Time Limit Exceeded
				break;
			if(n%i == 0) {
				tmp.add(i);
				helper(i, i*product, n, res, tmp);
				tmp.remove(tmp.size()-1);
			}
		}
	}
	public static void main(String[] args) {
		n254_Factor_Combinations obj = new n254_Factor_Combinations();
		System.out.println(obj.getFactors(8));
	}
}
