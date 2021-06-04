package LeetCode;

import java.util.HashMap;
import java.util.Stack;

/*
Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.

Implement the FreqStack class:

FreqStack() constructs an empty frequency stack.
void push(int val) pushes an integer val onto the top of the stack.
int pop() removes and returns the most frequent element in the stack.
If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.
 
Example 1:

Input
["FreqStack", "push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop"]
[[], [5], [7], [5], [7], [4], [5], [], [], [], []]
Output
[null, null, null, null, null, null, null, 5, 7, 5, 4]

Explanation
FreqStack freqStack = new FreqStack();
freqStack.push(5); // The stack is [5]
freqStack.push(7); // The stack is [5,7]
freqStack.push(5); // The stack is [5,7,5]
freqStack.push(7); // The stack is [5,7,5,7]
freqStack.push(4); // The stack is [5,7,5,7,4]
freqStack.push(5); // The stack is [5,7,5,7,4,5]
freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
freqStack.pop();   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
freqStack.pop();   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
 */
public class n895_Maximum_Frequency_Stack {
	/* O(1) https://leetcode.com/problems/maximum-frequency-stack/discuss/163410/C%2B%2BJavaPython-O(1)
    Hash map freq will count the frequence of elements.
    Hash map m is a map of stack.
    If element x has n frequence, we will push x n times in m[1], m[2] .. m[n]
    maxfreq records the maximum frequence.

    push(x) will push x tom[++freq[x]]
    pop() will pop from the m[maxfreq]
    */
    HashMap<Integer, Integer> freq;				//val = freq#
    HashMap<Integer, Stack<Integer>> map;       //freq# = stack val
    int maxFreq;
    
    public n895_Maximum_Frequency_Stack() {
        freq = new HashMap<Integer, Integer>();
        map = new HashMap<Integer, Stack<Integer>>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        freq.put(val, freq.getOrDefault(val, 0)+1);		//freq: //{4=1, 5=3, 7=2}
        
        maxFreq = Math.max(maxFreq, freq.get(val));
        
        if(!map.containsKey(freq.get(val))) {
            map.put(freq.get(val), new Stack<Integer>());
        }
        
        map.get(freq.get(val)).add(val);				//map: {1=[5, 7, 4], 2=[5, 7], 3=[5]}
    }
    
    public int pop() {
        int res = map.get(maxFreq).pop();				//e.g. res = 5
        
        freq.put(res, maxFreq-1);						//update freq 
        
        if(map.get(maxFreq).size() == 0) {				//update maxFreq e.g. [] empty, so maxFreq-- 
            maxFreq--;
        }
        
        return res;
    }
}
