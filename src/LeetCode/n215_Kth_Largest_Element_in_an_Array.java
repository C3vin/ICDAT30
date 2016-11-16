package LeetCode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class n215_Kth_Largest_Element_in_an_Array {
	//sort
	public int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		
		return nums[nums.length-k];		
	}
	
	//Priority
	public int findKthLargestPriority(int[] nums, int k) {
		Queue<Integer> pq = new PriorityQueue<Integer>();
		for(int i=0; i<nums.length; i++) {
			pq.add(nums[i]);	//add and sort in the same time e.g. [2,3,5]
			if(pq.size() > k)	
				pq.poll();		//poll head, e.g. [3,5]
		}
		return pq.poll();
	}
	
	//Quick Sort https://segmentfault.com/a/1190000003704825
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
			}
		}
		if(orgL < right && k <= right)
			return quickSelect(nums, k, orgL, right);
		if(left < orgR && k >= left)
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
		//int[] nums = {-1, 2, 0};
		//System.out.println(obj.findKthLargest(nums, 2));
		//System.out.println(obj.findKthLargestqQS(nums, 2));
		System.out.println(obj.findKthLargestPriority(nums, 2));
	}
}
