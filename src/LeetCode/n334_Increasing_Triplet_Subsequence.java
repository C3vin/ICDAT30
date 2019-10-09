package LeetCode;

/*
Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
Formally the function should:
Return true if there exists i, j, k
such that arr[i] < arr[j] < arr[k] given 0 <= i < j < k <= n-1 else return false.
Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.

Example 1:
Input: [1,2,3,4,5]
Output: true

Example 2:
Input: [5,4,3,2,1]
Output: false
 */
public class n334_Increasing_Triplet_Subsequence {
	//cs: time:O(n) space:O(1)
	public boolean increasingTriplet(int[] nums) {
		int min = Integer.MAX_VALUE;
		int sedMin = Integer.MAX_VALUE;
		
		for(int num : nums) {
			if(num <= min) {
				min = num;
			} else if(num < sedMin) {
				sedMin = num;
			} else if(num > sedMin) {
				return true;
			}
		}
		return false;
		
	}
	public static void main(String[] args) {
		n334_Increasing_Triplet_Subsequence obj = new n334_Increasing_Triplet_Subsequence();
		System.out.println(obj.increasingTriplet(new int[] {1,2,3,4,5}));
		System.out.println(obj.increasingTriplet(new int[] {5,4,3,2,1}));
	}
}
