	package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".*/

public class n599_Minimum_Index_Sum_of_Two_Lists {
	//super slow: Runtime: 200 ms
	public String[] findRestaurant(String[] list1, String[] list2) {
		HashMap<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		for(int i=0; i<list1.length; i++) {
			for(int j=0; j<list2.length; j++) {
				if(list1[i].equals(list2[j])) {
					if(!map.containsKey(i+j)) {
						map.put(i+j, new ArrayList<String>());
					}
					map.get(i+j).add(list1[i]);		//list2[j]
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for(int s : map.keySet()) {
			if(min > s)
				min = s;		//update min
		}

		String[] res = new String[map.get(min).size()];			//good way to convert list to string
		map.get(min).toArray(res);
		System.out.println(map.get(min));
		return res;
	}

	//HashMap liner 33ms
	public String[] findRestaurant2(String[] list1, String[] list2) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0; i<list1.length; i++) {
			map.put(list1[i], i);
		}

		int sum = 0;
		int min = Integer.MAX_VALUE;
		List<String> list = new ArrayList<String>();
		for(int i=0; i<list2.length; i++) {
			if(map.containsKey(list2[i])) {
				sum = i + map.get(list2[i]);
				if(min > sum) {
					min = sum;			//update min
					list.clear(); 		//clean first
					list.add(list2[i]);
				} else if(min == sum)				//F: deal multiple correct value
					list.add(list2[i]);
			}
		}
		String[] res = new String[list.size()];
		list.toArray(res);
		System.out.println(list);
		return res;
	}
	public static void main(String[] args) {
		n599_Minimum_Index_Sum_of_Two_Lists obj = new n599_Minimum_Index_Sum_of_Two_Lists();
		String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
		String[] list2 = {"KFC","Burger King","Tapioca Express","Shogun"};
		System.out.println(obj.findRestaurant(list1, list2));
		System.out.println(obj.findRestaurant2(list1, list2));
	}
}
