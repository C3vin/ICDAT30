package LeetCode;

import java.util.LinkedList;
//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

public class n020_Valid_Parentheses {
	public boolean isValid(String s) {
		if(s.length() == 0 || s.length() == 1) return false;

		LinkedList<Character> stack = new LinkedList<Character>();
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
				stack.push(s.charAt(i));
			} else {
				if(stack.size() == 0)			//F: Need to handle this, '){'
					return false;

				char tmp = stack.pop();
				if(s.charAt(i) == ')') {
					if(tmp != '(')
						return false;
				} else if(s.charAt(i) == ']') {
					if(tmp != '[')
						return false;
				} else if(s.charAt(i) == '}') {
					if(tmp != '{')
						return false;
				}
			}	
		}
		if(stack.size() == 0)
			return true;
		//return stack.size() == 0;					//F: using size !!!!!!!!!!!!!!! 
		return false;
	}

	public static void main(String[] args) {
		n020_Valid_Parentheses obj = new n020_Valid_Parentheses();
		String s = "()[]{}";
		String s1 = "){";
		System.out.println(obj.isValid(s));
		System.out.println(obj.isValid(s1));
	}
}
