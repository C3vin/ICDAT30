package LeetCode;

/*
You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:
Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 */
public class n070_Climbing_Stairs {
	public int climbStairs(int n) {
		//think about fibonacci  https://www.programiz.com/java-programming/examples/fibonacci-series
		int f1 = 1;
		int f2 = 2;
		
		if(n == 1) {
			return f1;
		}
		if(n == 2) {
			return f2;
		}
		
		for(int i=3; i<=n; i++) {
			int f3 = f1 + f2;
			f1 = f2;
			f2 = f3;
		}
		return f2;	//why f2, cuz it contain f3 value
	}
	
	//DP
	public int climbStairs2(int n) {
		if(n==0 || n==1 || n==2) return n;
		int[] dp = new int[n+1];			//n+1, cuz dp[0]
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3; i<n+1; i++) {			//n+1
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];						//only need the lastest one dp[n]
	}
	public static void main(String[] args) {
		n070_Climbing_Stairs obj = new n070_Climbing_Stairs();
		System.out.println(obj.climbStairs(4));
		System.out.println(obj.climbStairs2(5));
	}
}
