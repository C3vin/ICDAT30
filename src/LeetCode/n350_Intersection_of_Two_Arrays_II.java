package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

public class n350_Intersection_of_Two_Arrays_II {
	public int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<nums1.length; i++) {
			if(map.containsKey(nums1[i])) {
				map.put(nums1[i], map.get(nums1[1]) + 1);
			} else {
				map.put(nums1[i], 1);
			}
		}
		System.out.println("@1: " + map);
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<nums2.length; i++) {
			if(map.containsKey(nums2[i])) {
				if(map.get(nums2[i]) > 1) {			//need to check containsKey first, java.lang.NullPointerException
					map.put(nums2[i], map.get(nums2[i])-1);
					
				} else {
					map.remove(nums2[i]);
				}
				list.add(nums2[i]);
			}
		}
		System.out.println(list);
		int[] res = new int[list.size()];
		for(int i=0; i<res.length; i++) {
			res[i] = list.get(i);
		}
		return res;
	}
	public int[] intersect2(int[] nums1, int[] nums2) {
		    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		    for(int i: nums1){
		        if(map.containsKey(i)){
		            map.put(i, map.get(i)+1);
		        }else{
		            map.put(i, 1);
		        }
		    }
		    System.out.println("@2: " + map);
		    ArrayList<Integer> list = new ArrayList<Integer>();
		    for(int i: nums2){
		        if(map.containsKey(i)){
		            if(map.get(i)>1){
		                map.put(i, map.get(i)-1);
		            }else{
		                map.remove(i);
		            }
		            list.add(i);
		        }
		    }
		 
		    int[] result = new int[list.size()];
		    int i =0;
		    while(i<list.size()){
		        result[i]=list.get(i);
		        i++;
		    }
		 
		    return result;
	}
	public static void main(String[] args) {
		n350_Intersection_of_Two_Arrays_II obj = new n350_Intersection_of_Two_Arrays_II();
		/*		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};*/
		int[] nums1 = {21,47,80,4,3,24,87,12,22,11,48,6,89,80,74,71,74,55,58,56,4,98,40,66,49,53,62,27,3,66,78,24,48,69,88,12,80,63,98,65,46,35,72,5,64,72,7,29,37,3,2,75,44,93,79,78,13,39,85,26,15,41,87,47,29,93,41,74,6,48,17,89,27,61,2,68,99,57,45,73,25,33,38,32,58};
		int[] nums2 = {1,39,6,81,85,10,38,22,0,89,57,93,58,69,65,80,84,24,27,54,37,36,26,88,2,7,24,36,51,5,74,57,45,56,55,67,25,33,78,49,16,79,74,80,36,27,89,49,64,73,96,60,92,31,98,72,22,31,0,93,70,87,80,66,75,69,81,52,94,90,51,90,74,36,58,38,50,9,64,55,4,21,49,60,65,47,67,8,38,83};
		System.out.println(obj.intersect(nums1, nums2));
		System.out.println(obj.intersect2(nums1, nums2));
	}
}
