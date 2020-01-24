package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
iven an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Note:
The solution set must not contain duplicate triplets.

Example:
Given array nums = [-1, 0, 1, 2, -1, -4],
A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
public class n015_3Sum {
	public List<List<Integer>> threeSum(int[] nums) {
		//https://leetcode.wang/leetCode-15-3Sum.html
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		
		for(int i=0; i<nums.length-2; i++) {			//make sure we have 3 nums
			if(i==0 || nums[i] != nums[i-1]) {			//remove duplicate also F: need i==0
				int low = i+1;							//start with next one, i+1, cuz sum will use 'i'
				int high = nums.length-1;
				int sum = 0 - nums[i];
				
				while(low < high) {
					if(nums[low] + nums[high] == sum) {
						res.add(Arrays.asList(nums[i], nums[low], nums[high]));
						
						//handle duplicate here
						while(low < high && nums[low] == nums[low+1]) {
							low++;
						}
						while(low < high && nums[high] == nums[high-1]) {
							high--;
						}
						
						low++;
						high--;
						
					} else if(nums[low] + nums[high] < sum) {
						low++;                 //why? cuz sort already
					} else {
						high--;
					}
				}
			}
		}
		return res;
	}

	public List<List<Integer>> threeSum2(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<nums.length; j++) {
				for(int k=j+1; k<nums.length; k++) {
					if(nums[i] + nums[j] + nums[k] == 0) {
						List<Integer> tmp = new ArrayList<Integer>();
						tmp.add(nums[i]);
						tmp.add(nums[j]);
						tmp.add(nums[k]);

						if(isInList(res, tmp)) {
							continue;
						}
						res.add(tmp);
					}
				}
			}
		}
		return res;
	}
	private boolean isInList(List<List<Integer>> res, List<Integer> tmp) {
		for(List<Integer> list : res) {
			Collections.sort(list);
			Collections.sort(tmp);

			if(list.equals(tmp)) {
				return true;
			}
		}
		return false;
	}

	
	public static void main(String[] args) {
		n015_3Sum obj = new n015_3Sum();
		int[] nums = {-1, 0, 1, 2, -1, -4};
		//int[] nums = {1,2,-2,-1};
		System.out.println(obj.threeSum(nums));
		System.out.println(obj.threeSum2(nums));
		
		System.out.println(obj.threeSum(new int[] {-2,0,1,1,2}));
		System.out.println(obj.threeSum2(new int[] {-2,0,1,1,2}));
	}
}
