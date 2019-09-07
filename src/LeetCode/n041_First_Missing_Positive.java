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
	//[0,1,2,3]
	//[1,2,-1,4]  => 3
	
	//[0,1,2,3]
	//[3,4,-1,1]
	//[1,-1,3,4] => 2
	public int firstMissingPositive(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 1;
		}
		for(int i=0; i<nums.length; i++) {
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
		return nums.length + 1;
	} 
	
	public static void main(String[] args) {
		n041_First_Missing_Positive obj = new n041_First_Missing_Positive();
		System.out.println(obj.firstMissingPositive(new int[] {1,2,0}));
	}
}
