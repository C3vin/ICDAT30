package LeetCode;

import java.util.Arrays;

/**
 * 
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
 */
//http://www.itgo.me/a/x5969926053258658449/leetcode-
//http://www.itgo.me/a/1007311568317016995/221-maximal-square-leetcode
@Alg(type="DP", com="A,FB", level="med", num=221)
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
	public static void main(String[] args){
		n221_Maximal_Square obj = new n221_Maximal_Square();
		char[][] matrix = new char[][]
				{{'1'}};
		/*char[][] matrix = new char[][]
				{{'1','0','1','0','0'},
				 {'1','0','1','1','1'},
				 {'1','1','1','1','1'},
				 {'1','0','0','1','0'}};*/
		System.out.println(obj.maximalSquare(matrix));
	}
}
