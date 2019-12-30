package LeetCode;

import java.util.Arrays;

/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:
Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.

Example 2:
Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 */
public class n279_Perfect_Squares {
	public int numSquares(int n) {
		int[] dp = new int[n+1];
		//Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for(int i=1; i<=n; i++) {
			dp[i] = Integer.MAX_VALUE;
			for(int j=1; j*j<=i; j++) {
				//min = Math.min(min, dp[i-j*j]+1);
				dp[i] = Math.min(dp[i], dp[i-j*j]+1);
			}

			if(dp[i] == Integer.MAX_VALUE) {
				dp[i] = -1;
			}
/*			if(min == Integer.MAX_VALUE) {
				dp[i] = -1;
			} else {
				dp[i] = min;				
			}*/
		}
		return dp[n];
	}
	public static void main(String[] args) {
		n279_Perfect_Squares obj = new n279_Perfect_Squares();
		System.out.println(obj.numSquares(12));
		System.out.println(obj.numSquares(13));
	}
}
