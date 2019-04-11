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
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<List<String>>();
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

		for(String str : strs) {
			//System.out.println(str); eat tea .... 
			char[] arr = new char[26];
			for(int i=0; i<str.length(); i++) {
				arr[str.charAt(i) - 'a']++;		//F: need - 'a'
			}
			String ns = new String(arr);
			if(map.containsKey(ns)) {
				map.get(ns).add(str);
			} else {
				ArrayList<String> list = new ArrayList<String>();
				list.add(str);
				map.put(ns, list);
			}
		}
		res = new ArrayList<List<String>>(map.values());

		return res;
	}

	//convert and sort
	public List<List<String>> groupAnagrams2(String[] strs) {
		if(strs.length == 0 || strs == null) {
			return new ArrayList<List<String>>();
		}
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();

		for(String s : strs) {
			char[] ch = s.toCharArray();		//convert string to ch array
			Arrays.sort(ch);
			
			String key = String.valueOf(ch);	//convert ch array to string
			if(!map.containsKey(key))
				map.put(key, new ArrayList<String>());
			map.get(key).add(s);				//Tip: get value(List) and add the string s. e.g. eat, tea in map
			//System.out.println(map);			//{aet=[eat, tea, ate], abt=[bat], ant=[tan, nat]}
		} 
		return new ArrayList<List<String>>(map.values());
	}
	
	//sol3
	public List<List<String>> groupAnagrams3(String[] strs) {
		if(strs.length == 0 || strs == null) {
			return new ArrayList<List<String>>();
		}
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();

		for(String s : strs) {
			char[] c = s.toCharArray();
			Arrays.sort(c);

			String key = String.valueOf(c);
			if(map.containsKey(key)) {
				map.get(key).add(s);
			} else {
				map.put(key, new ArrayList<String>(Arrays.asList(s)));	//default value need Arrays.asList() 
			}
		}
		return new ArrayList<List<String>>(map.values());
	}

	public static void main(String[] args) {
		n049_Group_Anagrams obj = new n049_Group_Anagrams();
		String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(obj.groupAnagrams(s));
		System.out.println(obj.groupAnagrams2(s));
		System.out.println(obj.groupAnagrams3(s));
	}
}
