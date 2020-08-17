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
	//LC45 - LC55 sol
	public int jump(int[] nums) {
		int steps = 0;
		int curMaxArea = 0;
		int maxPosition = 0;
		
		for(int i=0; i<nums.length-1; i++) {		//need length-1, why cuz index 0 will go into if loop and steps++, so need to -1
			
			maxPosition = Math.max(maxPosition, nums[i]+i); //nums[i]+i, start index i and can jump nums[i] value size
			
			if(i == curMaxArea) {
				curMaxArea = maxPosition;
				steps++;
			}
		}
		return steps;
	}
	//Greedy algorithm
	//https://www.hackerearth.com/practice/algorithms/greedy/basics-of-greedy-algorithms/tutorial/
	public static void main(String[] args) {
		n045_Jump_Game_II obj = new n045_Jump_Game_II();
		System.out.println(obj.jump(new int[] {2,3,1,1,4}));
	}
}
