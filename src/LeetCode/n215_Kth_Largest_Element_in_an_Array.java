package LeetCode;

import java.util.Arrays;

public class n215_Kth_Largest_Element_in_an_Array {
	public int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);

		return nums[nums.length-k];
	}

	public static void main(String[] args) {
		n215_Kth_Largest_Element_in_an_Array obj = new n215_Kth_Largest_Element_in_an_Array();
		int[] nums = {3, 2, 1, 5, 6, 4};
		System.out.println(obj.findKthLargest(nums, 2));
	}
}
