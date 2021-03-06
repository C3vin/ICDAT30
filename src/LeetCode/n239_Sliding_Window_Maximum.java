package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
You can only see the k numbers in the window. Each time the sliding window moves right by one position.
For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].
*/
		
public class n239_Sliding_Window_Maximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || k <= 0) {
			return new int[0];
		}
		
		int[] res = new int[nums.length - k + 1];			//need + 1
		Deque<Integer> q = new ArrayDeque<Integer>();		//store index
		int rIndex = 0;
		
		for(int i=0; i<nums.length; i++) {
			while(!q.isEmpty() && q.peek() == i-k) 				//remove numbers out of range k 
				q.poll();
			
			while(!q.isEmpty() && nums[q.peekLast()] < nums[i])	//remove smaller numbers in k range as they are useless
				q.pollLast();									//use while loop, so it will test all the value in q
			
			q.offer(i);		
		
			if(i+1 >= k)	//need to use i+1 >= k, 2+1 >= 3, so need to update res
				res[rIndex++] = nums[q.peek()];					//F: rIndex++, so we can add to next if need it
		}
/*		for(int x : res)
			System.out.print(x);*/
		return res;
	}
	public static void main(String[] args) {
		n239_Sliding_Window_Maximum obj = new n239_Sliding_Window_Maximum();
		int[] nums = {1,3,1,2,0,5};//{1,3,-1,-3,5,3,6,7};
		int k = 3;
		System.out.println(obj.maxSlidingWindow(nums, k));
	}
}
