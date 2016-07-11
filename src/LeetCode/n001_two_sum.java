package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class n001_two_sum {
	//Brute Force
	public int[] twoSum(int[] nums, int target) {
		for (int i=0; i<nums.length; i++) {
			for (int j=i+1; j<nums.length-1; j++) {
				if (nums[j] == target - nums[i]) {		//==
					System.out.println("Found it!");
					 return new int[] { i, j };
				}
			}
		}
		 throw new IllegalArgumentException("No two sum solution");
	}
	
	//Hash Table#1
	public int[] twoSum_hash1(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<> ();
		for (int i=0; i<nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int j=0; j<nums.length; j++) {
			int complement = target - nums[j];
			if (map.containsKey(complement) && map.get(complement) != j) {		//TODO:
				return new int[] {j, map.get(complement)};
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	//Hash Table#2
	public int[] twoSum_hash2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<> ();
		for (int i=0; i<nums.length; i++) {
			int complement = target - nums[i];
			System.out.println(map.toString());	 
			if (map.containsKey(complement)) {		//first map is empty 
				return new int[] {map.get(complement), i};
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	public static void main(String[] args) {
		n001_two_sum obj = new n001_two_sum();
		int [] nums = {2, 17, 7, 15};
		int target = 9;
		int [] res = obj.twoSum(nums, target);
		int [] res_hash1= obj.twoSum_hash1(nums, target);
		int [] res_hash2= obj.twoSum_hash2(nums, target);
		
		System.out.println(Arrays.toString(res));		
		System.out.println(Arrays.toString(res_hash1));	
		System.out.println(Arrays.toString(res_hash2));	
		//Ref:http://stackoverflow.com/questions/409784/whats-the-simplest-way-to-print-a-java-array
	}
}
