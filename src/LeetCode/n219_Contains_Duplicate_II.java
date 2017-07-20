package LeetCode;

import java.util.HashMap;

/*
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array 
 * such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 */
public class n219_Contains_Duplicate_II {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if(nums == null || nums.length == 0)
			return false;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<nums.length; i++) {
			if(map.containsKey(nums[i])) {
				int j = map.get(nums[i]);
				System.out.println(i + " : " + j);
				if(i-j <= k)
					return true;				//?
			} else
				map.put(nums[i], i);		
		}
		return false;
	}
	public static void main(String[] args) {
		n219_Contains_Duplicate_II obj = new n219_Contains_Duplicate_II();
		int[] nums = {1,2,3,1,3};
		System.out.println(obj.containsNearbyDuplicate(nums, 3));
	}
}
