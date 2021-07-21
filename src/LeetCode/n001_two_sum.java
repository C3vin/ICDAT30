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
	//Can't use Sorted & LR sol
	
	//Hash Table O(n) O(n)
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();		// [num, index]		
		int[] res = new int[2];
		
		for(int i=0; i<nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {		//first map is empty 
				res[0] = map.get(complement);
				res[1] = i;
			}
			map.put(nums[i], i);					//{2=0, 7=1, 11=2, 15=3}
		}
		
		return res;				//return null, cuz move res in here
	}

	//2pointer O(n) O)(1)
	//need sorted
	public int[] twoSum2(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;
		
		while(left < right) {
			int currentSum = nums[left]+nums[right];
			
			if(currentSum == target) {
				return new int[] {left, right};
			}
			
			if(currentSum < target) {
				left++;
			} else {
				right--;
			}
		}
		
		return new int[] {-1,-1};
	}
	
	public static void main(String[] args) {
		n001_two_sum obj = new n001_two_sum();
		System.out.println(Arrays.toString(obj.twoSum(new int[] {2,7,11,15}, 9)));	
		System.out.println(Arrays.toString(obj.twoSum2(new int[] {2,7,11,15}, 9)));	
	}
}
