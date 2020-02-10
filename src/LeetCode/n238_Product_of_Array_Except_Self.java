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
	public int[] productExceptSelf(int[] nums) {
		int len = nums.length;
		int[] res = new int[len];

		res[0] = 1;
		for (int i=1; i<len; i++) {
			res[i] = res[i-1] * nums[i-1];
		}
		
		for(int i=0; i<len; i++)
			System.out.println("left: " + res[i]);
		
		int right = 1;
		for (int i=len-1; i>=0; i--) {
			res[i] = res[i] * right;
			right = right * nums[i];
			
			System.out.println(i+ " : " +res[i] + " : " + right);
			/*res[i] *= right;
			right *= nums[i];*/
		}

		for(int i=0; i<len; i++)
			System.out.println(res[i]);

		return res;
	}
	public static void main(String[] args) {
		n238_Product_of_Array_Except_Self obj = new n238_Product_of_Array_Except_Self();
		int[] nums = {1,2,3,4};
		System.out.println(obj.productExceptSelf(nums));
	}
}
