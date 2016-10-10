package LeetCode;

public class n238_Product_of_Array_Except_Self {
	public int[] productExceptSelf(int[] nums) {
		int len = nums.length;
		int[] res = new int[len];

		res[0] = 1;
		for (int i=1; i<len; i++) {
			res[i] = res[i-1] * nums[i-1];
		}
		int right = 1;
		for (int i=len-1; i>=0; i--) {
			res[i] = res[i] * right;
			right = right * nums[i];
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
