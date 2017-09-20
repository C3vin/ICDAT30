package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
are given a string, s, and a list of words, words, that are all of the same length. 
Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]
You should return the indices: [0,9].
(order does not matter).
 */
public class n300_Substring_with_Concatenation_of_All_Words {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<Integer>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(String word : words) {
			map.put(word, map.containsKey(word) ? map.get(word)+1: 1);
		}
		
		int len = words[0].length();
		
		for(int i=0; i<len; i++) {
			HashMap<String, Integer> curFreq = new HashMap<String, Integer>();
			int start = i; 
			int count = 0;
			for(int j=i; j<=s.length()-len; j+=len) {				//F: range control: need s.length()-len, so j won't OOR
				String sub = s.substring(j, j+len);
				System.out.println("j: "+j+ " sub: "+sub);
				
				if(map.containsKey(sub)) {
					curFreq.put(sub, curFreq.containsKey(sub) ? curFreq.get(sub)+1 : 1);
					count++;
					
					while(curFreq.get(sub) > map.get(sub)) {
						String tmp = s.substring(start, start+len);
						curFreq.put(tmp, curFreq.get(tmp)-1);
						start = start + len;
						count--;
					}
					if(count == words.length) {
						String tmp = s.substring(start, start+len);
						curFreq.put(tmp, curFreq.get(tmp)-1);
						res.add(start);
						start = start + len;
						count--;
					}
				} else {
					curFreq.clear();
					start = j+len;
					count = 0;
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		n300_Substring_with_Concatenation_of_All_Words obj = new n300_Substring_with_Concatenation_of_All_Words();
		String s = "barfoothefoobarman";
		String[] words = {"foo", "bar"}; 
		System.out.print(obj.findSubstring(s, words));
	}
}
