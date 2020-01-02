package LeetCode;

import java.util.Arrays;

/*
You are given coins of different denominations and a total amount of money amount. 
Write a function to compute the fewest number of coins that you need to make up that amount. 
If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.
 */
public class n322_Coin_Change {
	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount+1];					//must + 1
		dp[0] = 0;
		
		//Arrays.sort(coins);

		for(int i=1; i<=amount; i++) {					//must start from 1
			dp[i] = Integer.MAX_VALUE;
			for(int k=0; k<coins.length; k++) {   
				if(i>=coins[k] && dp[i-coins[k]] != -1) {
					System.out.println("@: "+dp[i-coins[k]]);
					dp[i] = Math.min(dp[i], dp[i-coins[k]]+1);
				}
			}
			if(dp[i] == Integer.MAX_VALUE) {
				dp[i] = -1;
			}
		}
		
		return dp[amount];
	}
	public static void main(String[] args) {
		n322_Coin_Change obj = new n322_Coin_Change();
		System.out.println(obj.coinChange(new int[] {1, 2, 5}, 11));
	}
}
