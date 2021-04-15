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
//Sliding window
public class n030_Substring_with_Concatenation_of_All_Words {
	//Good https://redquark.org/leetcode/0030-substring-with-concatenation-of-all-words/
	public List<Integer> findSubstring2(String s, String[] words) {
		List<Integer> res = new ArrayList<Integer>();
		
		if(s == null || s.length() == 0 || words.length == 0) {
			return res;
		}
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for(String word : words) {
			map.put(word, map.getOrDefault(word, 0)+1);
		}
		
        int wordLength = words[0].length();
        int wordArrayLength = wordLength * words.length;
		
		for(int i=0; i<=s.length() - wordArrayLength; i++) {		//<=
			String currentString = s.substring(i, i+wordArrayLength);
			
			HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
			
			int index = 0;
			int j = 0;
			
			while(index < words.length) {			//0,1   only 2 times, cuz j+wordLength(3) 
				String partString = currentString.substring(j, j+wordLength);
				
				wordMap.put(partString, wordMap.getOrDefault(partString, 0)+1);		//this is wordMap not map
				
				index++;
				j = j+ wordLength;
			}
			
			if(map.equals(wordMap)) {
				res.add(i);
			}
		}
		
		
		return res;
	}
	
	
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<Integer>();

		if(words == null || words.length == 0 || s == null || s.equals("")) 
			return res;

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(String word : words) 
			map.put(word, map.containsKey(word) ? map.get(word)+1: 1);

		int len = words[0].length();

		for(int i=0; i<len; i++) {
			HashMap<String, Integer> curMap = new HashMap<String, Integer>();
			int start = i; 
			int count = 0;
			for(int j=i; j<=s.length()-len; j+=len) {				//F: range control: need s.length()-len, so j won't OOR
				String sub = s.substring(j, j+len);					//F: use j not start! so we can get through words

				if(map.containsKey(sub)) {
					curMap.put(sub, curMap.containsKey(sub) ? curMap.get(sub)+1 : 1);
					count++;
					while(curMap.get(sub) > map.get(sub)) {				//Need to use while
						String tmp = s.substring(start, start+len);		//Need tmp to target the sliding window start point
						curMap.put(tmp, curMap.get(tmp)-1);
						start = start + len;
						count--;
					}
					if(count == words.length) {							//F: check count!
						String tmp = s.substring(start, start+len);
						curMap.put(tmp, curMap.get(tmp)-1);				//Need to sliding window, so next curMap value can match next sub
						res.add(start);
						start = start + len;
						count--;
					}
				} else {
					curMap.clear();			//Removes all of the mappings from this map
					start = j + len;		//why need add len? because whole sub will be useless	
					count = 0;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		n030_Substring_with_Concatenation_of_All_Words obj = new n030_Substring_with_Concatenation_of_All_Words();
		String s = "barfoothefoobarbarman";
		String[] words = {"foo", "bar"}; 
		System.out.println(obj.findSubstring(s, words));
		System.out.println(obj.findSubstring2(s, words));
	}
}
