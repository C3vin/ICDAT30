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
					//if(s.charAt(j) == close && (j == 0 || s.charAt(j-1) != close)) {
					//if((s.charAt(j) == close && s.charAt(j - 1) != close) || (s.charAt(j) == close && j == y)) {
					if(s.charAt(j) == close && (j == y || s.charAt(j-1) != close)) {
						dfs(res, s.substring(0, j)+s.substring(j+1), i, j, open, close);
					}
				}
				return;		//must!!!
			}
		}

		String reverse = new StringBuilder(s).reverse().toString();
		if(open == '(') {
			dfs(res, reverse, 0, 0, close, open);
		} else {
			res.add(reverse);
		}
	}
	
/* https://leetcode.com/problems/remove-invalid-parentheses/discuss/75027/Easy-Short-Concise-and-Fast-Java-DFS-3-ms-solution
 (s.charAt(j) == pairs[1] && (j == last_j || s.charAt(j-1) != pairs[1])) 
 Is just saying if the current character is the closed parenthesis for this recursive call (open bracket
 in the reversed recursive call) and the first character is a bracket which made the expression invalid 
 or the previous character does not lead to a valid expression (e.g. for string ()())() and i == 4 and 
 j == 1 i made the expression invalid so to make this expression valid again when removing the jth character, 
 the j-1th character must be opposite to form a well formed expression as it leads to => s.substring(0, j) = ( 
 and s.substring(j + 1) = ())() which equals (())() a valid expression! Remember from OPs post we are removing 
 the first invalid parenthesis we see so s.charAt(j-1) != pairs[1] just says for example if I am a closed bracket 
 at j then the j-1th character should not be a closed bracket because if it was the prefix would be invalid (The 
 reason for this is we know i made the expression invalid, so removing first j will make it valid again.
 
 0 1 2 3 4 5 6
 ( ) ( ) ) ( )
         i
   j 
s.substring(0, j)+s.substring(j+1)
         (       +   ())() 
=>    (())() valid expression       */
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
