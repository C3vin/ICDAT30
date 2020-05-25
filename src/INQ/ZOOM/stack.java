package INQ.ZOOM;

import java.util.LinkedList;
import java.util.Queue;

public class stack {
	//push, pop, top
	//LC 225 , LC 232
	Queue<Integer> queue = new LinkedList<Integer>();
	
	public void push(int val) {
		int levelSize = queue.size();		//must before offer, queue size will change later
		
		queue.offer(val);
		
		for(int i=0; i<levelSize; i++) {
			int tmp = queue.poll();
			queue.offer(tmp);
		}
	}
	public int pop() {
		return queue.poll();
	}
	public int top() {
		return queue.peek();
	}
	
	public static void main(String[] args) {
		stack obj = new stack();
		obj.push(10);
		obj.push(20);
		System.out.println(obj.top());
		obj.pop();
		obj.push(30);
		obj.pop();
		System.out.println(obj.top());
	}
}
