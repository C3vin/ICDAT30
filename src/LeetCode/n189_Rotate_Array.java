package LeetCode;

/*
Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:
Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:
Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 */
public class n189_Rotate_Array {
	/*		   Original List        : 1 2 3 4 5 6 7
	After reversing all numbers     : 7 6 5 4 3 2 1
	After reversing first k numbers : 5 6 7 4 3 2 1
	After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result 
	 */
	//cs
	//time:O(n), space:O(1)
	public void rotate(int[] nums, int k) {
		k = k % nums.length; 						//handle k > nums.length 
		reverseArray(nums, 0, nums.length-1);
		reverseArray(nums, 0, k-1);					//0 - k
		reverseArray(nums, k, nums.length-1);		//k - end

		for(int i=0; i<nums.length; i++)
			System.out.print(nums[i]);
	}
	public void reverseArray(int[] nums, int l, int r) {
		while(l < r) {
			int tmp = nums[l];
			nums[l] = nums[r];
			nums[r] = tmp;

			l++;
			r--;
		}
	}

	//Using Extra Array 
	//cs
	//time: O(n) space: O(n)
	//[1,2,3,4,5,6,7]
	// 5,6,7,1,2,3,4 <= but is in tmp so need tp cp again to original  
	public void rotate2(int[] nums, int k) {
		int[] temp = new int[nums.length];

		for(int i=0; i<nums.length; i++) {
			temp[(i+k) % nums.length] = nums[i];		//handle k > nums.length
		}
		
		for(int i=0; i<nums.length; i++) {
			nums[i] = temp[i];
		}

		for(int i=0; i<nums.length; i++)
			System.out.print(nums[i]);
	}
	public static void main(String[] args) {
		n189_Rotate_Array obj = new n189_Rotate_Array();
		int[] nums = {1,2,3,4,5,6,7};
		obj.rotate(nums, 3);
		System.out.println();
/*		int[] nums1 = {1,2,3,4,5,6,7};
		obj.rotate2(nums1, 3);*/
	}
}
