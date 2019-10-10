package LeetCode;

import java.util.HashSet;

/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
Your algorithm should run in O(n) complexity.

Example:
Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class n128_Longest_Consecutive_Sequence {
	//cs time:O(n) space:O(n)
	public int longestConsecutive(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		int res = 0;
		
		for(int num : nums) {
			set.add(num);
		}
		
		for(int i=0; i<nums.length; i++) {
			int down = nums[i]-1;
			while(set.contains(down)) {
				set.remove(down);
				down--;
			}
			System.out.println(set);
			
			int up = nums[i]+1;
			while(set.contains(up)) {
				set.remove(up);
				up++;
			}
			System.out.println(set);
			
			res = Math.max(res, up - down -1);
		}
		return res;
	}
	public static void main(String[] args) {
		n128_Longest_Consecutive_Sequence obj = new n128_Longest_Consecutive_Sequence();
		System.out.println(obj.longestConsecutive(new int[] {100,4,200,1,3,2}));
	}
}
