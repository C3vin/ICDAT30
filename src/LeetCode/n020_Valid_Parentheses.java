package LeetCode;

import java.util.LinkedList;

@Alg(type="String", com="AA,G,M$", level="easy", num=20)
public class n020_Valid_Parentheses {
	public boolean isValid(String s) {
		if(s.length() == 0 || s.length() == 1) return false;

		LinkedList<Character> stack = new LinkedList<Character>();
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
				stack.push(s.charAt(i));
				System.out.println(stack);
			} else {
				if(stack.size() == 0)			//F: Need to handle this, [(]
					return false;
				
				char tmp = stack.pop();
				System.out.println("tmp: "+tmp + " : " + s.charAt(i));
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
		return stack.size() == 0;					//F: using size !!!!!!!!!!!!!!! 
	}

	public static void main(String[] args) {
		n020_Valid_Parentheses obj = new n020_Valid_Parentheses();
		String s = "()[]{}";
		//String s = "([)]";
		System.out.println(obj.isValid(s));
	}
}
