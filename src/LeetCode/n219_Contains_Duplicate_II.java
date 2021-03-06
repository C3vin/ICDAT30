package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
/*
Given an integer array nums and an integer k, return true if there are two distinct indices i and j 
in the array such that nums[i] == nums[j] and abs(i - j) <= k.

Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:
Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 */
public class n219_Contains_Duplicate_II {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i=0; i<nums.length; i++) {
			if(set.contains(nums[i])) {
				return true;
			}
			
			set.add(nums[i]);
			
			if(set.size() > k) {			//why i-k, because set.size() > k, so i > k
				set.remove(nums[i-k]);		//because we just need to care within the windows size i -> j 
			}
		}
		
		return false;
	}

	//cs
	//time:O(n) space:O(n) Good !!!
	public boolean containsNearbyDuplicate2(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i<nums.length; i++) {
			if(map.containsKey(nums[i])) {
				if(i - map.get(nums[i]) <= k) {
					return true;
				}
			} //else {                      //can't use this cuz need to put all the possible index
			
			map.put(nums[i], i);            //keep update the currnt i index, handle case e.g [1,0,1,1] k=1
			//}
		}
		
		return false;
	}
	
	public boolean containsNearbyDuplicate3(int[] nums, int k) {
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i=0; i<nums.length; i++) {
			if(set.contains(nums[i])) {
				return true;
			}
			
			set.add(nums[i]);
			
			if(set.size() > k) {
				set.remove(nums[i-k]);
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

		System.out.println(obj.containsNearbyDuplicate2(new int[] {1,2,1}, 2));
		System.out.println(obj.containsNearbyDuplicate2(nums, 3));
		System.out.println(obj.containsNearbyDuplicate2(nums2, 2));
		
		System.out.println(obj.containsNearbyDuplicate3(new int[] {1,2,3,1}, 2));
	}
}
