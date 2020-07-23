package LeetCode;

/*
Given an unsorted integer array, find the smallest missing positive integer.
Example 1:
Input: [1,2,0]
Output: 3

Example 2:
Input: [3,4,-1,1]
Output: 2

Example 3:
Input: [7,8,9,11,12]
Output: 1
Note: Your algorithm should run in O(n) time and uses constant extra space.
 */
public class n041_First_Missing_Positive {
	public int firstMissingPositive(int[] nums) {
		//https://leetcode.wang/leetCode-41-First-Missing-Positive.html
		//Constant space means all your data structures must have size that's O(1) !!! (Request!)
		
		if(nums == null || nums.length == 0) {
			return 1;
		}
		
		for(int i=0; i<nums.length; i++) {
			//while not if, cuz need to keep check even after swap
			//about the nums[nums[i] - 1] != nums[i]. 
			//index: 0 1 2 3          n[i]          n[1] = 2
			//value: 1 2 3 4          n[n[i] - 1]   n[n[1] - 1] = n[2 - 1] = n[1] = 2
			while(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
				int tmp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = tmp;
			}
		}
		for(int i=0; i<nums.length; i++) {
			if(nums[i] != i+1) {
				return i+1;
			}
		}
		return nums.length + 1;		//handle last element case
	} 

	public static void main(String[] args) {
		n041_First_Missing_Positive obj = new n041_First_Missing_Positive();
		System.out.println(obj.firstMissingPositive(new int[] {1,2,0}));
		System.out.println(obj.firstMissingPositive(new int[] {3,4,-1,1}));
	}
}
