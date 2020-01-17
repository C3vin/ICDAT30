package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Example 1:
Input: "()())()"
Output: ["()()()", "(())()"]

Example 2:
Input: "(a)())()"
Output: ["(a)()()", "(a())()"]

Example 3:
Input: ")("
Output: [""]
 */
public class n301_Remove_Invalid_Parentheses {
	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<String>();
		dfs(res, s, 0, 0, '(', ')');

		return res;
	}
	private void dfs(List<String> res, String s, int x, int y, char open, char close) {
		for(int count=0, i=x; i<s.length(); i++) {
			if(s.charAt(i) == open) {
				count++;
			}
			if(s.charAt(i) == close) {
				count--;
			}

			if(count<0) {
				for(int j=y; j<=i; j++) {
					//((s.charAt(j) == par[1] && s.charAt(j - 1) != par[1]) || (s.charAt(j) == par[1] && j == last_j))
					if(s.charAt(j) == close && (j == y || s.charAt(j-1) != close)) {
						dfs(res, s.substring(0, j)+s.substring(j+1), i, j, open, close);
					}
				}
				return;		//must
			}
		}

		String reverse = new StringBuilder(s).reverse().toString();
		if(open == '(') {
			dfs(res, reverse, 0, 0, close, open);
		} else {
			res.add(reverse);
		}
	}
	
	//https://segmentfault.com/a/1190000013676627  good!
	public static void main(String[] args) {
		n301_Remove_Invalid_Parentheses obj = new n301_Remove_Invalid_Parentheses();
		System.out.println(obj.removeInvalidParentheses("()())()"));
		//System.out.println(obj.removeInvalidParentheses("(a)())()"));
		//System.out.println(obj.removeInvalidParentheses(")("));
		//System.out.println(obj.removeInvalidParentheses("()(()"));
		//System.out.println(obj.removeInvalidParentheses("()"));
	}

}
