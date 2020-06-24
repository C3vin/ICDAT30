package LeetCode;

import java.util.Stack;

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 */
public class n155_Min_Stack {
	/** initialize your data structure here. */
	class NNode {
		public int val;
		public NNode next;
		public int min;

		NNode max;

		public NNode(int v) {
			val = v; 
			min = v; 
			max = this;
		}
	}

	private Stack<Integer> stack;
	private Stack<Integer> minStack;

	public n155_Min_Stack() {			//MinStack
		stack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}

	public void push(int x) {
		stack.push(x);

		if(!minStack.isEmpty()) {
			int peek = minStack.peek();
			if(minStack.peek() >= x) {				//need to check if it is smaller 
				minStack.push(x);
			}
		} else {
			minStack.push(x);
		}
	}

	public void pop() {
		int pop = stack.pop();						//get the value

		if(!minStack.isEmpty()) {
			if(pop == minStack.peek()) {			//need to check if those are the same
				minStack.pop();
			}
		}
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}

	public static void main(String[] args) {
		n155_Min_Stack minStack = new n155_Min_Stack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		minStack.getMin();
		minStack.pop();
		System.out.println("Top: " + minStack.top());
		System.out.println("minStack: " + minStack.getMin());
	}
}
