package LeetCode;

public class n256_Paint_House {
	public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        
      //dp[i][j] -- the min cost for house i on painting color j
      //dp[i][R] = cost[i][R] + Math.min(dp[i - 1][B], dp[i - 1][G]);
      //dp[i][B] = cost[i][B] + Math.min(dp[i - 1][R], dp[i - 1 ][G]);
      //dp[i][G] = cost[i][G] + Math.min(dp[i - 1][R], dp[i - 1][B]);

      //Final status: min(dp[n - 1][R], dp[n - 1][B], dp[n - 1][G]);
        
        for(int i = 1; i < costs.length; i++) {				//F: i=1
            costs[i][0] = costs[i][0] + Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i-1][0], costs[i-1][1]);
        }
        int n = costs.length;
        return Math.min(costs[n-1][0], Math.min(costs[n-1][1], costs[n-1][2]));
	}

	public static void main(String[] args) {
		n256_Paint_House obj = new n256_Paint_House();
		int [][] costMatrix = 			   
			   {{7, 5, 10},
				{3, 6, 1 },
				{8, 7, 4 },
				{6, 2, 9 },
				{1, 4, 7 },
				{2, 3, 6 },
		};
		System.out.println("Cost of coloring the house is: " + obj.minCost(costMatrix));
	}
}
