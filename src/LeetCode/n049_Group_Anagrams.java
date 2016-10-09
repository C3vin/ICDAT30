package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class n049_Group_Anagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<List<String>>();
		HashMap<String,ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		
		for(String str : strs) {
			char[] arr = new char[26];
			for(int i=0; i<str.length(); i++) {
				arr[str.charAt(i) - 'a']++;
			}
			String ns = new String(arr);
			if(map.containsKey(ns)) {
				map.get(ns).add(str);
			} else {
				ArrayList<String> al = new ArrayList<String>();
				al.add(str);
				map.put(ns, al);
			}
		}
		res.addAll(map.values());
		
		return res;
	}

	public static void main(String[] args) {
		n049_Group_Anagrams obj = new n049_Group_Anagrams();
		String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(obj.groupAnagrams(s));
	}
}