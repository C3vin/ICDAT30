package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:
The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.

Example 1:
Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]

Example 2:
Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.

Example 3:
Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]
 */
public class n140_Word_Break_II {
	public List<String> wordBreak(String s, List<String> wordDict) {
		//LC139 word break use DP, LC140 word break || use DFS
		//looks like we can still use DP on LC sol

		//DFS
		HashMap<Integer, List<String>> map = new HashMap<Integer, List<String>>();	
		return helper(s, wordDict, 0, map);
	}

	private List<String> helper(String s, List<String> wordDict, int start, HashMap<Integer, List<String>> map) {
		if (map.containsKey(start)) {
			return map.get(start);
		}
		ArrayList<String> res = new ArrayList<String>();
		//We have traversed the input and are done with breaking up the word
		if (start == s.length()) {
			res.add("");			
			return res;
		}
		for (int end = start + 1; end <= s.length(); end++) {
			if (wordDict.contains(s.substring(start, end))) {
				List<String> lists = helper(s, wordDict, end, map);
				for (String list : lists) {
					res.add(s.substring(start, end) + (list.equals("") ? "" : " ") + list);
				}
			}
		}

		map.put(start, res);
		return res;
	}

	public List<String> wordBreak2(String s, List<String> wordDict) {
		// write your code here
		if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
			return new ArrayList<String>();
		}

		Map<String, List<String>> memo = new HashMap<String, List<String>>();

		return wordBreakHelper(s, wordDict, memo);
	}

	private List<String> wordBreakHelper(String s, List<String> wordDict, Map<String, List<String>> memo) {
		if (memo.containsKey(s)) {
			return memo.get(s);
		}

		List<String> res = new ArrayList<>();	 
		if (wordDict.contains(s)) {
			res.add(s);
		}

		for (int i=1; i<=s.length(); i++) {
			String prefix = s.substring(0, i);
			if (wordDict.contains(prefix)) {
				String suffix = s.substring(i);
				//System.out.println("suffix: "+suffix);
				List<String> suffixAns = wordBreakHelper(suffix, wordDict, memo);

				for (String word : suffixAns) {
					res.add(prefix + " " + word);
				}
			}
		}

		memo.put(s, res);
		System.out.println(memo);
		return res;
	}

	//best fast
	public List<String> wordBreak3(String s, List<String> wordDict) {
		return dfs(s, wordDict, new HashMap<String, List<String>>());
	}
	
	private List<String> dfs(String s, List<String> wordDict, HashMap<String, List<String>> map) {
		if(map.containsKey(s)) {
			return map.get(s);
		}
		ArrayList<String> res = new ArrayList<String>();
		//We have traversed the input and are done with breaking up the word
		if (s.length() == 0) {
			res.add("");			
			return res;
		}
		
		for(String word : wordDict) {
			if(s.startsWith(word)) {
				List<String> lists = dfs(s.substring(word.length()), wordDict, map);
				
				for(String list : lists) {
					res.add(word + (list.equals("") ? "" : " ") + list);
				}
			}
		}
		
		map.put(s, res);
		System.out.println(map);
		return res;
	}
	
	public static void main(String[] args) {
		n140_Word_Break_II obj = new n140_Word_Break_II();
		System.out.println(obj.wordBreak("catsanddog", new ArrayList<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));
		System.out.println(obj.wordBreak2("catsanddog", new ArrayList<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));
		System.out.println(obj.wordBreak3("catsanddog", new ArrayList<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));
	}
}
