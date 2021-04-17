package LeetCode;

import java.util.Stack;

/*
Given a string s which represents an expression, evaluate this expression and return its value. 
The integer division should truncate toward zero.

Example 1:
Input: s = "3+2*2"
Output: 7

Example 2:
Input: s = " 3/2 "
Output: 1

Example 3:
Input: s = " 3+5 / 2 "
Output: 5
 */
public class n227_Basic_Calculator_II {
    public int calculate(String s) {
        if(s == null || s.length() == 0) {
        	return 0;
        }
        
        int res = 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        int operand = 0;
        char operation = '+';
        
        for(int i=0; i<s.length(); i++) {
        	char c = s.charAt(i);
        	
        	if(Character.isDigit(c)) {
        		operand = operand * 10 + (int)(c - '0');
        	}
        	//i==s.length()-1, cuz need handle last digit's operations, won't pass isDigit(c) e.g. 2 * 2' <-(last digit 2') 
        	if(!Character.isDigit(c) && !Character.isWhitespace(c) || i == s.length() -1) {	
        		if(operation == '+') {
        			stack.push(operand);
        			
        		} else if(operation == '-' ) {
        			stack.push(-operand);
        			
        		} else if(operation == '*') {
        			stack.push(stack.pop() * operand);
        			
        		} else if(operation == '/') {
        			stack.push(stack.pop() / operand);
        		}
        		
        		operation = c;					//assign
        		operand = 0;					//reset
        	}
        }
        
        while(!stack.isEmpty()) {				//while
        	res = res + stack.pop();
        }
        
        return res;
    }
    
    public static void main(String[] args) {
    	n227_Basic_Calculator_II obj = new n227_Basic_Calculator_II();
    	//System.out.println(obj.calculate("321"));
    	System.out.println(obj.calculate("3+2*2"));
    	System.out.println(obj.calculate(" 3/2 "));
    	System.out.println(obj.calculate(" 3+5 / 2 "));
    }
}
