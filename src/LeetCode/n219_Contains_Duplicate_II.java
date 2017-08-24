package LeetCode;

import java.util.HashSet;

/*
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array 
 * such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 */
public class n219_Contains_Duplicate_II {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0; i<nums.length; i++) {
			if(set.contains(nums[i]))
				return true;
			set.add(nums[i]);
			if(set.size() > k) {			//why i-k, because set.size() > k, so i > k
				set.remove(nums[i-k]);		//because we just need to care windows size i -> j 
			}
		}
		return false;
	}
	public static void main(String[] args) {
		n219_Contains_Duplicate_II obj = new n219_Contains_Duplicate_II();
		int[] nums = {1,2,3,1,3};
		int[] nums2 = {1,0,2,1};
		System.out.println(obj.containsNearbyDuplicate(nums, 3));
		System.out.println(obj.containsNearbyDuplicate(nums2, 2));
	}
}
