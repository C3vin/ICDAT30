package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an array of strings, group anagrams together.

Example:
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

Note:
All inputs will be in lowercase.
The order of your output does not matter.
 */
public class n049_Group_Anagrams {
	//convert and sort
	public List<List<String>> groupAnagrams2(String[] strs) {
		if(strs.length == 0 || strs == null) {
			return new ArrayList<List<String>>();
		}
		
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();			//value: List<String>

		for(String s : strs) {
			char[] ch = s.toCharArray();		//convert string to ch array
			
			Arrays.sort(ch);
			
			String key = String.valueOf(ch);	//convert ch array to string
			if(!map.containsKey(key)) {
				map.put(key, new ArrayList<String>());			//just create the space!
			}
			map.get(key).add(s);				//Tip: get value(List) and add the string s. e.g. eat, tea in map
			//System.out.println(map);			//{aet=[eat, tea, ate], abt=[bat], ant=[tan, nat]}
		} 
		
		return new ArrayList<List<String>>(map.values());
	}
	
	//sol3 Better!
	public List<List<String>> groupAnagrams3(String[] strs) {
		if(strs.length == 0 || strs == null) {
			return new ArrayList<List<String>>();
		}
		
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();		//value: List<String>

		for(String str : strs) {
			char[] ch = str.toCharArray();			//convert string to ch array char[]!!! not char
			
			Arrays.sort(ch);						//must sort!

			String key = String.valueOf(ch);		//convert ch array to string
			
			if(map.containsKey(key)) {
				map.get(key).add(str);
			} else {
                map.put(key, new ArrayList<String>());
                map.get(key).add(str);
				//map.put(key, new ArrayList<String>(Arrays.asList(s)));	//default value need Arrays.asList() 
			}
		}
		
        List<List<String>> res = new ArrayList<List<String>>(map.values());
        
        return res;
		//return new ArrayList<List<String>>(map.values());				//need map.values()!
	}

	public static void main(String[] args) {
		n049_Group_Anagrams obj = new n049_Group_Anagrams();
		String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(obj.groupAnagrams2(s));
		System.out.println(obj.groupAnagrams3(s));
	}
}
