package LeetCode;

import java.util.HashMap;

public class n387_First_Unique_Character_in_a_String {
	public int firstUniqChar(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i =0; i<s.length(); i++) {
			Integer t = map.get(s.charAt(i));
			if(t == null) {
				t = new Integer(0);
			} 
			map.put(s.charAt(i), t+1);
		}
		for(int j=0; j<s.length(); j++) {
			if(map.get(s.charAt(j)) == 1)
				return j;
		}
		return -1;
/*		int freq [] = new int[26];
        for(int i=0; i<s.length(); i++)
            freq [s.charAt(i) - 'a']++;
        for(int i=0; i<s.length(); i++) {
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;*/
	}

	public static void main(String[] args) {
		n387_First_Unique_Character_in_a_String obj = new n387_First_Unique_Character_in_a_String();
		System.out.println(obj.firstUniqChar("leetcode"));
		//System.out.println(obj.firstUniqChar("loveleetcode"));
	}
}
