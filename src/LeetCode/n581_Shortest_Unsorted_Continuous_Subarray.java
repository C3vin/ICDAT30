package LeetCode;

/*
Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.

Return the shortest such subarray and output its length.

Example 1:

Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Example 2:

Input: nums = [1,2,3,4]
Output: 0
Example 3:

Input: nums = [1]
Output: 0
 */
//also https://www.geeksforgeeks.org/minimum-length-unsorted-subarray-sorting-which-makes-the-complete-array-sorted/
public class n581_Shortest_Unsorted_Continuous_Subarray {
	//good, two pointer WK
	public int findUnsortedSubarray2(int[] nums) {
		int left = nums.length-1;
		int right = 0;

		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<nums.length; j++) {
				if(nums[j] < nums[i]) {
					left = Math.min(left, i);
					right = Math.max(right, j);
				}
			}
		}

		if(left == nums.length-1) {
			return 0;
		}

		int res = right - left + 1;

		return res;
	}

	//two pointer 
	public int findUnsortedSubarray(int[] nums) {
		int res = 0;
		if(nums.length == 0 ) {
			return res;
		}
		int[] rr = new int[2];						//this is for WK Q2

		int l = nums.length;
		int r = 0;

		for(int i=0; i<nums.length-1; i++) {		//need length-1 !!!
			for(int j=i+1; j<nums.length; j++) {
				if(nums[i] > nums[j]) {
					//update l & r
					l = Math.min(l, i);
					r = Math.max(r, j);
				}
			}
		}

		System.out.println(l + " : " + r);

		if(l == nums.length) {						//handle [1,2,3,4] 
			return 0;
		}

		//res = r - l < 0 ? 0 : r - l + 1;			 
		res = r - l + 1; 							//AC ? 

		rr[0] = l;
		rr[1] = r;

		//System.out.println(rr[0] + " : " + rr[1]);

		return res;
	}

	//WK told me this solution 
	//https://www.geeksforgeeks.org/minimum-length-unsorted-subarray-sorting-which-makes-the-complete-array-sorted/
	//But I don't like the solution

	public static void main(String[] args) {
		n581_Shortest_Unsorted_Continuous_Subarray obj = new n581_Shortest_Unsorted_Continuous_Subarray();
		System.out.println(obj.findUnsortedSubarray(new int[] {2,6,4,8,10,9,15}));
		//		System.out.println(obj.findUnsortedSubarray(new int[] {1,2,3,4}));
		//		System.out.println(obj.findUnsortedSubarray(new int[] {2,1}));
		//		System.out.println(obj.findUnsortedSubarray(new int[] {1,3,5,2,6,4,7,8,9}));
		//		System.out.println(obj.findUnsortedSubarray(new int[] {1,2,4,5,3,5,6,7}));
		//		System.out.println(obj.findUnsortedSubarray(new int[] {}));

		//		System.out.println(obj.findUnsortedSubarray2(new int[] {2,6,4,8,10,9,15}));
		//		System.out.println(obj.findUnsortedSubarray2(new int[] {1,2,3,4}));
		//		System.out.println(obj.findUnsortedSubarray2(new int[] {2,1}));
		//		System.out.println(obj.findUnsortedSubarray2(new int[] {1,3,5,2,6,4,7,8,9}));
		//		System.out.println(obj.findUnsortedSubarray2(new int[] {1,2,4,5,3,5,6,7}));
		//		System.out.println(obj.findUnsortedSubarray2(new int[] {}));
	}
}
