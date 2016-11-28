package LeetCode;

import java.io.IOException;
import java.util.LinkedList;

//["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
public class n150_Evaluate_Reverse_Polish_Notation {
	public int evalRPN(String[] tokens) {
		int res = 0;
		String op = "+-*/";
		LinkedList<String> stack = new LinkedList<String>();
		
		for(String s : tokens) {
			if(!op.contains(s))
				stack.push(s);
			else {
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());
				switch(s) {
				case "+": 
					stack.push(String.valueOf(a+b));
					break;
				case "-":
					stack.push(String.valueOf(a-b));
					break;
				case "*":
					stack.push(String.valueOf(a*b));
					break;
				case "/":
					stack.push(String.valueOf(a/b));
					break;
				}
			}
		}
		res = Integer.valueOf(stack.pop());
		return res;
	}
	public static void main(String[] args) throws IOException {
		n150_Evaluate_Reverse_Polish_Notation obj = new n150_Evaluate_Reverse_Polish_Notation();
		String[] tokens = new String[] { "2", "1", "+", "3", "*" };
		System.out.println(obj.evalRPN(tokens));
	}
}
