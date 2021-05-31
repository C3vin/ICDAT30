package LeetCode;

/*
You are given an integer array nums where the largest integer is unique.
Determine whether the largest element in the array is at least twice as much as every other number in the array. If it is, return the index of the largest element, or return -1 otherwise.

Example 1:
Input: nums = [3,6,1,0]
Output: 1
Explanation: 6 is the largest integer.
For every other number in the array x, 6 is at least twice as big as x.
The index of value 6 is 1, so we return 1.
Example 2:
Input: nums = [1,2,3,4]
Output: -1
Explanation: 4 is less than twice the value of 3, so we return -1.
Example 3:
Input: nums = [1]
Output: 0
Explanation: 1 is trivially at least twice the value as any other number because there are no other numbers.
 */
public class n747_Largest_Number_At_Least_Twice_of_Others {
	public int dominantIndex(int[] nums) {
		int res = 0;
		
		int max = 0;
		for(int n : nums) {
			max = Math.max(max, n);
		}

		for(int i=0; i<nums.length; i++) {
			if(nums[i] == max) {
				res = i;
				continue;
			}
			
			int tmp = nums[i] * 2;
			
			if(tmp > max) {
				return -1;
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		n747_Largest_Number_At_Least_Twice_of_Others obj = new n747_Largest_Number_At_Least_Twice_of_Others();
		System.out.println(obj.dominantIndex(new int[] {3,6,1,0}));
		System.out.println(obj.dominantIndex(new int[] {1,2,3,4}));
		System.out.println(obj.dominantIndex(new int[] {1}));
	}
}
