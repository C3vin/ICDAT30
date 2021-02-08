package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Implement the MovingAverage class:

MovingAverage(int size) Initializes the object with the size of the window size.
double next(int val) Returns the moving average of the last size values of the stream.
 

Example 1:

Input
["MovingAverage", "next", "next", "next", "next"]
[[3], [1], [10], [3], [5]]
Output
[null, 1.0, 5.5, 4.66667, 6.0]

Explanation
MovingAverage movingAverage = new MovingAverage(3);
movingAverage.next(1); // return 1.0 = 1 / 1
movingAverage.next(10); // return 5.5 = (1 + 10) / 2
movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3
 */
public class n346_Moving_Average_from_Data_Stream {
	int maxSize;
    List<Integer> queue;
    double sum;             //need to use double
	  /** Initialize your data structure here. */
    public n346_Moving_Average_from_Data_Stream(int size) {
    	 maxSize = size;
         queue = new ArrayList<Integer>();
         sum = 0.0;
    }
    
    public double next(int val) {
    	if(queue.size() < maxSize) {
            sum = sum + val;
        } else {
            int q = queue.remove(0);
            sum = sum  - q + val;
        }
        
        queue.add(val);     //either way both need add into queue

        return sum / queue.size();
    }
    
    public static void main(String[] args) {
    	n346_Moving_Average_from_Data_Stream obj = new n346_Moving_Average_from_Data_Stream(3);
    	System.out.println(obj.next(1));
    	System.out.println(obj.next(10));
    	System.out.println(obj.next(3));
    	System.out.println(obj.next(5));
    }
}
