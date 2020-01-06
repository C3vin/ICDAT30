package LeetCode;

/*
You are given coins of different denominations and a total amount of money. Write a function to compute the number of 
combinations that make up that amount. You may assume that you have infinite number of each kind of coin.

Example 1:
Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1

Example 2:
Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.

Example 3:
Input: amount = 10, coins = [10] 
Output: 1
 
Note:
You can assume that
0 <= amount <= 5000
1 <= coin <= 5000
the number of coins is less than 500
the answer is guaranteed to fit into signed 32-bit integer
 */
public class n518_Coin_Change_2 {
	public int change(int amount, int[] coins) {
		int[] dp = new int[amount+1];
		dp[0] = 1;    							//no mater what coin, only 1 way can change (Do nothing for amount of '0')
		
		for(int i=0; i<coins.length; i++) {
			for(int j=coins[i]; j<=amount; j++) {	//why j=coins[i], cuz no need to check unfit amount for new coin
				//not use coin: dp[j], use coin: dp[j-coins[i]]
				dp[j] = dp[j] + dp[j-coins[i]];	//j-coins[i]: current amount - coins[i]	
			}
		}
		
		return dp[amount];
	}
	public static void main(String[] args) {
		n518_Coin_Change_2 obj = new n518_Coin_Change_2();
		System.out.println(obj.change(5, new int[]{1, 2, 5}));
	}
}
