package LeetCode;

@Alg(type="DP", com="LL,M$", level="med", num=53)
public class n053_Maximum_Subarray {
	//DP basic Q                             G ---- L 
	//http://mropengate.blogspot.com/2015/01/algorithm-ch2-dynamic-programming.html
	public int maxSubArray(int[] nums) {
		if(nums == null || nums.length==0)  
			return 0;  
		int global = nums[0];  					//default, will update later
		int local = nums[0];  					//default
		for(int i=1; i<nums.length; i++) {		//i=1, cuz we don't need to check first element  
			local = Math.max(nums[i], local+nums[i]);  
			global = Math.max(local, global);
		}  
		return global;  
	}

	public static void main(String[] args) {
		n053_Maximum_Subarray obj = new n053_Maximum_Subarray();
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println("Max: " + obj.maxSubArray(nums));
	}
}
