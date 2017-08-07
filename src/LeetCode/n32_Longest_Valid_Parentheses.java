package LeetCode;

//e.g. example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
public class n32_Longest_Valid_Parentheses {
	public int longestValidParentheses(String s) {
		if(s.length() <= 1) 
			return 0;
		int count = 0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == '(') {
				if(s.charAt(i+1) == ')') {
					count = count + 2;
					continue;
				}
			}
		}
		return count;
	}
	public static void main(String[] args) {
		n32_Longest_Valid_Parentheses obj = new n32_Longest_Valid_Parentheses();
		//String s = ")()())";
		String s = ")(";
		System.out.println(obj.longestValidParentheses(s));
	}
}
