package LeetCode;

import java.util.HashMap;
import java.util.HashSet;

/*
Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  
It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.

Example:
Input: 
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"

Explanation: 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"), 
and that "hit" isn't the answer even though it occurs more because it is banned.

Note:

1 <= paragraph.length <= 1000.
1 <= banned.length <= 100.
1 <= banned[i].length <= 10.
The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
There are no hyphens or hyphenated words.
Words only consist of letters, never apostrophes or other punctuation symbols.
 */
public class n819_Most_Common_Word {
	public String mostCommonWord(String paragraph, String[] banned) {
		HashSet<String> set = new HashSet<String>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String[] words = paragraph.toLowerCase().split(" |,|\\.|!|\\?|'|;");			//F: \\.
		
		for(String ba : banned) {
			set.add(ba);
		}
		
		int max = Integer.MIN_VALUE;
		for(String word : words) {
			if(!set.contains(word) && !word.equals("")) {			//deal with "" buz regex will created "" after split
				map.put(word, map.getOrDefault(word, 0)+1);
				
				int count = map.get(word);
				if(count > max) {
					max = count;
				}
			}
		}
		
		for(String maxWord : map.keySet()) {
			if(map.get(maxWord) == max) {
				return maxWord;
			}
		}
		
		return new String();
	}
	public static void main(String[] args) {
		n819_Most_Common_Word obj = new n819_Most_Common_Word();
		System.out.println(obj.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[] {"hit"}));
		System.out.println(obj.mostCommonWord("Bob!", new String[] {"hit"}));
		System.out.println(obj.mostCommonWord("Bob. hit!, ..baLl?", new String[] {"bob", "hit"}));
	}
}
