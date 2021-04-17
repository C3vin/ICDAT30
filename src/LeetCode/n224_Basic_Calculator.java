package LeetCode;

import java.util.Stack;

/*
Given a string s representing an expression, implement a basic calculator to evaluate it.

Example 1:
Input: s = "1 + 1"
Output: 2

Example 2:
Input: s = " 2-1 + 2 "
Output: 3

Example 3:
Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23
 */
public class n224_Basic_Calculator {
	/*
Principle:
(Sign before '+'/'-') = (This context sign);
(Sign after '+'/'-') = (This context sign) * (1 or -1);

Algorithm:
Start from +1 sign and scan s from left to right;
if c == digit: This number = Last digit * 10 + This digit;
if c == '+': Add num to result before this sign; This sign = Last context sign * 1; clear num;
if c == '-': Add num to result before this sign; This sign = Last context sign * -1; clear num;
if c == '(': Push this context sign to stack;
if c == ')': Pop this context and we come back to last context;
Add the last num. This is because we only add number after '+' / '-'.
	 */
	//Good
	public int calculate2(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int operand = 0;
		int res = 0;
		int sign = 1;

		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);

			if(Character.isDigit(c)) {
				operand = operand * 10 + (int)(c - '0');
			} else if(c == '+') {
				res = res + sign * operand;		//if we use operand need reset later

				sign = 1;			//set '+' sign
				operand = 0;		//reset
			} else if(c == '-') {
				res = res + sign * operand;

				sign = -1;			//set '-' sign
				operand = 0;		//reset	operand
			} else if(c == '(') {
				// Push the result and sign on to the stack, for later
				// We push the result first, then sign
				stack.push(res);	//1. res
				stack.push(sign);	//2. sign

				sign = 1;			//reset sign
				res = 0;			//reset res !!! not operand

			} else if(c == ')') {
				res = res + sign * operand;

				res = res * stack.pop();		//this is sign, so *
				res = res + stack.pop();		//this is res, so +

				operand = 0;		//reset operand
			}
		}

		res = res + sign * operand;	//handle last element without ')' e.g. 1+1

		return res;
	}

	public int calculate(String s) {
		if(s == null) {
			return 0;
		}

		int res = 0;
		int sign = 1;
		int num = 0;

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);		//Start from +1 sign and scan s from left to right;

		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);

			if(c >= '0' && c <= '9') {
				num = num * 10 + (c - '0');

			} else if( c == '+' || c == '-') {
				res = res + sign * num;
				sign = stack.peek() * (c == '+' ? 1 : -1);

				num = 0;					//reset num

			} else if(c == '(') {
				stack.push(sign);			//sign not c!!!

			} else if(c == ')') {
				stack.pop();
			}
		}

		res = res + sign * num;

		return res;
	}

	public static void main(String[] args) {
		n224_Basic_Calculator obj = new n224_Basic_Calculator();
		//System.out.println(obj.calculate("1+1"));
//		System.out.println(obj.calculate("2-1+2"));
//		System.out.println(obj.calculate("(4-(1+2)+6)"));
//		System.out.println(obj.calculate("(1+(4+5+2)-3)+(6+8)"));

		System.out.println(obj.calculate2("1+1"));
		System.out.println(obj.calculate2("2-1+2"));
		System.out.println(obj.calculate2("(4-(1+2)+6)"));
		System.out.println(obj.calculate2("(1+(4+5+2)-3)+(6+8)"));
	}
}
