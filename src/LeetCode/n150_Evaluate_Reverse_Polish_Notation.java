package LeetCode;

import java.io.IOException;
import java.util.Stack;

/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
Example 1:

Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
Output: 22
Explanation: 
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
 */

//["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
public class n150_Evaluate_Reverse_Polish_Notation {
	
	//Stack + Integer.valueOf + String.valueOf (convert)
	public int evalRPN(String[] tokens) {
		int res = 0;
		
		String op = "+-*/";
		Stack<String> stack = new Stack<String>();
		
		for(String s : tokens) {
			if(!op.contains(s))								//String can use contains()
				stack.push(s);
			else {
				int a = Integer.valueOf(stack.pop());		//Integer.valueOf
				int b = Integer.valueOf(stack.pop());
				
				switch(s) {
				case "+": 
					stack.push(String.valueOf(b+a));		//String.valueOf
					break;
				case "-":
					stack.push(String.valueOf(b-a));		//b - a !!! 
					break;
				case "*":
					stack.push(String.valueOf(b*a));		
					break;
				case "/":
					stack.push(String.valueOf(b/a));		//b / a !!!
					break;
				}
			}
		}
		
		res = Integer.valueOf(stack.pop());					//Integer.valueOf
		
		return res;
	}
	public static void main(String[] args) throws IOException {
		n150_Evaluate_Reverse_Polish_Notation obj = new n150_Evaluate_Reverse_Polish_Notation();
		String[] tokens = new String[] { "2", "1", "+", "3", "*" };
		System.out.println(obj.evalRPN(tokens));
		System.out.println(obj.evalRPN(new String[] {"4", "13", "5", "/", "+"}));
		System.out.println(obj.evalRPN(new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
	}
}
