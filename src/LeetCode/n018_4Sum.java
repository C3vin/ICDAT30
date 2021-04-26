package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? 
Find all unique quadruplets in the array which gives the sum of target.
Note:
The solution set must not contain duplicate quadruplets.

Example:
Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 */
public class n018_4Sum {
	//LC15 3Sum template [LC15-LC18]
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		Arrays.sort(nums);
		
		for(int i=0; i<nums.length-3; i++) {							//make sure we have 4 nums
			if(i == 0 || nums[i] != nums[i-1]) {						//remove duplicate also F: need i==0
				for(int j=i+1; j<nums.length; j++) {
					if(j == i+1 || nums[j] != nums[j-1]) {				//remove duplicate also F: need j==i+1
						int low = j+1;
						int high = nums.length-1;
						int sum = target - nums[i] - nums[j];			//i & j not low / height, target - (n[i] + n[j]) or target - n[i] - n[j] 
						
						while(low < high) {
							if(nums[low] + nums[high] == sum) {
								res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
								
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
								low++;
							} else {
								high--;
							}
						}
					}
				}
			}
		}
		
		return res;
	}

	public List<List<Integer>> fourSum2(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums == null || nums.length <4) return res;

		Arrays.sort(nums);

		for(int i=0; i<nums.length-3; i++) {
			if(i!=0 && nums[i] == nums[i-1])			//F:&&  and i-1
				continue;
			for(int j=i+1; j<nums.length-2; j++) {
				if(j!=i+1 && nums[j] == nums[j-1])		//F:&&	and j-1
					continue;
				int l = j+1;
				int r = nums.length-1;

				while(l<r) {			
					int sum = nums[i]+nums[j]+nums[l]+nums[r];
					if(sum < target) {					//F:do < and > and ==
						l++;
					} else if(sum > target){
						r--;
					}
					else {      //(sum == target) 
						List<Integer> tmp = new ArrayList<Integer>();
						tmp.add(nums[i]);
						tmp.add(nums[j]);
						tmp.add(nums[l]);
						tmp.add(nums[r]);
						res.add(tmp);
						l++;
						r--;

						while(l<r && nums[l] == nums[l-1]) 
							l++;
						while(l<r && nums[r] == nums[r+1])
							r--;
					}
				}   
			}
		}
		return res;
	}

	public static void main(String[] args) {
		n018_4Sum obj = new n018_4Sum();
		int[] nums = {1, 0, -1, 0, -2, 2};
		System.out.println(obj.fourSum(nums, 0));
		System.out.println(obj.fourSum2(nums, 0));
	}
}
