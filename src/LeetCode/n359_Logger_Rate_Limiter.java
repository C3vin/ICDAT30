package LeetCode;

import java.util.HashMap;

/*
Design a logger system that receives a stream of messages along with their timestamps. Each unique message should only be printed at most every 10 seconds (i.e. a message printed at timestamp t will prevent other identical messages from being printed until timestamp t + 10).

All messages will come in chronological order. Several messages may arrive at the same timestamp.

Implement the Logger class:

Logger() Initializes the logger object.
bool shouldPrintMessage(int timestamp, string message) Returns true if the message should be printed in the given timestamp, otherwise returns false.
 

Example 1:

Input
["Logger", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage"]
[[], [1, "foo"], [2, "bar"], [3, "foo"], [8, "bar"], [10, "foo"], [11, "foo"]]
Output
[null, true, true, false, false, false, true]

Explanation
Logger logger = new Logger();
logger.shouldPrintMessage(1, "foo");  // return true, next allowed timestamp for "foo" is 1 + 10 = 11
logger.shouldPrintMessage(2, "bar");  // return true, next allowed timestamp for "bar" is 2 + 10 = 12
logger.shouldPrintMessage(3, "foo");  // 3 < 11, return false
logger.shouldPrintMessage(8, "bar");  // 8 < 12, return false
logger.shouldPrintMessage(10, "foo"); // 10 < 11, return false
logger.shouldPrintMessage(11, "foo"); // 11 >= 11, return true, next allowed timestamp for "foo" is
                                      // 11 + 10 = 21
 */
public class n359_Logger_Rate_Limiter {
	HashMap<String, Integer> map;
	
    /** Initialize your data structure here. */
    public n359_Logger_Rate_Limiter() {
        map = new HashMap<String, Integer>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)) {
        	int oldTime = map.get(message) + 10;
        	
        	if(timestamp < oldTime) {
        		return false;
        	} else {
        		map.put(message, timestamp);
        		return true;
        	}
        } else {
        	map.put(message, timestamp);
        	return true;
        }
    }
    
    public static void main(String[] args) {
    	n359_Logger_Rate_Limiter obj = new n359_Logger_Rate_Limiter();
    	System.out.println(obj.shouldPrintMessage(1, "foo"));
    	System.out.println(obj.shouldPrintMessage(2, "bra"));
    	System.out.println(obj.shouldPrintMessage(3, "foo"));
    	System.out.println(obj.shouldPrintMessage(8, "bra"));
    	System.out.println(obj.shouldPrintMessage(10, "foo"));
    	System.out.println(obj.shouldPrintMessage(11, "foo"));
    	
    }
}
