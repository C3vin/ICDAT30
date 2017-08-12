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
	
	//Stack
	public int longestValidParentheses2(String s) {
		int maxLen = 0;
		LinkedList<Integer> stack = new LinkedList<Integer>();
		stack.push(-1);		//dummy
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == '(') {
				stack.push(i);
			} else {
				stack.pop();
				if(stack.isEmpty())
					stack.push(i);
				
				maxLen = Math.max(maxLen, i - stack.peek());
			}
		}
		return maxLen;
	}
	
	//Without extra space
	public int longestValidParentheses3(String s) {
		int left = 0;
		int right = 0;
		int maxLen = 0;
		
		//start from left
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == '(')
				left++;
			else 
				right++;
			
			if(left == right) {
				maxLen = Math.max(maxLen, right*2);
			} else if(right >= left) {
				left = 0;
				right = 0;
			}
		}
		
		left = 0; 	//Need to reset!!!
		right = 0;
		
		//start from right
		for(int i=s.length()-1; i>=0; i--) {
			if(s.charAt(i) == ')') 
				right++;
			else
				left++;
			
			if(left == right) {
				maxLen = Math.max(maxLen, left*2);
			} else if(left >= right) {				//handle )((()), from right to left, need to avoid left = 3, right = 3 in wrong order
				left = 0;
				right = 0;
			}
		}
		return maxLen;
	}
	
	public static void main(String[] args) {
		n032_Longest_Valid_Parentheses obj = new n032_Longest_Valid_Parentheses();
		String s = ")()())";
		//String s = ")(";
		//String s = "(())";
		System.out.println(obj.longestValidParentheses(s));
		System.out.println(obj.longestValidParentheses2(s));
		System.out.println(obj.longestValidParentheses3(s));
	}
}
