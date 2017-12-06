package Alg;

public class MyStack {
	private int maxSize;
	private int[] stackArray;
	private int top; 
	
	public MyStack(int s){
		maxSize = s;
		stackArray = new int[s];
		top = -1;
	}
	public void push(int x) {
		top++;
		stackArray[top] = x;
	}
	public int pop() {
		return stackArray[top--];
	}
	public int peek() {
		return stackArray[top];
	}
	public boolean isEmpty() {
		return (top == -1);
	}
	public boolean isFull() {
		return (top == maxSize-1);
	}
	public static void main(String[] args) {
		MyStack mystack = new MyStack(10);
		mystack.push(1);
		mystack.push(2);
		mystack.push(3);
		mystack.push(4);
		mystack.push(5);
		
		System.out.println("isempty: " + mystack.isEmpty() + " isfull: " + mystack.isFull() + " peek: " + mystack.peek());
		mystack.pop(); 
		mystack.pop();
		System.out.println(mystack.peek());
	}
}
