package LeetCode;

import java.util.HashMap;

/*
Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:
0 <= i, j, k, l < n
nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0

Example 1:
Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
Output: 2
Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
Example 2:

Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
Output: 1
 */
public class n454_4Sum_II {
	//O(n^2) / O(n^2)
	public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		int res = 0;
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int n1 : nums1) {
			for(int n2 : nums2) {
				map.put(n1+n2, map.getOrDefault(n1+n2, 0)+1);
			}
		}
		
		//A+B+C+D = 0 ---> A+B = -(C+D)
		for(int n3 : nums3) {
			for(int n4 : nums4) {
				res = res + map.getOrDefault(-(n3+n4), 0);
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		n454_4Sum_II obj = new n454_4Sum_II();
		System.out.println(obj.fourSumCount(new int[] {1, 2}, new int[] {-2, -1}, new int[] {-1, 2}, new int[] {0, 2}));
	}
}
