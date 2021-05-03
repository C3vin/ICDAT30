package LeetCode;

import java.util.Arrays;

/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:
Input: [3,0,1]
Output: 2

Example 2:
Input: [9,6,4,2,3,5,7,0,1]
Output: 8
Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class n268_Missing_Number {
	//Good! 
	public int missingNumber2(int[] nums) {
		int i=0;
		while(i < nums.length) {
			//only nums[nums[i]] not nums[nums[i]-1], diff 'range' than [LC287-LC448] 
			if(nums[i] < nums.length && nums[i] != nums[nums[i]]) {		//no need to check nums[i] > 0 [LC41]
				swap(nums, i, nums[i]);
			} else {
				i++;
			}
		}

		for(int j=0; j<nums.length; j++) {
			if(nums[j] != j) {
				return j;
			}
		}

		return nums.length;		//diff than LC41
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public int missingNumber(int[] nums) {
		Arrays.sort(nums);

		if(nums.length == 0 || nums[0] != 0) {				//handle [1] -> 0
			return 0;
		}

		for(int i=1; i<nums.length; i++) {
			if(nums[i] - nums[i-1] != 1) {					//can't do nums[i+1] - nums[i], handle [0] case
				return i;	//OK: nums[i-1]+1;
			}
		}

		return nums.length;									//F: handle [0,1,2] case
	}

	public static void main(String[] args) {
		n268_Missing_Number obj = new n268_Missing_Number();
		System.out.println(obj.missingNumber(new int[] {3,0,1}));
		System.out.println(obj.missingNumber(new int[] {9,6,4,2,3,5,7,0,1}));
		System.out.println(obj.missingNumber(new int[] {0,1}));
		
		System.out.println(obj.missingNumber2(new int[] {3,0,1}));
		System.out.println(obj.missingNumber2(new int[] {9,6,4,2,3,5,7,0,1}));
		System.out.println(obj.missingNumber2(new int[] {0,1}));
	}
}
