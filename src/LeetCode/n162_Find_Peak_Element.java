package LeetCode;

/*
A peak element is an element that is strictly greater than its neighbors.
Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

Example 1:
Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.

Example 2:
Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
 */
public class n162_Find_Peak_Element {
	public int findPeakElement(int[] nums) {
		int left = 0;
		int right = nums.length-1;
		
		while(left < right) {
			int mid = left + (right-left)/2;
			
			if(nums[mid] > nums[mid+1]) {
				right = mid;
			} else {
				left = mid+1;
			}
		}
		
		return right;
	}
	
	public static void main(String[] args) {
		n162_Find_Peak_Element obj = new n162_Find_Peak_Element();
		System.out.println(obj.findPeakElement(new int[] {1,2,3,1}));
		System.out.println(obj.findPeakElement(new int[] {1,2,1,3,5,6,4}));
	}
}
