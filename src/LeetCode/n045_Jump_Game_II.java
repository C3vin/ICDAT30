package LeetCode;

/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.

Example:
Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2 moves.
Jump 1 step from index 0 to 1, then 3 steps to the last index.
Note:
You can assume that you can always reach the last index.
 */
public class n045_Jump_Game_II {
	//cs
	//time:O(n) space:O(1)
	public int jump(int[] nums) {
		int res = 0;
		int curMaxArea = 0;
		int maxNext = 0;
		//Greedy alg
		for(int i=0; i<nums.length-1; i++) {		//need length-1
			maxNext = Math.max(maxNext, nums[i]+i);
			System.out.println("i: "+i+" maxNext: "+maxNext);
			if(i == curMaxArea) {
				res++;
				curMaxArea = maxNext;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		n045_Jump_Game_II obj = new n045_Jump_Game_II();
		System.out.println(obj.jump(new int[] {2,3,1,1,4}));
	}
}
