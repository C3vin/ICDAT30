package LeetCode;

/*
Given numBottles full water bottles, you can exchange numExchange empty water bottles for one full water bottle.
The operation of drinking a full water bottle turns it into an empty bottle.
Return the maximum number of water bottles you can drink.

Example 1:
Input: numBottles = 9, numExchange = 3
Output: 13
Explanation: You can exchange 3 empty bottles to get 1 full water bottle.
Number of water bottles you can drink: 9 + 3 + 1 = 13.

Example 2:
Input: numBottles = 15, numExchange = 4
Output: 19
Explanation: You can exchange 4 empty bottles to get 1 full water bottle. 
Number of water bottles you can drink: 15 + 3 + 1 = 19.
 */
public class n1518_Water_Bottles {
	public int numWaterBottles(int numBottles, int numExchange) {
		int sum = 0;
		int count = 0;
		
		while(numBottles > 0) {
			sum = sum + numBottles;
			count = count + numBottles;
			
			numBottles = count / numExchange;
			
			count = count % numExchange;
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		n1518_Water_Bottles obj = new n1518_Water_Bottles();
		System.out.println(obj.numWaterBottles(15, 4));
	}
}
