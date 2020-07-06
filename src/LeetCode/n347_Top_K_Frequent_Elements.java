package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a non-empty array of integers, return the k most frequent elements.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

Note:
You may assume k is always valid, 1 <= k <= number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
You can return the answer in any order.
 */
public class n347_Top_K_Frequent_Elements {
	public int[] topKFrequent(int[] nums, int k) {
		int[] res = new int[k];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		//PriortyQueue<> ??
		for(int i=0; i<nums.length; i++) {
			if(map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i])+1);
			} else {
				map.put(nums[i], 1);
			}
		}

		List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
		list.sort((a,b) -> {
			return b.getValue() - a.getValue();				//need b - a
		});


		for(int i=0; i<k; i++) {
			res[i] = list.get(i).getKey();
		}

		return res;
	}

	//bucket sorts
	public int[] topKFrequent2(int[] nums, int k) {
		int[] res = new int[k];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for(int num : nums) {
			map.put(num, map.getOrDefault(num, 0)+1);
		}

		System.out.println(map);

		List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(nums.length+1);
		for(int i=0; i<nums.length+1; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		System.out.println(list);  //before [[], [], [], [], [], [], []]
		
		//if map: {1=1, 2=2, 3=3}
		for(int num : map.keySet()) {
/*			int x = map.get(num);
			System.out.println(x + " : " + num);
			
			List<Integer> tmp = list.get(map.get(num));
			tmp.add(num);
			System.out.println(tmp);*/
			
			list.get(map.get(num)).add(num);
		}
		
		System.out.println(list);  //why [[], [1], [2], [3], [], [], []]

		return res;
	}

	public static void main(String[] args) {
		n347_Top_K_Frequent_Elements obj = new n347_Top_K_Frequent_Elements();
		System.out.println(obj.topKFrequent(new int[] {1,1,1,2,2,3}, 2));
		System.out.println(obj.topKFrequent2(new int[] {3,3,1,2,2,3}, 2));
	}
}
