package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

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
	//https://www.cnblogs.com/Dylan-Java-NYC/p/4957857.html
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> res = new ArrayList<List<String>>();
		Map<String, Integer> distMap = new HashMap<String, Integer>();
		HashSet<String> dict = new HashSet<String>(wordList);				//wordList

		bfs(beginWord, endWord, dict, distMap);  							//begin, end
		dfs(endWord, beginWord, new ArrayList<String>(), distMap, res);  	//end, begin
		
		return res;
	}
	private void dfs(String cur, String end, List<String> newPath, Map<String, Integer> distMap, List<List<String>> res){  
		if (cur.equals(end)){  
			newPath.add(end);  						//add 'beginWord'
			Collections.reverse(newPath);			//reverse()  
			res.add(newPath);  
			return;  
		}  
		
		if (!distMap.containsKey(cur)) {			//must!!! for no match case and need to distMap.get(cur); //NullPointerException
            return;
        }
 		newPath.add(cur);  							//start with 'endWord'
		int next_deep = distMap.get(cur);  			//distance for cur
		
		for (int i=0; i<cur.length(); i++){  
			StringBuilder newWord = new StringBuilder(cur);
			for (char ch='a'; ch<='z'; ch++){
				newWord.setCharAt(i, ch); 
				//distance between cur & newWord need to be '1'
				if (distMap.get(newWord.toString()) != null && distMap.get(newWord.toString()) == next_deep-1) {  
					List<String> newPathArray = new ArrayList<String>(newPath);
					dfs(newWord.toString(), end, newPathArray, distMap, res);  
				}
			}  
		}  
	}
	
	private void bfs(String beginWord, String endWord, Set<String> dict, Map<String, Integer> distMap) { 
		distMap.put(beginWord, 1);						//add 1

		Queue<String> queue = new LinkedList<String>();
		queue.add(beginWord);

		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			for(int i=0; i<levelSize; i++) {
				String cur = queue.poll();
				for(int j=0; j<cur.length(); j++) {
					StringBuilder newWord = new StringBuilder(cur);			
					for(char ch='a'; ch<='z'; ch++) {
						newWord.setCharAt(j, ch);
						//set -> contains, map -> containsKey	 
						if(dict.contains(newWord.toString()) && !distMap.containsKey(newWord.toString())) {   //check distMap handle beginWord in wordList
							if(newWord.toString().equals(endWord)) {
								distMap.put(newWord.toString(), distMap.get(cur)+1);	//get cur, cuz it transform from cur
								return;
							}
							distMap.put(newWord.toString(), distMap.get(cur)+1);
							dict.remove(newWord.toString());							//need to remove, Time Limit Exceeded
							queue.offer(newWord.toString());
						}
					}
				}
			}
		}
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
		
		List<String> wordList2 = new ArrayList<String>();
		wordList2.add("hot");
		wordList2.add("dot");
		wordList2.add("dog");
		System.out.println(obj.findLadders("hot", "dog", wordList2));
	}
}
