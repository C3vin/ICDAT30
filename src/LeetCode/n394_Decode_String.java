package LeetCode;

import java.util.Stack;

/*
Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. 
Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. 
For example, there won't be input like 3a or 2[4].

Examples:
s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class n394_Decode_String {
	public String decodeString(String s) {
		if(s == null || s.length() == 0) {
			return "";
		}
		Stack<Character> stack = new Stack<Character>();
		
		for(char c : s.toCharArray()) {
			//push everything but ]
			if(c != ']') {
				stack.push(c);
			} else {
				//step1: if you find a closing ] then retrieve the string it encapsulates
				StringBuilder sb = new StringBuilder();
				while(!stack.isEmpty() && Character.isLetter(stack.peek())) {
					sb.insert(0, stack.pop());
				}
				String sub = sb.toString(); //this is the string contained in [ ]
				stack.pop(); //Discard the '[';
				
				//step2: after that get the number of times it should repeat from stack
				sb = new StringBuilder(); //reset
				while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
					sb.insert(0, stack.pop());
				}
				
				//step3: repeat the string within the [ ] count number of times and push it back into stack
				int count = Integer.valueOf(sb.toString());
				while(count > 0) {
					for(char ch : sub.toCharArray()) {
						stack.push(ch);
					}
					count --;
				}
			}
		}
		
		//final fetching and returning the value in stack 
		StringBuilder res = new StringBuilder();
		while(!stack.isEmpty()) {
			res.insert(0, stack.pop());		//must be insert not append
		}
		return res.toString();
	}
	public static void main(String[] args) {
		n394_Decode_String obj = new n394_Decode_String();
		System.out.println(obj.decodeString("3[a]2[bc]"));
		System.out.println(obj.decodeString(""));
	}
}
