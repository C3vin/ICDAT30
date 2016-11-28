package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Given nums1 = [1,2,2,1,3,4,5,5,6], nums2 = [2, 2, 6], return [2, 6].
public class n349_Intersection_of_Two_Arrays {
	//sol1: HashSet
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> s1 = new HashSet<Integer>();
		for(int i : nums1) {
			s1.add(i);
		}
		Set<Integer> s2 = new HashSet<Integer>();
		for(int j : nums2) {
			if(s1.contains(j))
				s2.add(j);
		}

		int[] res = new int[s2.size()];
		int k=0;
		for(int n : s2) {
			res[k++] = n;
		}

		for(int p=0; p<res.length; p++) 
			System.out.println(res[p]);
		return res;					//res[0]=2, res[1]=6
	}

	//sol2: public static int binarySearch(int[] a, int key)
	public int[] intersection2(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<nums1.length; i++) {
			if(i==0 || i>0 && nums1[i] != nums1[i-1]) {
				if(Arrays.binarySearch(nums2, nums1[i]) > -1) {
					list.add(nums1[i]);
				}
			}
		}
		int[] res = new int[list.size()];
		int k=0;
		for(int n:list)
			res[k++] = n;
		for(int p=0; p<res.length; p++) 
			System.out.println(res[p]);
		return res;
	}
	public static void main(String[] args) {
		n349_Intersection_of_Two_Arrays obj = new n349_Intersection_of_Two_Arrays();
		int[] nums1 = {1,2,2,1,3,4,5,5,6};
		int[] nums2 = {2,2,6};
		System.out.println(obj.intersection(nums1, nums2));
		//System.out.println(obj.intersection2(nums1, nums2));
	}
}
