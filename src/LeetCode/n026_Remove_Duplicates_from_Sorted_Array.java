package LeetCode;

import java.util.Arrays;

/*
Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:
Given nums = [1,1,2],
Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
It doesn't matter what you leave beyond the returned length.

Example 2:
Given nums = [0,0,1,1,1,2,2,3,3,4],
Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
It doesn't matter what values are set beyond the returned length.
*/

public class n026_Remove_Duplicates_from_Sorted_Array {
	//cs   [LC26 - LC27 template]
	//time:O(n) space:O(1)
	public int removeDuplicates1(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int count = 1;      //why 1, cuz it is sorted array, so we count the 1th and compare with 2th

		for(int i=1; i<nums.length; i++) {		//i=1, cuz need to compare i and i-1
			if(nums[i] != nums[i-1]) {
				nums[count] = nums[i];
				count++;
			}
		}
		
		System.out.println(Arrays.toString(nums));
		return count;
	}
	
	public int removeDuplicates(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		//if(nums.length < 2) return nums.length;

		int count = 0;
		for(int i=1; i < nums.length; i++) {
			if(nums[i] != nums[count]){
				//if(count != i) 
				nums[++count] = nums[i];
				//count++;
			}

		}
		System.out.println(Arrays.toString(nums));

		return count + 1;
	}

	public static void main(String[] args) {
		n026_Remove_Duplicates_from_Sorted_Array obj = new n026_Remove_Duplicates_from_Sorted_Array();
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		System.out.println(obj.removeDuplicates((nums)));

		int[] nums1 = {0,0,1,1,1,2,2,3,3,4};
		System.out.println(obj.removeDuplicates1((nums1)));
	}
}
