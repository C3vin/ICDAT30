package LeetCode;

import java.util.Arrays;

public class n215_Kth_Largest_Element_in_an_Array {
	public int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);

		return nums[nums.length-k];
	}
	
	//Quick Sort
	public int findKthLargestqQS(int[] nums, int k) {
		if(nums.length == 0 || k < 1 ) return 0; 			//F: k < 1
		
		return quickSelect(nums, k-1, 0, nums.length-1);
	}
	private int quickSelect(int[] nums, int k, int left, int right) {
		int m = nums[(left+right)/2];
		int orgL = left;
		int orgR = right;
		
		while(left <= right) {
			while(nums[left] > m) {
				left++;
			}
			while(nums[right] < m) {
				right--;
			}
			if(left<=right) {
				swap(nums, left, right);
				left++;			//why left++ right--
				right--;
				System.out.println("left: " + left + " right: " + right);
			}
		}
		System.out.println(Arrays.toString(nums));
		if(orgL < right && k < right)
			return quickSelect(nums, k, orgL, right);
		if(left < orgR && k > left)
			return quickSelect(nums, k, left, orgR);
		return nums[k];
	}
	private void swap(int[] nums, int left, int right) {
		int tmp = nums[left];
		nums[left] = nums[right];
		nums[right] = tmp;
	}

	public static void main(String[] args) {
		n215_Kth_Largest_Element_in_an_Array obj = new n215_Kth_Largest_Element_in_an_Array();
		int[] nums = {3, 2, 1, 5, 6, 4};
		System.out.println(obj.findKthLargest(nums, 2));
		System.out.println(obj.findKthLargestqQS(nums, 2));
	}
}
