package LeetCode;

/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the 
bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

Above is a 7 x 3 grid. How many possible unique paths are there?


Example 1:
Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right

Example 2:
Input: m = 7, n = 3
Output: 28
 */
public class n062_Unique_Paths {
	//LC62 - LC64 sol
	public int uniquePaths(int m, int n) {
		int[][] res = new int[m][n];			//diff than LC 64 is need to create int array

		for(int i=0; i<m; i++) {				//and assign the 1 for right and down ONLY!!!
			res[i][0] = 1;
		}

		for(int i=0; i<n; i++) {
			res[0][i] = 1;
		}

		for(int i=1; i<m; i++) {				//i=1, j=1 not start with 0
			for(int j=1; j<n; j++) {
				res[i][j] = res[i][j-1] + res[i-1][j];		//only add right value + down value
			}
		}

		return res[m-1][n-1];
	}

	public static void main(String[] args) {
		n062_Unique_Paths obj = new n062_Unique_Paths();
		System.out.println(obj.uniquePaths(3, 2));
		System.out.println(obj.uniquePaths(7, 3));
	}
}
