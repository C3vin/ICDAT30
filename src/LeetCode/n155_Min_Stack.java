package LeetCode;

import java.util.Stack;

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
	Stack<Integer> data;
	Stack<Integer> minStack;
	public n155_Min_Stack() {			//MinStack
		data = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}

	public void push(int x) {
		data.push(x);
		if(minStack.isEmpty() || minStack.peek() >= x)
			minStack.push(x);
/*		else {
			if(minStack.peek() >= x)
				minStack.push(x);
		}*/
	}

	public void pop() {
		int val = data.pop();
		if(!minStack.isEmpty() && minStack.peek() == val)		//== not >=
			minStack.pop();
	}

	public int top() {
		return data.peek();
	}

	public int getMin() {
		return minStack.peek();
	}

	/*	//private NNode top;
	ArrayList<Integer> stack = new ArrayList<Integer>();
	ArrayList<Integer> minStack = new ArrayList<Integer>();

	public n155_Min_Stack() {
		//top = new NNode(0);
	}

	public void push(int x) {
		stack.add(x);
		if(minStack.isEmpty() || minStack.get(minStack.size()-1) >= x){		//if latest element bigger than x, than found the min element need to add to minStack
			minStack.add(x);
		}
	}

	public void pop() {
		if(stack.isEmpty()) 
			return;
		int elem = stack.remove(stack.size()-1);  
		if(!minStack.isEmpty() && elem == minStack.get(minStack.size()-1))  
		{  
			minStack.remove(minStack.size()-1);  
		}  
	}

	public int top() {
		if(!stack.isEmpty())  
			return stack.get(stack.size()-1);  
		return 0; 
	}

	public int getMin() {
		if(!minStack.isEmpty())  
			return minStack.get(minStack.size()-1);  
		return 0; 
	}*/
	public static void main(String[] args) {
		n155_Min_Stack minStack = new n155_Min_Stack();
		minStack.push(-3);
		minStack.push(0);
		minStack.push(1);
		minStack.push(4);
		minStack.pop();
		System.out.println("Top: " + minStack.top());
		System.out.println("minStack: " + minStack.getMin());
	}
}
