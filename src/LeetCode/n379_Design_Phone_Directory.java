package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;

public class n379_Design_Phone_Directory {
	int max;
	HashSet<Integer> set;
	LinkedList<Integer> queue;
	/** Initialize your data structure here
    @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
	public n379_Design_Phone_Directory(int maxNumbers) {
        set = new HashSet<Integer>();
        queue = new LinkedList<Integer>();
        
        for(int i=0; i<maxNumbers; i++){
            queue.offer(i);
        }
        max=maxNumbers-1;
	}

	/** Provide a number which is not assigned to anyone.
    @return - Return an available number. Return -1 if none is available. */
	public int get() {
		if(queue.isEmpty())
			return -1;

		int num = queue.poll();
		set.add(num);
		return num;
	}

	/** Check if a number is available or not. */
	public boolean check(int number) {
		if(!set.contains(number) && number <= max)		//F: !
			return true;
		return false;
	}

	/** Recycle or release a number. */
	public void release(int number) {
		if(set.contains(number)) {
			set.remove(number);
			queue.offer(number);		//F: why need queue.offer? because need to add to queue for check()
		}
	}
}
