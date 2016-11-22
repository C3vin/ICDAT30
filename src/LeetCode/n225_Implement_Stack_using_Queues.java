package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class n225_Implement_Stack_using_Queues {
	private Queue<Integer> q1 = new LinkedList<Integer>();
	private Queue<Integer> q2 = new LinkedList<Integer>();
	
    public void push(int x) {
    	q2.add(x);
    	while(!q1.isEmpty()) {
    		q2.add(q1.poll());
    	}
    	Queue<Integer> tmp = q1;
    	//reset
    	q1 = q2;
    	q2 = tmp;
    }

    // Removes the element on top of the stack.
    public void pop() {
    	q1.poll();
    }

    // Get the top element.
    public int top() {
        return q1.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }
}
