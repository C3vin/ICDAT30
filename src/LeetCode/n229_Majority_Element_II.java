package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Given an integer array of size n, find all elements that appear more than n/3 times.
Note: The algorithm should run in linear time and in O(1) space.

Example 1:
Input: [3,2,3]
Output: [3]

Example 2:
Input: [1,1,1,3,3,2,2,2]
Output: [1,2]
 */
public class n229_Majority_Element_II {
	//No Hashmap : should run in linear time and in O(1) space.
	public List<Integer> majorityElement(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Integer> res = new ArrayList<Integer>();
		//handle {} & {1}
		if(nums.length < 0) {
			return res;
		} else if(nums.length == 1) {
			res.add(nums[0]);
			return res;
		}

		for(int num : nums) {
			map.put(num, map.getOrDefault(num, 0)+1);
			int len = (nums.length/3 > 0) ? nums.length/3 : 0;	//handle {1,2}
			if (map.get(num) > len) {
				if(!res.contains(num)) {	//handle {2,2}
					res.add(num);			//general case
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		n229_Majority_Element_II obj = new n229_Majority_Element_II();
		System.out.println(obj.majorityElement(new int[] {3,2,3}));
		System.out.println(obj.majorityElement(new int[] {1,1,1,3,3,2,2,2}));
		System.out.println(obj.majorityElement(new int[] {2,2}));
		System.out.println(obj.majorityElement(new int[] {1,2}));
		System.out.println(obj.majorityElement(new int[] {1}));
		System.out.println(obj.majorityElement(new int[] {}));
	}
}
