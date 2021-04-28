package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

public class n350_Intersection_of_Two_Arrays_II {
	//Good! [LC349-LC350]
	public int[] intersect2(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> interMap = new HashMap<Integer, Integer>();
        
        for(int i=0; i<nums1.length; i++) {
           map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
        }

        for(int i=0; i<nums2.length; i++) {
            if(map.containsKey(nums2[i])) {
                if(map.get(nums2[i]) > 0) {
                    interMap.put(i, nums2[i]);
                    map.put(nums2[i], map.get(nums2[i])-1);
                }
            }
        }
        
        int[] res = new int[interMap.size()];
        int k=0;
        for(int key : interMap.values()){
            res[k++] = key;
        }
        
        return res;
    }
	
	public int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<nums1.length; i++) {
			if(map.containsKey(nums1[i])) {
				map.put(nums1[i], map.get(nums1[i]) + 1);
			} else {
				map.put(nums1[i], 1);
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<nums2.length; i++) {
			if(map.containsKey(nums2[i])) { //need to check containsKey first, java.lang.NullPointerException
				if(map.get(nums2[i]) > 0) {	//need to check > 0, because might added already		
					map.put(nums2[i], map.get(nums2[i])-1);
					list.add(nums2[i]);
				}
			}
		}
		int[] res = new int[list.size()];
		for(int i=0; i<res.length; i++) {
			res[i] = list.get(i);
		}
		return res;
	}
	public static void main(String[] args) {
		n350_Intersection_of_Two_Arrays_II obj = new n350_Intersection_of_Two_Arrays_II();
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		//System.out.println(obj.intersect(nums1, nums2));
		System.out.println(obj.intersect(new int[] {4,9,5}, new int[] {9,4,9,8,4}));
	}
}
