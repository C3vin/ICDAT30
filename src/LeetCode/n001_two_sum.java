package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class n001_two_sum {

	//LR 
	public int[] twoSum(int[] nums, int target) {
		int[] res = new int[2];
		if(nums == null || nums.length < 2) return null;
		Arrays.sort(nums);  		//Order
		int l=0;
		int r=nums.length-1;
		while(l<r) {
			if(nums[l] + nums[r] == target) {
				res[0]=l;
				res[1]=r;
				return res;
			}
			else if(nums[l] + nums[r] > target) {
				r--;
			} else {
				l++;
			}
		}
		return null;
	}
	
	//Hash Table
	public int[] twoSum_hash(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer> ();
		int[] res = new int[2];
		for (int i=0; i<nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {		//first map is empty 
				res[0] = map.get(complement);
				res[1] = i;
				return res;
 				//return new int[] {map.get(complement), i};
			}
			map.put(nums[i], i);
		}
		return null;
	}

	public static void main(String[] args) {
		n001_two_sum obj = new n001_two_sum();
		int [] nums = {3,2,4};
		int [] nums1 = {3,2,4};
		int target = 6;

		//System.out.println(Arrays.toString(obj.twoSum(nums, target)));		//The reason order int array
		System.out.println(Arrays.toString(obj.twoSum_hash(nums1, target)));	
	}
}
