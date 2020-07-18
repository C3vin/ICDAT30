package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
public class n022_generate_parenthesis {
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		String path = new String();
		//if(n <= 0) return res;
		helper(n, n, res, path);
		return res;
	}
	private void helper(int left, int right, List<String> res, String path) {
		//handle ")(" e.g. ()())(
		if(left > right) 
			return;
		
		//base case
		if(left == 0 && right == 0) {
			res.add(path);
			return;
		}
		if(left > 0) {
			helper(left-1, right, res, path+"(");
		}
		if(right > 0) {
			helper(left, right-1, res, path+")");
		}
	}
	public static void main(String[] args) {
		n022_generate_parenthesis obj = new n022_generate_parenthesis();
		System.out.println(obj.generateParenthesis(3));
	}
}
