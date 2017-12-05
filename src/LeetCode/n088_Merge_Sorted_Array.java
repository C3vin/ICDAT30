package LeetCode;

//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
//You may assume that nums1 has enough space (size that is greater or equal to m + n) 
//to hold additional elements from nums2. The number of elements initialized 
//in nums1 and nums2 are m and n respectively.

public class n088_Merge_Sorted_Array {
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
			System.out.println(nums1[i]);
	}
	
	public static void main(String[] args) {
		n088_Merge_Sorted_Array obj = new n088_Merge_Sorted_Array();
		
		int[] nums1 = {1,3,5,0,0,0,0};
		int[] nums2 = {2,4,6,7};
		obj.merge(nums1, 3, nums2, 4);
	}
}
