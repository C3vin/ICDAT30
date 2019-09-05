package LeetCode;

/*
Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:
Given nums = [1,1,1,2,2,3],
Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
It doesn't matter what you leave beyond the returned length.

Example 2:
Given nums = [0,0,1,1,1,1,2,3,3],
Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
It doesn't matter what values are set beyond the returned length.
 */
public class n080_Remove_Duplicates_from_Sorted_Array_II {
	//cs
	//time:O(n) space:O(1)
	public int removeDuplicates(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		if(nums.length <= 2) {
			return nums.length;
		}
		int count = 2;
		for(int i=2; i<nums.length; i++) {
			
			if(nums[i] != nums[count-2]) {
				nums[count] = nums[i];
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		n080_Remove_Duplicates_from_Sorted_Array_II obj = new n080_Remove_Duplicates_from_Sorted_Array_II();
		System.out.println(obj.removeDuplicates(new int[] {1,1,1,2,2,3}));
		System.out.println(obj.removeDuplicates(new int[] {0,0,1,1,1,1,2,3,3}));
	}
}
