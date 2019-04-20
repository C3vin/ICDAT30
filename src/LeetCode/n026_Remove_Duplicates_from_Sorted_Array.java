package LeetCode;

import java.util.Arrays;

//Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
//Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
//Given nums = [1,1,2],
//Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
//It doesn't matter what you leave beyond the new length.

public class n026_Remove_Duplicates_from_Sorted_Array {
	public int removeDuplicates(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		if(nums.length < 2) return nums.length;

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

	//better to understand
	public int removeDuplicates1(int[] nums) {
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
	public static void main(String[] args) {
		n026_Remove_Duplicates_from_Sorted_Array obj = new n026_Remove_Duplicates_from_Sorted_Array();
		int[] nums = {1,1,1,2,2};
		System.out.println(obj.removeDuplicates((nums)));

		int[] nums1 = {1,1,1,2,2};
		System.out.println(obj.removeDuplicates1((nums1)));
	}
}
