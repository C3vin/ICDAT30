package LeetCode;

/*
Given an array of integers arr, return true if and only if it is a valid mountain array.
Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Example 1:
Input: arr = [2,1]
Output: false

Example 2:
Input: arr = [3,5,5]
Output: false

Example 3:
Input: arr = [0,3,2,1]
Output: true

Constraints:
1 <= arr.length <= 104
0 <= arr[i] <= 104
 */
public class n941_Valid_Mountain_Array {
	public boolean validMountainArray(int[] arr) {
		if(arr == null || arr.length < 3) {
			return false;
		}

		boolean increasing = arr[1] > arr[0];

		if(!increasing) {
			return false;
		}

		for(int i=1; i<arr.length; i++) {
			if(arr[i] == arr[i-1]) {		//plateaus are prohibited e.g. [6,7,7,8,6]
				return false;
			}
			
			if(increasing) {
				if(arr[i] < arr[i-1]) {		//reached the peak
					increasing = false;
				} 
			} else {
				// every element must be decreasing, otherwise return false e.g. [0,1,2,1,2]
				if(arr[i] > arr[i-1]) {
					return false;
				}
			}
		}

		return !increasing; 		//make sure the peak was reached, e.g. [0,1,2,3,4,5,6]
	}

	//two pointers l & r
	public boolean validMountainArray2(int[] arr) {
		if(arr == null || arr.length < 3) {
			return false;
		}

		int l = 0;
		int r = arr.length-1;

		while(l+1 < arr.length && arr[l+1] > arr[l]) {
			l++;
		}
		while(r-1 >= 0 && arr[r] < arr[r-1]) {
			r--;
		}

		return l == r && l != 0 && r != arr.length-1;
	}

	public static void main(String[] args) {
		n941_Valid_Mountain_Array obj = new n941_Valid_Mountain_Array();
		System.out.println(obj.validMountainArray(new int[] {2,1}));
		System.out.println(obj.validMountainArray(new int[] {3,5,5}));
		System.out.println(obj.validMountainArray(new int[] {0,3,2,1}));
		System.out.println(obj.validMountainArray(new int[] {0,1,2,3,4,5,6}));

		System.out.println(obj.validMountainArray2(new int[] {2,1}));
		System.out.println(obj.validMountainArray2(new int[] {3,5,5}));
		System.out.println(obj.validMountainArray2(new int[] {0,3,2,1}));
		System.out.println(obj.validMountainArray2(new int[] {0,1,2,3,4,5,6}));
	}
}
