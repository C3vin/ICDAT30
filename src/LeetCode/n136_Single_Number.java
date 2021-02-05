package LeetCode;

import java.util.HashSet;

/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?

Example 1:
Input: nums = [2,2,1]
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4

Example 3:
Input: nums = [1]
Output: 1
 
 */
public class n136_Single_Number {
	//XOR Time Complexity: O(N), Space Complexity: O(1);  
	public int singleNumber(int[] nums) {
		int res = 0;
		for(int i=0; i<nums.length; i++) {
			res = res ^ nums[i];   //keep XOR to the end
		}
		return res;
	}
	/*
	 * Bitwise XOR Operation of 5 and 7
  		0101
	  ^ 0111
     ________
        0010  = 2 (In decimal) 
	 */
	
	
	//HashSet Time Complexity: O(N^2), Space Complexity: O(N);
	public int singleNumber2(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i=0; i<nums.length; i++) {
			if(set.contains(nums[i])) {
				set.remove(nums[i]);
			} else {
				set.add(nums[i]);
			}
		}
		
		for(int i=0; i<nums.length; i++) {
			if(set.contains(nums[i]))
				return nums[i];
		}
		return -1;
	}
	public static void main(String[] args) {
		n136_Single_Number obj = new n136_Single_Number();
		int[] nums = {1,1,2,3,3};				//a xor b xor a = a xor a xor b = 0 xor b = b. 
		System.out.println(obj.singleNumber(nums));
		System.out.println(obj.singleNumber2(nums));
	}
}
