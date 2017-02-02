package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

//Given an array of size n, find the majority element. The majority element is the element that appears more than n/2 times.
public class n169_Majority_Element {
	public int majorityElement(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for(int i=0; i<nums.length; i++) {
			if(map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i])+1);
			} else {
				map.put(nums[i], 1);
			}
			if(map.get(nums[i]) > nums.length/2) {		//can't >=, e.g. 3/2 = 1, big issue!
				return nums[i];
			}
		}
		return 0;
	}
	public int majorityElement2(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length/2];
	}
	public static void main(String[] args) {
		n169_Majority_Element obj = new n169_Majority_Element();
		int[] nums = {1,2,3,2};
		System.out.println(obj.majorityElement(nums));
		System.out.println(obj.majorityElement2(nums));
	}
}
