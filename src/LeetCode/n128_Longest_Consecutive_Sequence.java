package LeetCode;

import java.util.Arrays;
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
	//O(n)
	public int longestConsecutive(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		for(int num : nums) {
			set.add(num);
		}

		int max = 0;

		for(int i=0; i<nums.length; i++) {
			int num = nums[i];				//need to get first!!!

			if(!set.contains(num -1)) {		//will block until it find the smallest, e.g 987654, only 4 will go into while loop
				int count = 0;

				while(set.contains(num)) {
					count++;

					num = num + 1;  		//from smallest to large
				}

				max = Math.max(max, count);
			}
		}

		return max;
	}

	//O(nlogn)
	public int longestConsecutive2(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		Arrays.sort(nums);

		int maxCount = 1;
		int count = 1;

		for(int i=1; i<nums.length; i++) {
			if(nums[i] != nums[i-1]) {					//to ignore duplicate element e.g second '0'
				if(nums[i] - nums[i-1] == 1) {
					count++;
				} else {
					maxCount = Math.max(maxCount, count);
					count = 1;							//reset count to default
				}
			} 
		}


		return Math.max(maxCount, count);
	}

	public static void main(String[] args) {
		n128_Longest_Consecutive_Sequence obj = new n128_Longest_Consecutive_Sequence();
		System.out.println(obj.longestConsecutive(new int[] {100,4,200,1,3,2}));
		System.out.println(obj.longestConsecutive2(new int[] {100,4,200,1,3,2}));
		System.out.println(obj.longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1}));
		System.out.println(obj.longestConsecutive2(new int[] {0,3,7,2,5,8,4,6,0,1}));
	}
}
