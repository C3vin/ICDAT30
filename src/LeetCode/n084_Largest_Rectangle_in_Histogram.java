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
			int maxWidth = 1;		//?
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
	
	public int largestRectangleArea2(int[] heights) {
		if(heights == null || heights.length == 0) {
			return 0;
		}
		Stack<Integer> stack = new Stack<Integer>();
		
		int res = 0;
		
		for(int i=0; i<heights.length; i++) {
			//int h = i == heights.length ? 0 : heights[i];
			
			int h = 0;
			if(i == heights.length) {
				h = 0;
			} else {
				h = heights[i];
			}
			
			//System.out.println("h: "+h);
			
			while(!stack.isEmpty() && h<heights[stack.peek()]) {
				int height = heights[stack.pop()];
				int start = stack.isEmpty() ? -1 : stack.peek(); //?
				int area = height * (i - start -1);
				
				res = Math.max(res, area);
			}
			stack.push(i);
		}
		
		return res;
	}
	
	// LC42-LC84 Stack template
	public int largestRectangleArea3(int[] heights) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);
		
		int maxArea = 0;
		int current = 0;
		
		while(current < heights.length) {
			//why not using isEmpty to check, cuz '-1' is always in stack (mark the end)
			while(stack.peek() != -1 && heights[current] <= heights[stack.peek()]) {
				int h = heights[stack.pop()];
				
				int distance = current - stack.peek() - 1;
				maxArea = Math.max(maxArea, distance * h);
			}
			stack.push(current);
			current++;
		}

		while(stack.peek() != -1) {
			int h = heights[stack.pop()];
			int distance = heights.length - stack.peek() - 1;
			maxArea = Math.max(maxArea, distance * h);
		}
		
		
		return maxArea;
	}
	
	public static void main(String[] args) {
		n084_Largest_Rectangle_in_Histogram obj = new n084_Largest_Rectangle_in_Histogram();
		System.out.println(obj.largestRectangleArea(new int[] {2,1,5,6,2,3}));
		System.out.println(obj.largestRectangleArea2(new int[] {2,1,5,6,2,3}));
		System.out.println(obj.largestRectangleArea3(new int[] {2,1,5,6,2,3}));
	}
}
