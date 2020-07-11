package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/*
Design a hit counter which counts the number of hits received in the past 5 minutes.
Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being made to 
the system in chronological order (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.
It is possible that several hits arrive roughly at the same time.

Example:
HitCounter counter = new HitCounter();
// hit at timestamp 1.
counter.hit(1);
// hit at timestamp 2.
counter.hit(2);
// hit at timestamp 3.
counter.hit(3);
// get hits at timestamp 4, should return 3.
counter.getHits(4);
// hit at timestamp 300.
counter.hit(300);
// get hits at timestamp 300, should return 4.
counter.getHits(300);
// get hits at timestamp 301, should return 3.
counter.getHits(301); 

Follow up:
What if the number of hits per second could be very large? Does your design scale?
 */
public class n362_Design_Hit_Counter {
	Queue<Integer> queue; 

	/** Initialize your data structure here. */
	public n362_Design_Hit_Counter() {
		queue = new LinkedList<Integer>();
	}

	/** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
	public void hit(int timestamp) {
		queue.offer(timestamp);			//just add timestamp no need count, we can get the res from size()
	}

	/** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
	public int getHits(int timestamp) {
		//while(!queue.isEmpty() && timestamp - queue.peek() + 1 > 300)
		while(!queue.isEmpty() && timestamp - queue.peek() >= 300) {      //while ! @why >= 300, cuz when 301 second, the timestamp 1 is greater than 5min. 301 - 1 >= 300 
			queue.poll();		//queue.poll() need to check if queue is empty
		}

		return queue.size();
	}
	
	
	//follow up solution 
	
	int[] timestamps;
	int[] hits;
	
	public void n362_Design_Hit_Counter2() {
		timestamps = new int[300];
		hits = new int[300];
	}

	/** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
	public void hit2(int timestamp) {
		int index = timestamp % 300; 		//e.g. 1%300 = 1, 300%300 = 0, 301%300 = 1
		
		if(timestamps[index] != timestamp) {
			timestamps[index] = timestamp;
			hits[index] = 1;
		} else {
			hits[index]++;
		}
	}

	/** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
	public int getHits2(int timestamp) {
        int res = 0;
        
        for(int i=0; i<300; i++) {
        	//if(timestamp - timestamps[i] + 1 <= 300)
            if(timestamp - timestamps[i] < 300) {
                res = res + hits[i];
            }
        }
        
        return res;
	}
}
