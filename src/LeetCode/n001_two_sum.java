package LeetCode;

import java.util.Arrays;

public class n001_two_sum {
	public int[] twoSum(int[] nums, int target) {
		for (int i=0; i<nums.length; i++) {
			for (int j=i+1; j<nums.length-1; j++) {
				if (nums[j] == target - nums[i]) {			//==
					System.out.println("Found it!");
					 return new int[] { i, j };
				}
			}
		}
		 throw new IllegalArgumentException("No two sum solution");
	}
	
	public static void main(String[] arg) {
		n001_two_sum obj = new n001_two_sum();
		int [] nums = {2, 7, 11, 15};
		int target = 9;
		int [] res = obj.twoSum(nums, target);
		
		System.out.println(Arrays.toString(res));			//Arrays.toString: http://stackoverflow.com/questions/409784/whats-the-simplest-way-to-print-a-java-array
	}
}
