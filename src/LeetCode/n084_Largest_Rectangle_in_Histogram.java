package LeetCode;

import java.util.Stack;

/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
find the area of largest rectangle in the histogram.

Example:
Input: [2,1,5,6,2,3]
Output: 10
 */
public class n084_Largest_Rectangle_in_Histogram {
	//Good // LC42-LC84-LC85 Stack template better!
	//https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/29018/AC-clean-Java-solution-using-stack
	public int largestRectangleArea3(int[] heights) {
		Stack<Integer> stack = new Stack<Integer>();									//cur index
		
		int maxArea = 0;
		int current = 0;

		while(current < heights.length) {
			while(!stack.isEmpty() && heights[current] <= heights[stack.peek()]) {		//F: diff than 42
				int h = heights[stack.pop()];

				int distance = 0;
				if(stack.isEmpty()) {			//must check!  same
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
			int h = heights[stack.pop()];

			int distance = 0;
			if(stack.isEmpty()) {				//must check! same
				distance = current;
			} else {
				distance = current - stack.peek() - 1;
			}
			
			maxArea = Math.max(maxArea, distance * h);
		}

		return maxArea;
	}

	// LC42-LC84-LC85 Stack template better!
	public int largestRectangleArea2(int[] heights) {
		Stack<Integer> stack = new Stack<Integer>();			//cur index

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

			int distance = 0;
			if(stack.isEmpty()) {
				distance = current;//; heights.length - (-1) - 1;					//careful to deal with length - (-1) - 1, not just -1 			
			} else {
				distance = current - stack.peek() - 1;   //heights.length - stack.peek() - 1;
			}
			//int distance = heights.length - (stack.isEmpty() ? 0 : stack.peek()) - 1;		//easy to deal with -1

			maxArea = Math.max(maxArea, distance * h);
		}

		return maxArea;
	}

	public static void main(String[] args) {
		n084_Largest_Rectangle_in_Histogram obj = new n084_Largest_Rectangle_in_Histogram();
		System.out.println(obj.largestRectangleArea2(new int[] {2,1,5,6,2,3}));
		System.out.println(obj.largestRectangleArea2(new int[] {1}));

		System.out.println(obj.largestRectangleArea3(new int[] {2,1,5,6,2,3}));
		System.out.println(obj.largestRectangleArea3(new int[] {1}));
	}
}
