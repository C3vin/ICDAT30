package LeetCode;

public class n189_Rotate_Array {
	//T: O(n), S:O(1)
	public void rotate(int[] nums, int k) {
/*		   Original List        : 1 2 3 4 5 6 7
After reversing all numbers     : 7 6 5 4 3 2 1
After reversing first k numbers : 5 6 7 4 3 2 1
After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result */

		k = k % nums.length; 						//handle k > nums.length 
		reverseArray(nums, 0, nums.length-1);
		reverseArray(nums, 0, k-1);					//0 - k
		reverseArray(nums, k, nums.length-1);		//k - end
		
		for(int i=0; i<nums.length; i++)
			System.out.print(nums[i]);
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
	
	//Using Extra Array T/S: O(n)
	public void rotate2(int[] nums, int k) {
		int[] knums = new int[nums.length];
		
		for(int i=0; i<nums.length; i++) {
			knums[(i+k)%nums.length] = nums[i];			//?
		}
		for(int i=0; i<nums.length; i++) {
			nums[i] = knums[i];
		}
		
		for(int i=0; i<nums.length; i++)
			System.out.print(nums[i]);
	}
	public static void main(String[] args) {
		n189_Rotate_Array obj = new n189_Rotate_Array();
		int[] nums = {1,2,3,4,5,6,7};
		obj.rotate(nums, 3);
		System.out.println();
		int[] nums1 = {1,2,3,4,5,6,7};
		obj.rotate2(nums1, 3);
	}
}
