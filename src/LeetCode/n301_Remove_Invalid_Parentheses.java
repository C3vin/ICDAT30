package LeetCode;

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
		
	}
	
	public static void main(String[] args) {
		n301_Remove_Invalid_Parentheses obj = new n301_Remove_Invalid_Parentheses();
		System.out.println(obj.removeInvalidParentheses("()())()"));
		System.out.println(obj.removeInvalidParentheses("(a)())()"));
		System.out.println(obj.removeInvalidParentheses(")("));
	}
	
}
