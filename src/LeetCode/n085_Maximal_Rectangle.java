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
		if (matrix == null || matrix.length == 0) {
			return 0;
		}

		int m = matrix.length;
		int n = matrix[0].length;

		int[] heights = new int[n];
		int maxArea = 0;

		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(matrix[i][j] == '1') {
					heights[j] = heights[j] + 1;		//transfer to LC84
				} else {
					heights[j] = 0;		//why can't use heights[j] + 0, e.g.[["0","1"],["1","0"]] -> [1,1] but actually it won't become the rectangle
				}
			}

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
			while(!stack.isEmpty() && heights[current] <= heights[stack.peek()]) {		//diff than LC84 
				int h = heights[stack.pop()];

				int distance = 0;
				if(stack.isEmpty()) {			//must check! 
					distance = current;
				} else {
					distance = current - stack.peek() - 1;
				}
				//int distance = (stack.isEmpty() ? current : (current - stack.peek() - 1));//current - stack.peek() - 1;

				maxArea = Math.max(maxArea, distance * h);
			}

			stack.push(current);
			current++;
		}

		while(!stack.isEmpty()) {			
			int h = heights[stack.pop()];
			
			int distance = heights.length - (stack.isEmpty() ? -1 : stack.peek()) - 1;
			
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
