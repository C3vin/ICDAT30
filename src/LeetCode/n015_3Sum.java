package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class n015_3Sum {
	public List<List<Integer>> threeSum(int[] nums) {			//Return List<List<Integer>>
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums == null || nums.length<3) 
			return result;

		Arrays.sort(nums);

		for(int i=0; i<nums.length-2; i++) {		//Make sure we have 3 nums
			if(i==0 || nums[i] != nums[i-1]) {		//remove duplicate also F: need i==0
				int j=i+1;					// Next one, i+1
				int k=nums.length-1;

				while(j<k){					// F: Need it!!!!!!
					int sum = nums[i]+nums[j]+nums[k];
					if(sum==0) {
						List<Integer> tmp = new ArrayList<Integer>();	//F: need in while loop
						tmp.add(nums[i]);
						tmp.add(nums[j]);
						tmp.add(nums[k]);
						result.add(tmp);

						j++;
						k--;
						//handle duplicate here
						while(j<k && nums[j]==nums[j-1])
							j++;
						while(j<k && nums[k]==nums[k+1])
							k--;
					}else if(nums[i]+nums[j]+nums[k]<0) {
						j++;
					}else {
						k--;
					}
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		n015_3Sum obj = new n015_3Sum();
		//int[] nums = {-1, 0, 1, 2, -1, -4};
		int[] nums = {1,2,-2,-1};
		System.out.println(obj.threeSum(nums));
	}
}
