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
    }
}
