package LeetCode;

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:
Input: "()"
Output: true

Example 2:
Input: "()[]{}"
Output: true

Example 3:
Input: "(]"
Output: false

Example 4:
Input: "([)]"
Output: false

Example 5:
Input: "{[]}"
Output: true
 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;
//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

public class n020_Valid_Parentheses {
	//sol2
	public boolean isValid2(String s) {
/*		if(s.length() == 0 || s.length() == 1) {
			return false;			//deal with "" case
		}*/

		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');
		
		LinkedList<Character> stack = new LinkedList<Character>();
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c == '(' || c == '[' || c == '{') { 			
				stack.push(c);
			} else {
				if(stack.size() == 0 || stack.pop() != map.get(c)) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	public boolean isValid3(String s) {
		if(s == null || s.length() == 0) {
			return true;
		}
		
		Stack<Character> stack = new Stack<Character>();
		for(char ch : s.toCharArray()) {
			if(ch == '(') {
				stack.push(')');
			} else if(ch == '[') {
				stack.push(']');
			} else if(ch == '{') {
				stack.push('}');
			} else {
				if(stack.isEmpty() || stack.pop() != ch) {	//pop will remove the stack and check with ch value
					return false;
				}
			}
		}
		return stack.isEmpty();		//handle "[" case
	}
	
	public static void main(String[] args) {
		n020_Valid_Parentheses obj = new n020_Valid_Parentheses();
		
		System.out.println(obj.isValid2("()[]{}"));
		System.out.println(obj.isValid2("){"));
		System.out.println(obj.isValid2(""));
		System.out.println(obj.isValid2("["));
		
		System.out.println(obj.isValid3("()[]{}"));
		System.out.println(obj.isValid3("){"));
		System.out.println(obj.isValid3(""));
		System.out.println(obj.isValid3("["));
	}
}
