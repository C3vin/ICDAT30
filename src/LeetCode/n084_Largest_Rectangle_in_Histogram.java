package LeetCode;

import java.util.HashSet;
import java.util.Stack;

/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
find the area of largest rectangle in the histogram.

Example:
Input: [2,1,5,6,2,3]
Output: 10
*/
public class n084_Largest_Rectangle_in_Histogram {
	public int largestRectangleArea(int[] heights) {
		HashSet<Integer> heightSet = new HashSet<Integer>();
		
		for(int i=0; i<heights.length; i++) {
			heightSet.add(heights[i]);
		}
		
		int maxArea = 0;
		
		for(int h : heightSet) {
			int width = 0;
			int maxWidth = 1;		//must set default to 1
			for(int i=0; i<heights.length; i++) {
				if(heights[i] >= h) {
					width++;
				} else {
					maxWidth = Math.max(maxWidth, width);
					width = 0;
				}
			}
			maxWidth = Math.max(maxWidth, width); 
			maxArea = Math.max(maxArea, h * maxWidth);
		}
		
		return maxArea;
	}
	
	// LC42-LC84-LC85 Stack template better!
	public int largestRectangleArea2(int[] heights) {
		Stack<Integer> stack = new Stack<Integer>();
		
		int maxArea = 0;
		int current = 0;
		
		while(current < heights.length) {
			//why not using isEmpty to check, cuz '-1' is always in stack (mark the end)
			while(!stack.isEmpty() && heights[current] <= heights[stack.peek()]) {		//F: diff than 42
				int h = heights[stack.pop()];
				
				int distance = 0;
				if(stack.isEmpty()) {			//must check! 
					distance = current;
				} else {
					distance = current - stack.peek() - 1;
				}
				maxArea = Math.max(maxArea, distance * h);
			}
			
			stack.push(current);
			current++;
		}
		//reach the end of the array, we pop all the elements of the stack e.g. handle index 1,4,5 
		while(!stack.isEmpty()) {			
			int h = heights[stack.pop()];					//inside heights[] 
			
/*			int distance = 0;
			if(stack.isEmpty()) {
				distance = heights.length - (-1) - 1;					//careful to deal with length - (-1) - 1, not just -1 			
			} else {
				distance = heights.length - stack.peek() - 1;
			}*/
			int distance = heights.length - (stack.isEmpty() ? -1 : stack.peek()) - 1;		//easy to deal with -1
			
			maxArea = Math.max(maxArea, distance * h);
		}
		
		return maxArea;
	}
	
	public static void main(String[] args) {
		n084_Largest_Rectangle_in_Histogram obj = new n084_Largest_Rectangle_in_Histogram();
		System.out.println(obj.largestRectangleArea(new int[] {2,1,5,6,2,3}));
		System.out.println(obj.largestRectangleArea2(new int[] {2,1,5,6,2,3}));
		System.out.println(obj.largestRectangleArea2(new int[] {1}));
	}
}
