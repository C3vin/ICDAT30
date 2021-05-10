package LeetCode;

import java.util.Arrays;

/*
Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

Example 1:

Input: nums = [1,2,3]
Output: 6
Example 2:

Input: nums = [1,2,3,4]
Output: 24
Example 3:

Input: nums = [-1,-2,-3]
Output: -6

Constraints:

3 <= nums.length <= 104
-1000 <= nums[i] <= 1000
 */
public class n628_Maximum_Product_of_Three_Numbers {
	
	//O(nlogn) / O(logn)
	public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        
        int a = nums[0] * nums[1] * nums[nums.length-1];
        int b = nums[nums.length-1] * nums[nums.length-2] * nums[nums.length-3];
        
        return Math.max(a, b);
    }
	
	//O(n) / O(1)
	public int maximumProduct2(int[] nums) {
		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		int max3 = Integer.MIN_VALUE;
		
		for(int n : nums) {
			if(n <= min1) {
				min2 = min1; 
				
				min1 = n;		//update
			} else if( n <= min2) {
				min2 = n;		//update
			}
			
			if(n >= max1) {
				max3 = max2;
				max2 = max1; 
				
				max1 = n;		//update
			} else if(n >= max2) {
				max3 = max2; 
				
				max2 = n;		//update
			} else if(n >= max3) {
				max3 = n;		//update
			}
		}
		
		return Math.max(min1*min2*max1, max1*max2*max3);
	}
	
	public static void main(String[] args) {
		n628_Maximum_Product_of_Three_Numbers obj = new n628_Maximum_Product_of_Three_Numbers();
		System.out.println(obj.maximumProduct(new int[] {1,2,3}));
		
		System.out.println(obj.maximumProduct2(new int[] {1,2,3}));
		
	}
}
