package LeetCode;

import java.util.HashMap;

public class n205_Isomorphic_Strings {
	public boolean isIsomorphic(String s, String t) {
		if(s.length() != t.length()) return false;
		if(s == null || t == null) return false;

		HashMap<Character, Character> map = new HashMap<Character, Character>();

		for(int i=0; i<s.length(); i++) {
			char ss = s.charAt(i);
			char tt = t.charAt(i);

			if(map.containsKey(ss)) {
				if(map.get(ss) != tt) {
					return false;
				}
			}else {
				if(map.containsValue(tt))	//if tt is already being mapped
					return false;
				map.put(ss, tt);
			}
		}
		return true;
	}
	public static void main(String[] args) {
		n205_Isomorphic_Strings obj = new n205_Isomorphic_Strings();
		String s = "2wd";
		String t = "cdd";
		System.out.println(obj.isIsomorphic(s, t));
	}
}
