package LeetCode;

/*
Given a binary array, find the maximum number of consecutive 1s in this array.
Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
The maximum number of consecutive 1s is 3.
 */
public class n485_Max_Consecutive_Ones {
	public int findMaxConsecutiveOnes(int[] nums) {
		int res = 0;
		int count = 0;

		for(int i=0; i<nums.length; i++) {
			if(nums[i] == 1) {
				count++;
			} else {
				res = Math.max(res, count);
				count = 0;
			}
		}

		return Math.max(res, count);
	}
	
	public static void main(String[] args) {
		n485_Max_Consecutive_Ones obj = new n485_Max_Consecutive_Ones();
		System.out.println(obj.findMaxConsecutiveOnes(new int[] {1,1,0,1,1,1}));
	}
}
