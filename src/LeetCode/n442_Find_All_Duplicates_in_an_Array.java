package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
Find all the elements that appear twice in this array.
Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]
Output:
[2,3]
 */
public class n442_Find_All_Duplicates_in_an_Array {
	//O(nlogn)
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();

		Arrays.sort(nums);

		for(int i=1; i<nums.length; i++) {
			if(nums[i] == nums[i-1]) {
				res.add(nums[i]);

			}
		}

		return res;
	}

	//O(n) / O(1) //[LC287 - LC448 - LC442] 
	public List<Integer> findDuplicates3(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		
		int i=0;
		while(i < nums.length) {
			if(nums[i] <= nums.length && nums[i] != nums[nums[i]-1]) {
				swap(nums, i, nums[i]-1);
			} else {
				i++;
			}
		}
		
		for(int j=0; j<nums.length; j++) {
			if(nums[j] != j+1) {
				res.add(nums[j]);
			}
		}
		
		return res;
	}
	
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	//O(n)
	//https://leetcode.com/problems/find-all-duplicates-in-an-array/solution/ approach 4
	//for any integer x in the array, x-1 is a valid index, and thus, arr[x-1] is a valid reference to an element in the array.
	//  0, 1, 2, 3, 4, 5, 6, 7    1<=arr[i]<=n  
	//[ 4, 3, 2, 7, 8, 2, 3, 1]
	//[-4,-3,-2,-7, 8, 2,-3,-1]   after change
	public List<Integer> findDuplicates2(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		
		for(int i=0; i<nums.length; i++) {
			int idx = Math.abs(nums[i]);
			
			if(nums[idx-1] < 0) {
				res.add(idx);				//why can't add nums[i], cuz nums[i] already change to negative so need to use idx for orig nums[i] value
			} else {
				nums[idx-1] = -nums[idx-1];
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		n442_Find_All_Duplicates_in_an_Array obj = new n442_Find_All_Duplicates_in_an_Array();
		System.out.println(obj.findDuplicates(new int[] {4,3,2,7,8,2,3,1}));
		System.out.println(obj.findDuplicates2(new int[] {4,3,2,7,8,2,3,1}));
		System.out.println(obj.findDuplicates3(new int[] {4,3,2,7,8,2,3,1}));
	}
}
