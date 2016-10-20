package LeetCode;

public class n004_Median_of_Two_Sorted_Arrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		int total = m+n;
		if (total%2 != 0)
			return (double) findKth(nums1, 0, m-1, nums2, 0, n-1, total/2+1);
		else {
			double x = findKth(nums1, 0, m-1, nums2, 0, n-1, total/2);
			double y = findKth(nums1, 0, m-1, nums2, 0, n-1, total/2+1);
			return (double)(x+y)/2;
		}
	}

	public static int findKth(int[] nums1, int astart, int aend, int[] nums2, int bstart, int bend, int k) {
		int m = aend - astart + 1;
		int n = bend - bstart + 1;

		//always assume that m is equal or smaller than n  
		if(m>n)
			return findKth(nums2,bstart,bend,nums1,astart,aend,k);
		if(m==0)
			return nums2[k-1];
		if(k==1)
			return Math.min(nums1[astart],nums2[bstart]);

		//divide k into two parts  
		int partA = Math.min(k/2,m);
		int partB = k - partA;
		if(nums1[astart+partA-1] < nums2[bstart+partB-1])
			return findKth(nums1,astart+partA,aend,nums2,bstart,bend,k-partA);
		else if(nums1[astart+partA-1] > nums2[bstart+partB-1])
			return findKth(nums1,astart,aend,nums2,bstart+partB,bend,k-partB);
		else
			return nums1[astart+partA-1];
	}
	public static void main(String[] args) {
		n004_Median_of_Two_Sorted_Arrays obj = new n004_Median_of_Two_Sorted_Arrays();
		int[] nums1 = {1,2};
		int[] nums2 = {3,4};
		System.out.println(obj.findMedianSortedArrays(nums1, nums2));
	}
}

//http://www.cnblogs.com/springfor/p/3861890.html