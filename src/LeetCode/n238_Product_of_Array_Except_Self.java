package LeetCode;

/*
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal 
to the product of all the elements of nums except nums[i].

Example:
Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).
Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class n238_Product_of_Array_Except_Self {
	//https://www.cnblogs.com/grandyang/p/4650187.html
	public int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];
		int[] fwd = new int[nums.length];
		int[] bwd = new int[nums.length];
		fwd[0] = 1;
		bwd[nums.length-1] = 1;
		
		for(int i=1; i<nums.length; i++) {
			fwd[i] = fwd[i-1] * nums[i-1];
		}
		for(int i=nums.length-2; i>=0; i--) {		//-2 not -1
			bwd[i] = bwd[i+1] * nums[i+1];
		}
		
		for(int i=0; i<nums.length; i++) {
			res[i] = fwd[i] * bwd[i]; 
		}

		return res;
	}
	
	//optimization
	public int[] productExceptSelf2(int[] nums) {
		int[] res = new int[nums.length];
		res[0] = 1;
		
		int bwd = 1;
		
		for(int i=1; i<nums.length; i++) {
			res[i] = res[i-1] * nums[i-1];
		}
		for(int i=nums.length-1; i>=0; i--) {
			res[i] = res[i] * bwd;
			bwd = bwd * nums[i];				//bwd[i] = bwd[i+1] * nums[i+1] e.g. bwd[3] = bwd[4] * nums[4]
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		n238_Product_of_Array_Except_Self obj = new n238_Product_of_Array_Except_Self();
		int[] nums = {1,2,3,4};
		System.out.println(obj.productExceptSelf(nums));
		System.out.println(obj.productExceptSelf2(nums));
	}
}
