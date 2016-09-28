package LeetCode;

import java.util.HashMap;

public class n290_Word_Pattern {
	public boolean wordPattern(String pattern, String str) {
		HashMap<Character, String> map = new HashMap<Character, String>();
		String[] s = str.split(" ");		//need []
		if(s.length != pattern.length())
			return false;

		for(int i=0; i<pattern.length(); i++) {
			char c = pattern.charAt(i);
			if(map.containsKey(c)){
				if(!map.get(c).equals(s[i]))
					return false;
			}else {
				if(map.containsValue(s[i]))			//F: Need to check!
					return false;
				map.put(c, s[i]);
			}	
		}
		return true;
	}
	
	public static void main(String[] args) {
		n290_Word_Pattern obj = new n290_Word_Pattern();
		String pattern = "abba";
		String str = "dog dog dog dog";
		System.out.println(obj.wordPattern(pattern, str));
	}
}
