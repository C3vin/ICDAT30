package LeetCode;

/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 */
public class n283_Move_Zeroes {
	public void moveZeroes(int[] nums) {
		int pos = 0;
		
		for(int i=0; i<nums.length; i++) {
			if(nums[i] != 0) {
				nums[pos] = nums[i];
				pos++;
			}
		}
		
		for(int i=pos; i<nums.length; i++) {
			nums[i] = 0;
		}
		
		for(int n : nums) 
			System.out.print(n);
	}
	
	public static void main(String[] args) {
		n283_Move_Zeroes obj = new n283_Move_Zeroes();
		obj.moveZeroes(new int[] {0,1,0,3,12});
	}
}
