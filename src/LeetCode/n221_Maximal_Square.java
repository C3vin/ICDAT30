package LeetCode;

import java.util.Stack;

/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:
Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
 */
public class n221_Maximal_Square {
	public int maximalSquare(char[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int dp[][] = new int[m][n];
		int max = 0;
		//top row
		for(int i=0; i<m; i++) {
			if(matrix[i][0] == '1'){
				dp[i][0] = 1;
				max=1;
			}
		}
		//left column
		for(int j=0; j<n; j++) {
			if(matrix[0][j] == '1'){
				dp[0][j] = 1;
				max=1;				//Need to put max = 1 
			}
		}
		for(int i=1; i<m; i++) {
			for(int j=1; j<n; j++) {
				if(matrix[i][j] == '1'){
					int min = Math.min(dp[i-1][j-1], dp[i-1][j]);
					min = Math.min(min, dp[i][j-1]);
					dp[i][j] = min+1;
					
					if(dp[i][j] > max) 
						max = dp[i][j];
				}
			}
			//System.out.println(Arrays.toString(dp[i]));		//start at 1
		}
		return max*max;
	}
	
	// LC42-LC84-LC85 Stack template, almost same as LC85
	public int maximalSquare2(char[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		int maxSide = 0;				//no need maxArea, this is for square
		
		int[] height = new int[n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(matrix[i][j] == '1') {
					height[j] = height[j] + 1;
				} else {
					height[j] = 0;
				}
			}
			
			maxSide = Math.max(maxSide, helper(height));			//need to inside the for loop
		}

		return maxSide * maxSide;		//square
	}
	
	private int helper(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
		
		int current = 0;
		int maxSide = 0;
		
		while(current < height.length) {
			while(!stack.isEmpty() && height[current] <= height[stack.peek()]) {
				int h = height[stack.pop()];
				
				int d = (stack.isEmpty() ? current : current - stack.peek() - 1);
				int squareWide = Math.min(h, d);				//square, so compare the widths
				
				maxSide = Math.max(maxSide, squareWide);
			}
			
			stack.push(current);
			current++;
		}
		
		while(!stack.isEmpty()) {
			int h = height[stack.pop()];
			
			int d = height.length - (stack.isEmpty() ? -1 : stack.peek()) - 1;
			int squareWide = Math.min(h, d);					//square, so compare the widths
			
			maxSide = Math.max(maxSide, squareWide);
		}
		
		return maxSide;
	}
	
	public static void main(String[] args){
		n221_Maximal_Square obj = new n221_Maximal_Square();
		char[][] matrix = new char[][]
				{{'1', '1'}};
		char[][] matrix2 = new char[][]
				{{'1','0','1','0','0'},
				 {'1','0','1','1','1'},
				 {'1','1','1','1','1'},
				 {'1','0','0','1','0'}};
				 
		System.out.println(obj.maximalSquare(matrix));
		System.out.println(obj.maximalSquare2(matrix));
		
		System.out.println(obj.maximalSquare(matrix2));
		System.out.println(obj.maximalSquare2(matrix2));
	}
}
