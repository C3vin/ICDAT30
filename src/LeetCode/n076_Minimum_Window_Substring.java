package LeetCode;

import java.util.HashMap;

//S = "ADOBECODEBANC", T = "ABC"  =>  Minimum window is "BANC".
public class n076_Minimum_Window_Substring {
	public String minWindow(String s, String t) {
		String res = "";
		if(s==null || t==null || s.length()==0 || t.length()==0) return res;
		HashMap<Character, Integer> dict = new HashMap<Character, Integer>();

		for(int i=0; i<t.length(); i++) {
			if(!dict.containsKey(t.charAt(i))) {
				dict.put(t.charAt(i), 1);
			} else
				dict.put(t.charAt(i), dict.get(t.charAt(i))+1);
		}

		int count=0;
		int pre=0;
		int minLen=s.length()+1;
		for(int i=0; i<s.length(); i++) {
			if(dict.containsKey(s.charAt(i))) {
				dict.put(s.charAt(i), dict.get(s.charAt(i))-1);	
				if(dict.get(s.charAt(i)) >= 0)
					count++;

				while(count == t.length()) {
					if(dict.containsKey(s.charAt(pre))) {
						dict.put(s.charAt(pre), dict.get(s.charAt(pre))+1);

						if(dict.get(s.charAt(pre)) > 0) {
							if(minLen > i-pre+1) {
								res = s.substring(pre, i+1);
								minLen = i-pre+1;
							} //if
							count--;
						} //if
					} //if
					pre++;
				} //while
			}
		}
		return res;
	}
	public static void main(String[] args) {
		n076_Minimum_Window_Substring obj = new n076_Minimum_Window_Substring();
		System.out.println(obj.minWindow("ADOBECODEBANC", "ABC"));
	}
}
