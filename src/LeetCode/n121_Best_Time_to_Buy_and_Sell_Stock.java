package LeetCode;

/*
Say you have an array for which the i^th element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (i.e., buy one and sell 
one share of the stock), design an algorithm to find the maximum profit.
Note that you cannot sell a stock before you buy one.

Example 1:
Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:
Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class n121_Best_Time_to_Buy_and_Sell_Stock {
	public int maxProfit(int[] prices) {
		if(prices.length == 0) return 0;

		int local = 0;
		int global = 0;
		for(int i=0; i<prices.length-1; i++) {		//cuz prices[i+1]
			local = Math.max(local + prices[i+1]-prices[i], 0);
			global = Math.max(local, global);
		}
		return global;
	}

	/**
	 * Go through the string and maintain one min sell price, and keep one largest profit.
	 * Better to understand
	 */
	public int maxProfit2(int[] prices) {
		int min = Integer.MAX_VALUE;		//MAX_VALUE
		int max = 0;
		
		for(int i=0; i<prices.length; i++) {
			min = Math.min(min, prices[i]);
			max = Math.max(max, prices[i] - min);
		}
		return max;
	}

	//cs
	//time:O(n) space:O(1)
	public int maxProfit3(int[] prices) {
		if(prices == null || prices.length < 2) {
			return 0;
		}
		
		int min = Integer.MAX_VALUE;
		int profit = 0;
		
		for(int price : prices) {
			min = Math.min(min, price);
			profit = Math.max(profit, price-min);
		}
		return profit;
	}
	
	public static void main(String[] args) {
		n121_Best_Time_to_Buy_and_Sell_Stock obj = new n121_Best_Time_to_Buy_and_Sell_Stock();
		int stock[] = {7, 1, 5, 3, 6, 4};
		System.out.println(obj.maxProfit(stock));
		System.out.println(obj.maxProfit2(stock));
		System.out.println(obj.maxProfit3(stock));
	}
}
