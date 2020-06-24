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

		for(int i=0; i<nums.length-2; i++) {			//make sure we have 3 nums, i / i+1 / nums.ength-1
			//remove duplicate also F: need i==0 (for the first element)
			//nums[i-1] not nums[i+1] cuz low = i+1, if check nums[i+1] will miss (-1,-1,2) 
			if(i == 0 || nums[i] != nums[i-1]) {		
				int left = i+1;							//i+1
				int right = nums.length-1;				//nums.ength-1
				int sum = 0 - nums[i];					//i

				while(left < right) {
					if(nums[left] + nums[right] == sum) {
						res.add(Arrays.asList(nums[i], nums[left], nums[right]));

						//handle duplicate case e.g. -4,-1,-1,-1,1,2 (-1,-1,2) so no need another (-1,-1,2) 
						while(left < right && nums[left] == nums[left+1]) {			
							left++;
						}
						while(left < right && nums[right] == nums[right-1]) {
							right--;
						}
						//MOST add these two, for the normal case
						left++;					//e.g. (2:5), (3:4)
						right--;

					} else if(nums[left] + nums[right] < sum) {	//e.g. -1+2 < 4 
						left++;                  //why? cuz sort already and still need to check rest of the elements
					} else {
						right--;					//e.g. 1+2 > 0
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
