package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

Note:
Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.

Example 1:
Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]

Example 2:
Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: []

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class n126_Word_Ladder_II {
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> res = new ArrayList<List<String>>();
		HashSet<String> set = new HashSet<String>(wordList);				//wordList

		Queue<String> queue = new LinkedList<String>();
		queue.offer(beginWord);

		int step = 1;

		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			for(int i=0; i<levelSize; i++) {
				String cur = queue.poll();
				for(int j=0; j<cur.length(); j++) {
					StringBuilder newWord = new StringBuilder(cur);
					for(char ch='a'; ch<'z'; ch++) {
						newWord.setCharAt(j, ch);
						if(set.contains(newWord.toString())) {				//stringBuild need toString
							if(newWord.toString().equals(endWord)) {		//stringBuild need toString
								return step+1;
							}
							set.remove(newWord.toString());					//stringBuild need toString
							queue.offer(newWord.toString());				//stringBuild need toString
						}
					}
				}
			}
			step++;
		}
		return res;
	}
	
	public static void main(String[] args) {
		n126_Word_Ladder_II obj = new n126_Word_Ladder_II();
		List<String> wordList1 = new ArrayList<String>();
		wordList1.add("hot");
		wordList1.add("dot");
		wordList1.add("dog");
		wordList1.add("lot");
		wordList1.add("log");
		wordList1.add("cog");
		System.out.println(obj.findLadders("hit", "cog", wordList1));
	}
}
