package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class n170_Two_Sum_III_Data_structure_design {
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	// Add the number to an internal data structure.
	public void add(int number) {
		if(map.containsKey(number)) {
			map.put(number,	map.get(number)+1);
		} else
			map.put(number, 1);
		System.out.println(map);
	}
	
	// Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
		for(int i : map.keySet()) {			//keySet
			if(map.containsKey(value-i)) {
				 if ((value-i) != i) return true;		//4-1 != 1 
				 else if (map.get(i) >= 2) return true;	//has more than 2 times in the map
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		n170_Two_Sum_III_Data_structure_design obj = new n170_Two_Sum_III_Data_structure_design();
		obj.add(1);
		obj.add(3);
		obj.add(5);
		System.out.println(obj.find(4));
	}
}
