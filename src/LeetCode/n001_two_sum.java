package LeetCode;

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class n001_two_sum {

	//LR 
	public int[] twoSum(int[] nums, int target) {
		int[] res = new int[2];
		if(nums == null || nums.length < 2) return null;
		Arrays.sort(nums);  		//Order
		int l=0;
		int r=nums.length-1;
		while(l<r) {
			if(nums[l] + nums[r] == target) {
				res[0]=l;
				res[1]=r;
				return res;
			}
			else if(nums[l] + nums[r] > target) {
				r--;
			} else {
				l++;
			}
		}
		return null;
	}
	
	//Hash Table
	public int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer> ();
		int[] res = new int[2];
		
		for (int i=0; i<nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {		//first map is empty 
				res[0] = map.get(complement);
				res[1] = i;
				//return res;
 				//return new int[] {map.get(complement), i};
			}
			map.put(nums[i], i);
		}
		return res;				//return null, cuz move res in here
	}

	public static void main(String[] args) {
		n001_two_sum obj = new n001_two_sum();

		System.out.println(Arrays.toString(obj.twoSum(new int[] {2,7,11,15}, 9)));		//The reason order int array
		System.out.println(Arrays.toString(obj.twoSum2(new int[] {2,7,11,15}, 9)));	
	}
}
