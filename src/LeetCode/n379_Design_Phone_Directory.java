package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class n379_Design_Phone_Directory {
	int max;
	HashSet<Integer> set;
	Queue<Integer> queue;
	
	/** Initialize your data structure here
    @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
	public n379_Design_Phone_Directory(int maxNumbers) {
        set = new HashSet<Integer>();
        queue = new LinkedList<Integer>();	
        
        this.max = maxNumbers;
        
        for (int i = 0; i < maxNumbers; i++) {
            queue.offer(i);
        }
	}

	/** Provide a number which is not assigned to anyone.
    @return - Return an available number. Return -1 if none is available. */
	public int get() {
        if(queue.isEmpty()) {
            return -1;
        }

		int num = queue.poll();
		set.add(num);
		return num;
	}

	/** Check if a number is available or not. */
	public boolean check(int number) {
        if(set.contains(number)) {
            return false;
        } 
        
        return true;
	}

	/** Recycle or release a number. */
	public void release(int number) {
        if(set.remove(number)) {
            queue.offer(number);
        }
	}
}
