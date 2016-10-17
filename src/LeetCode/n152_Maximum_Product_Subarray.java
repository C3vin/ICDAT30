package LeetCode;

public class n152_Maximum_Product_Subarray {
	public int maxProduct(int[] nums) {
		int[] max = new int[nums.length];
		int[] min = new int[nums.length];
		int res = nums[0];
		max[0] = min[0] = nums[0];

		for(int i=1; i<nums.length; i++) {
			if(nums[i] > 0) {
				max[i] = Math.max(nums[i], nums[i]*max[i-1]);			//F: is max[i-1]
				min[i] = Math.min(nums[i], nums[i]*min[i-1]);
			} else {
				max[i] = Math.max(nums[i], nums[i]*min[i-1]);			 
				min[i] = Math.min(nums[i], nums[i]*max[i-1]);
			}
			res = Math.max(res, max[i]);
		}
		return res;
	}
	public static void main(String[] args) {
		n152_Maximum_Product_Subarray obj = new n152_Maximum_Product_Subarray();
		int[] nums = {2, 3, -2, 4};
		System.out.println(obj.maxProduct(nums));
	}
}
