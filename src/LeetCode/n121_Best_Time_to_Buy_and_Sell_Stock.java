package LeetCode;

@Alg(type="DP", com="AA,M$,FB", level="easy", num=121)
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

	public static void main(String[] args) {
		n121_Best_Time_to_Buy_and_Sell_Stock obj = new n121_Best_Time_to_Buy_and_Sell_Stock();
		int stock[] = {7, 1, 5, 3, 6, 4};
		System.out.println(obj.maxProfit(stock));
		System.out.println(obj.maxProfit2(stock));
	}
}
