package LeetCode;

import java.util.Arrays;

/*
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. 
Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:
Given array nums = [-1, 2, 1, -4], and target = 1.
The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class n016_3Sum_Closest {
	//https://leetcode.wang/leetCode-16-3Sum-Closest.html
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int sum = 0;
		int sub = Integer.MAX_VALUE;				//LC15 int sum = 0 - nums[i]; a+b+c = 0 but LC16 need to update later
		
		for(int i=0; i<nums.length; i++) {
			int low = i+1;
			int high = nums.length-1;
			
			while(low < high) {
				if(Math.abs(nums[i] + nums[low] + nums[high] - target) < sub) {		//F: target
					sum = nums[i] + nums[low] + nums[high];			//update sum
					sub = Math.abs(sum - target);
					System.out.println(nums[i] +" : "+ nums[low] +" : "+ nums[high]+" : "+ "sum: "+sum + " sub: " + sub);
				}
					
				if(nums[i]+nums[low]+nums[high] < target) {
                    low++;
                } else {
                    high--;
                }
			}
		}
		return sum;
	}
	
	public int threeSumClosest2(int[] nums, int target) {
		int sum = 0;
		int sub = Integer.MAX_VALUE;
		
		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<nums.length; j++) {
				for(int k=j+1; k<nums.length; k++) {
					if(Math.abs(nums[i] + nums[j] + nums[k] - target) < sub) {
						sum = nums[i] + nums[j] + nums[k];
						sub = Math.abs(sum - target);
					}
				}
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		n016_3Sum_Closest obj = new n016_3Sum_Closest();
		System.out.println(obj.threeSumClosest(new int[] {-1,2,1,-4}, 1));
		//System.out.println(obj.threeSumClosest2(new int[] {-1,2,1,-4}, 1));
	}
}
