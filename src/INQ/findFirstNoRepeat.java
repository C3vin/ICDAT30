package INQ;

import java.util.HashMap;

public class findFirstNoRepeat {
	public Character findFirstNotRepeat(String s) {
		if(s.length() == 0) return null; 
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			System.out.println(c);
			if(map.containsKey(c)) {
				map.put(c, -1);
			} else  
				map.put(c, 1);
		}
		System.out.println(map);
		
		for(int j=0; j<s.length(); j++) {
			if(map.get(s.charAt(j)) == 1) {
				return s.charAt(j);
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		findFirstNoRepeat obj = new findFirstNoRepeat();
		System.out.println(obj.findFirstNotRepeat("abcdedg"));
	}
}
