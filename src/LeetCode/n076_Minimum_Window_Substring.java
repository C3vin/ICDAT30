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

		int count = 0;
		int pre = 0;
		int minLen = s.length()+1;
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
							} 
							count--;
						} 
					} 
					pre++;
				} 
			}
		}
		return res;
	}
	//better and faster
	public String minWindow2(String s, String t) {
		String res = "";
		int[] target = new int[256];
		for(int i=0; i<t.length(); i++) {
			target[t.charAt(i)]++;
		}

		int left = 0;
		int right = 0;
		int count = t.length();
		int minlen = Integer.MAX_VALUE;

		while(right < s.length() || count == 0) {			//F: need count == 0, because first got 'ADOBEC'(count=0) but need keep searching 
			if(count == 0) {
				if(minlen > right - left + 1) {
					minlen = right - left + 1;				//update minlen
					res = s.substring(left, right);			//update string res, reference
				}
				if(target[s.charAt(left)] >= 0) {
					count++;
				}
				target[s.charAt(left)]++;
				left++;
			} else {
				if(target[s.charAt(right)] >= 1) {
					count--;
				}
				target[s.charAt(right)]--;
				right++;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		n076_Minimum_Window_Substring obj = new n076_Minimum_Window_Substring();
		//System.out.println(obj.minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(obj.minWindow2("ADOBECODEBANC", "ABC"));
	}
}
