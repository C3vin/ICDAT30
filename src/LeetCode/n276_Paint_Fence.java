package LeetCode;

public class n276_Paint_Fence {
	 public int numWays(int n, int k) {
		 int[] dp = {0, k, k*k, 0};			//? need 0
		 
		 if(n <= 2) 		 		//n=1 d[1]=k, n=2 d[2]=k*k
			 return dp[n];
		 
		 for(int i=2; i<n; i++) {
			 dp[3] = (dp[1]+dp[2]) * (k-1);
			 dp[1] = dp[2];
			 dp[2] = dp[3];
		 }
		 return dp[3];
	 }
	 
	 public static void main(String[] args) {
		 n276_Paint_Fence obj = new n276_Paint_Fence();
		 System.out.println(obj.numWays(3, 2));
	 }
}
