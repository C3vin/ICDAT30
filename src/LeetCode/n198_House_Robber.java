package LeetCode;

public class n198_House_Robber {
	//https://www.cnblogs.com/grandyang/p/4383632.html
	/*
	 * 核心思想还是用 DP，分别维护两个变量 robEven 和 robOdd，顾名思义，
	 * robEven 就是要抢偶数位置的房子，robOdd 就是要抢奇数位置的房子。所以在遍历房子数组时，
	 * 如果是偶数位置，那么 robEven 就要加上当前数字，然后和 robOdd 比较，取较大的来更新 robEven。
	 * 这里就看出来了，robEven 组成的值并不是只由偶数位置的数字，只是当前要抢偶数位置而已。
	 * 同理，当奇数位置时，robOdd 加上当前数字和 robEven 比较，取较大值来更新 robOdd，这种按奇偶分别来更新的方法，
	 * 可以保证组成最大和的数字不相邻，最后别忘了在 robEven 和 robOdd 种取较大值返回
	 */
	//[LC198-LC213]
	public int rob3(int[] nums) {
		int robEven = 0;
		int robOdd = 0;
		
		for(int i=0; i<nums.length; i++) {
			if(i % 2 == 0) {
				robEven = Math.max(robEven + nums[i], robOdd);			//robEven + nums[i] !!!
			} else {
				robOdd = Math.max(robOdd + nums[i], robEven);
			}
		}
		
		return Math.max(robOdd, robEven);
	}
	
	public int rob2(int[] nums) {
		// If we get invalid input, return 0
        if (nums == null || nums.length == 0) {
        	return 0;
        }
        
        // Keep track of whether or not we robbed the previous house
        int PreviousIsRobbed = 0;
        int PreviousNotRobbed = 0;
        
        for (int i=0; i<nums.length; i++) {
            
            // If we don't rob the current house, take the max of robbing and not robbing the previous house
            int currentNotRobbed = Math.max(PreviousIsRobbed, PreviousNotRobbed);
            
            // If we rob the current house, add the current money robbed to what we got from not robbing previous
            int currentIsRobbed = PreviousNotRobbed + nums[i];
            
            // Update our values for the next iteration
            PreviousNotRobbed = currentNotRobbed;
            PreviousIsRobbed = currentIsRobbed;
        }
        
        // Return the maximum we could have robbed provided we looked at both options
        return Math.max(PreviousIsRobbed, PreviousNotRobbed);
	}
	
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
		System.out.println(obj.rob(new int[] {1,2,3,1}));
		System.out.println(obj.rob(new int[] {2,7,9,3,1}));
		System.out.println(obj.rob2(new int[] {1,2,3,1}));
		System.out.println(obj.rob2(new int[] {2,7,9,3,1}));
		
		System.out.println(obj.rob3(new int[] {1,2,3,1}));
		System.out.println(obj.rob3(new int[] {2,7,9,3,1}));
	}
}
