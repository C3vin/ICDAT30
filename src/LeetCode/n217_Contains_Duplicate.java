package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
/*
Given an array of integers, find if the array contains any duplicates.
Your function should return true if any value appears at least twice in the array, 
and it should return false if every element is distinct.

Example 1:
Input: [1,2,3,1]
Output: true

Example 2:
Input: [1,2,3,4]
Output: false

Example 3:
Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
 */

public class n217_Contains_Duplicate {
	//HaseSet 21ms
	public boolean containsDuplicate(int[] nums) {
		if(nums == null || nums.length == 0)
			return false;

		HashSet<Integer> set = new HashSet<Integer>();

		for(int i=0; i<nums.length; i++) {
			if(set.contains(nums[i])) {
				return true;
			} else {
				set.add(nums[i]);
			}
		}
		return false;
	}
	
	//cs
	//time:O(n) space:O(n)
	public boolean containsDuplicate2(int[] nums) {
		if(nums == null || nums.length == 0) {
			return false;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0; i<nums.length; i++) {
			if(!set.add(nums[i])) {					//If this set already contains, the call leaves the set unchanged and returns false.
				return true;
			}
		}
		return false;
	}
	//cs
	//time:O(nlogn) space:O(1)
	public boolean containsDuplicate3(int[] nums) {
		Arrays.sort(nums);
		for(int i=1; i<nums.length; i++) {
			if(nums[i] == nums[i-1]) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		n217_Contains_Duplicate obj = new n217_Contains_Duplicate();
		int[] nums = {1,2,4,4};
		System.out.println(obj.containsDuplicate(nums));
		System.out.println(obj.containsDuplicate2(nums));
		System.out.println(obj.containsDuplicate3(nums));
	}
}
