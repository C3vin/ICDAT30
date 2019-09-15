package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

/*
Given an array of size n, find the majority element. The majority element is the element that 
appears more than n/2 times.
You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:
Input: [3,2,3]
Output: 3

Example 2:
Input: [2,2,1,1,1,2,2]
Output: 2
 */
public class n169_Majority_Element {
	public int majorityElement(int[] nums) {
		int count = 0;
		int res = 0;
		for(int num : nums) {
			if(count == 0) {
				res = num;
			}
			if(res != num) {
				count--;
			} else {
				count++;
			}
		}
		return res;
	}
	public int majorityElement2(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length/2];
	}
	public int majorityElement3(int[] nums) {
		int res = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();	
		for(int num : nums) {
			/* if (!map.containsKey(num)) {
	                map.put(num, 1);
	            } else {
	                map.put(num, map.get(num) + 1);
	            }*/
			map.put(num, map.getOrDefault(num, 0)+1);
			
			if (map.get(num) > nums.length / 2) {
				res = num;
				break;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		n169_Majority_Element obj = new n169_Majority_Element();
		System.out.println(obj.majorityElement(new int[] {3,2,3}));
		System.out.println(obj.majorityElement(new int[] {2,2,1,1,1,2,2}));
		System.out.println(obj.majorityElement(new int[] {1,3,1,1,3}));
		System.out.println(obj.majorityElement2(new int[] {3,2,3}));
		System.out.println(obj.majorityElement2(new int[] {2,2,1,1,1,2,2}));
		System.out.println(obj.majorityElement2(new int[] {1,3,1,1,3}));
		System.out.println(obj.majorityElement3(new int[] {3,2,3}));
		System.out.println(obj.majorityElement3(new int[] {2,2,1,1,1,2,2}));
		System.out.println(obj.majorityElement3(new int[] {1,3,1,1,3}));
	}
}
