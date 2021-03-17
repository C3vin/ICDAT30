package LeetCode;

import java.util.Stack;

/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:
Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6
 */
public class n085_Maximal_Rectangle {
	public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int[] heights = new int[matrix[0].length];      //need this not matrix.length !!!	
		int maxArea = 0;

		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				if(matrix[i][j] == '1') {
					heights[j] = heights[j] + 1;		//transfer to LC84
				} else {
					heights[j] = 0;		//why can't use heights[j] + 0, e.g.[["0","1"],["1","0"]] -> [1,1] but actually it won't become the rectangle
				}
			}

			/*  
			 heights[0] = [1,0,1,0,0]
			 heights[1] = [2,0,2,1,1] ... 
			 */

			maxArea = Math.max(maxArea, helper(heights));		//need to inside the for loop !!!
		}

		return maxArea;
	}

	// LC42-LC84-LC85 Stack template
	private int helper(int[] heights) {
		Stack<Integer> stack = new Stack<Integer>();
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

	public static void main(String[] args) {
		n085_Maximal_Rectangle obj = new n085_Maximal_Rectangle();
		char[][] matrix = {
				{'1', '0', '1', '0', '0'},
				{'1', '0', '1', '1', '1'},
				{'1', '1', '1', '1', '1'},
				{'1', '0', '0', '1', '0'}};
		System.out.println(obj.maximalRectangle(matrix));

		char[][] matrix2 = {
				{'1', '0'}};
		System.out.println(obj.maximalRectangle(matrix2));

		char[][] matrix3 = {
				{'0', '1'},
				{'1', '0'}};
		System.out.println(obj.maximalRectangle(matrix3));
	}
}
