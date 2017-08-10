package LeetCode;

import java.util.LinkedList;

//e.g. example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
public class n032_Longest_Valid_Parentheses {
	//Brute Force [Time Limit Exceeded]
	public int longestValidParentheses(String s) {
		int maxlen = 0;

		for(int i=0; i<s.length(); i++) {
			for(int j=i+2; j<=s.length(); j=j+2) {				//F: need <= s.length, becasue we are suing substring(0,6) -> (0,1,2,3,4,5)
				if(isValid(s.substring(i, j))) {
					maxlen = Math.max(maxlen, j-i);
				}
			}
		}
		return maxlen;
	}
	private boolean isValid(String s) {
		LinkedList<Character> stack = new LinkedList<Character>(); 
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == '(') {
				stack.push('(');
			} else if(!stack.isEmpty() && stack.peek() == '(') {
				stack.pop();
			} else
				return false;
		}	
		return stack.isEmpty();	//isempty()
	}
	
	public int longestValidParentheses2(String s) {
		
	}
	
	public static void main(String[] args) {
		n032_Longest_Valid_Parentheses obj = new n032_Longest_Valid_Parentheses();
		//String s = ")()())";
		//String s = ")(";
		String s = "(())";
		System.out.println(obj.longestValidParentheses(s));
	}
}
