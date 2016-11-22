package LeetCode;

public class n198_House_Robber {
	public int rob(int[] nums) {
		if(nums.length == 0 || nums == null) 
			return 0;
		if(nums.length==1)
			return nums[0];
		int dp[] = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);		//nums[1] not dp[1]

		for(int i=2; i<nums.length; i++) {
			dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
		}
		return dp[nums.length-1];
	}
	public static void main(String[] args) {
		n198_House_Robber obj = new n198_House_Robber();
		int[] nums = {1,13,5,2,22};
		System.out.println(obj.rob(nums));
	}
}
