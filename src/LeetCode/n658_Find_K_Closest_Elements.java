package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. 
The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:
|a - x| < |b - x|, or
|a - x| == |b - x| and a < b

Example 1:
Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]

Example 2:
Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]

Constraints:
1 <= k <= arr.length
1 <= arr.length <= 104
Absolute value of elements in the array and x will not exceed 104
 */
public class n658_Find_K_Closest_Elements {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> res = new ArrayList<Integer>();

		int left = 0;
		int right = arr.length-k;

		while(left < right) {
			int mid = left + (right-left)/2;

			if(x- arr[mid] > arr[mid+k]-x) {
				left = mid+1;
			} else {
				right = mid;
			}
		}

		for(int i=left; i<left+k; i++) {			//need to start with 'left' and left+k. (not start 0 and k only) 
			res.add(arr[i]);
		}

		return res;
	}

	public static void main(String[] args) {
		n658_Find_K_Closest_Elements obj = new n658_Find_K_Closest_Elements();
		System.out.println(obj.findClosestElements(new int[] {1, 2, 3, 4, 5}, 4, 3));
		System.out.println(obj.findClosestElements(new int[] {1, 2, 3, 4, 5}, 4, -1));
		System.out.println(obj.findClosestElements(new int[] {1, 1, 2, 2, 2, 2, 2, 3, 3}, 3, 1));
		System.out.println(obj.findClosestElements(new int[] {0, 0, 1, 2, 3, 3, 4, 7, 7, 8}, 3, 5));
	}
}
