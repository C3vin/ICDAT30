package LeetCode;
/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.

Example:
Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3
Output: [1,2,2,3,5,6]
 */

import java.util.Arrays;

public class n088_Merge_Sorted_Array {
	//Good! 
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		for(int i=m+n-1; i>=0; i--) {
			if(m>0 && n>0) {
				if(nums2[n-1] > nums1[m-1]) {
					nums1[i] = nums2[n-1];
					n--;
				} else {
					nums1[i] = nums1[m-1];
					m--;
				}
			} else if(m>0) {
				nums1[i] = nums1[m-1];
				m--;
			} else if(n>0) {
				nums1[i] = nums2[n-1];
				n--;
			}
		}
		for(int i=0; i<nums1.length; i++)
			System.out.print(nums1[i]);
		System.out.println("");
	}

	//merge and sort! 
	public void merge3(int[] nums1, int m, int[] nums2, int n) {
		for(int i=0; i<n; i++) {
			nums1[i+m] = nums2[i];
		}

		Arrays.sort(nums1);

		for(int i=0; i<nums1.length; i++)
			System.out.print(nums1[i]);
		System.out.println("");
	}

	public void merge2(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;							//m: number of the value e.g. m=3, [1,2,3]
		int j = n - 1;
		int k = m + n - 1;

		while(j >= 0) {
			if(i < 0) {							//handle special case, e.g. {0}, 0, {1}, 1			
				while(j >= 0) {
					nums1[k] = nums2[j];
					k--;
					j--;
				}
			} else {
				if(nums1[i] > nums2[j]) {
					nums1[k] = nums1[i];
					k--;
					i--;
				} else {
					nums1[k] = nums2[j];
					k--;
					j--;
				}
			}
		}

		for(int s=0; s<nums1.length; s++)
			System.out.print(nums1[s]);
		System.out.println("");
	}



	public static void main(String[] args) {
		n088_Merge_Sorted_Array obj = new n088_Merge_Sorted_Array();

		obj.merge(new int[] {1,2,3,0,0,0}, 3, new int[] {2,5,6}, 3);
		obj.merge(new int[] {0}, 0, new int[] {1}, 1);

		obj.merge2(new int[] {1,2,3,0,0,0}, 3, new int[] {2,5,6}, 3);
		obj.merge2(new int[] {0}, 0, new int[] {1}, 1);

		obj.merge3(new int[] {1,2,3,0,0,0}, 3, new int[] {2,5,6}, 3);
		obj.merge3(new int[] {0}, 0, new int[] {1}, 1);
	}
}
