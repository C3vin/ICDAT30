package LeetCode;

public class n189_Rotate_Array {
	public void rotate(int[] nums, int k) {
		k = k % nums.length; //handle k > nums.length 
		//step 1, whole array
		reverseArray(nums, 0, nums.length-1);
		//step 2, k
		reverseArray(nums, 0, k-1);
		//step 3, rest
		reverseArray(nums, k, nums.length-1);
		
		for(int i=0; i<nums.length; i++)
			System.out.println(nums[i]);
	}
	public void reverseArray(int[] nums, int l, int r) {
		while(l <= r) {
			int tmp = nums[l];
			nums[l] = nums[r];
			nums[r] = tmp;
			l++;
			r--;
		}
	}
	
	public static void main(String[] args) {
		n189_Rotate_Array obj = new n189_Rotate_Array();
		int[] nums = {1,2,3,4,5,6,7};
		obj.rotate(nums, 3);
	}
}
