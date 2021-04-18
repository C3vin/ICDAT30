package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] 
that do not appear in nums.

Example 1:
Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

Example 2:
Input: nums = [1,1]
Output: [2]
Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
 */
public class n448_Find_All_Numbers_Disappeared_in_an_Array {
	//O(n) / O(1) Ignoring the space required for the output array, the algorithm runs in constant space O(1)O(1).
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();

		int i = 0;
		while(i < nums.length) {
			if(nums[i] <= nums.length && nums[i] != nums[nums[i]-1]) {	//nums[i] <= nums.length, <= not < (diff with LC268 Missing Number [0, n]
				swap(nums, i, nums[i]-1);
			} else {
				i++;
			}
		}

//		for(int n : nums)
//			System.out.print(n);

		for(i=0; i<nums.length; i++){
			if(i+1 != nums[i]) {
				res.add(i+1);			//this is important! 
			}            
		}

		return res;
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
