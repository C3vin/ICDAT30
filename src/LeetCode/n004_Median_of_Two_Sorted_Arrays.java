package LeetCode;

/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
You may assume nums1 and nums2 cannot be both empty.

Example 1:
nums1 = [1, 3]
nums2 = [2]
The median is 2.0

Example 2:
nums1 = [1, 2]
nums2 = [3, 4]
The median is (2 + 3)/2 = 2.5
 */
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
	
	//https://www.youtube.com/watch?v=LPFhl65R7ww
	/*    
	 *    1  3   8   9   15
	 * =========================
	 *   |  |  |   |   |   |   |
	 *   0  1  2   3   4   5   6  (partition)
	 * =========================
	 *    7  11  18  19  21  25
	 */
	public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		if(nums1.length > nums2.length ) {
			return findMedianSortedArrays2(nums2, nums1);
		}
		
		int x = nums1.length;
		int y = nums2.length;
		int start = 0;
		int end = x;
		
		//partitionX + partitionY = (x+y+1) / 2 //L:R or L+1:R
		while(start <= end) {
			int partitionX = (start+end)/2;
			int partitionY = (x+y+1)/2 - partitionX;		
			
			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];  	
			int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];
			
			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
			int minRightY = (partitionY == x) ? Integer.MAX_VALUE : nums2[partitionY];
			
			if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
				if((x+y)%2 == 0) {
					return (double)(Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
				} else {
					return (double)Math.max(maxLeftX, maxLeftY);
				}
			} else if(maxLeftX > minRightY) {
				end = partitionX - 1;
			} else {
				start = partitionX + 1;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		n004_Median_of_Two_Sorted_Arrays obj = new n004_Median_of_Two_Sorted_Arrays();
		int[] nums1 = {1,2};
		int[] nums2 = {3,4};
		System.out.println(obj.findMedianSortedArrays(nums1, nums2));
		System.out.println(obj.findMedianSortedArrays2(nums1, nums2));
		System.out.println(obj.findMedianSortedArrays(new int[] {1,3,8,9,15}, new int[] {7,11,19,21,18,25}));
		System.out.println(obj.findMedianSortedArrays2(new int[] {1,3,8,9,15}, new int[] {7,11,19,21,18,25}));
	}
}

//http://www.cnblogs.com/springfor/p/3861890.html