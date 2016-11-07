package LeetCode;

@Alg(type="DP", com="LL", level="med", num=152)
//switch max and min when Neg
public class n152_Maximum_Product_Subarray {
	public int maxProduct(int[] nums) {
		int[] Max_local = new int[nums.length];
		int[] min_local = new int[nums.length];
		int global = nums[0];
		Max_local[0] = min_local[0] = nums[0];
		//careful about the max and min
		for(int i=1; i<nums.length; i++) {			//i=1, cuz we don't need to check first element  
			if(nums[i] > 0) {
				Max_local[i] = Math.max(nums[i], nums[i]*Max_local[i-1]);			//F: is max[i-1]
				min_local[i] = Math.min(nums[i], nums[i]*min_local[i-1]);
				System.out.println(i+ " : "+Max_local[i] + " : " + min_local[i]);
			} else {
				Max_local[i] = Math.max(nums[i], nums[i]*min_local[i-1]);			//when deal with Neg, switch min and Max local
				min_local[i] = Math.min(nums[i], nums[i]*Max_local[i-1]);
				System.out.println(i+ " : "+Max_local[i] + " : " + min_local[i]);
			}
			global = Math.max(global, Max_local[i]);
		}
		return global;
	}
	public static void main(String[] args) {
		n152_Maximum_Product_Subarray obj = new n152_Maximum_Product_Subarray();
		int[] nums = {2, 3, -2, 4};
		System.out.println(obj.maxProduct(nums));
	}
}
