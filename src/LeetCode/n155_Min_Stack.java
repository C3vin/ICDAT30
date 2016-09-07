package LeetCode;

import java.util.ArrayList;

public class n155_Min_Stack {
	/** initialize your data structure here. */
	class NNode {
		NNode next;
		int val;
		int min;

		NNode max;

		NNode(int v){val = v; min = v; max = this;}
	}
	private NNode top;
	ArrayList<Integer> stack = new ArrayList<Integer>();
	ArrayList<Integer> minStack = new ArrayList<Integer>();
	public n155_Min_Stack() {
		top = new NNode(0);
	}

	public void push(int x) {
		stack.add(x);
		if(minStack.isEmpty() || minStack.get(minStack.size()-1) >= x){
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
	}
	public static void main(String[] args) {
		n155_Min_Stack minStack = new n155_Min_Stack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(1);
		minStack.push(-3);
		//minStack.pop();
		System.out.println(minStack.getMin());
		
/*		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		System.out.println(arr.toString());
		System.out.println(arr.size());
		System.out.println(arr.get(arr.size()-1));*/
	}
}
