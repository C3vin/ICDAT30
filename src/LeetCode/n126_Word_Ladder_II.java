package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
	//https://github.com/awangdev/LintCode/blob/master/Java/Word%20Ladder%20II.java
	//https://wdxtub.com/interview/14520607221562.html
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> res = new ArrayList<List<String>>();
		if(beginWord.compareTo(endWord) == 0) {
			return res;
		}
		
		Set<String> visited = new HashSet<String>();
		Set<String> cur = new HashSet<String>();
		cur.add(beginWord);
		HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
		graph.put(endWord,new ArrayList<String>());
		boolean found = false;
		
		while (cur.isEmpty() == false && found == false) {
			Set<String> queue = new HashSet<String>();
			for(Iterator<String> it=cur.iterator();it.hasNext();) {
				visited.add(it.next());
			}
			for(Iterator<String> it=cur.iterator();it.hasNext();) {
				String str = it.next();
				char[] word = str.toCharArray();
				for (int j = 0; j < word.length; ++j) {
					char before = word[j];
					for (char ch = 'a'; ch <= 'z'; ++ch) {
						if (ch == before) continue;
						word[j] = ch;
						String temp = new String(word);
						if (wordList.contains(temp) == false) {
							continue;
						}
						if (found == true && endWord.compareTo(temp) != 0) {
							continue;
						}
						if (endWord.compareTo(temp) == 0) {
							found = true;
							(graph.get(endWord)).add(str);
							continue;
						}
						if (visited.contains(temp) == false) {
							queue.add(temp);
							if (graph.containsKey(temp) == false) {
								ArrayList<String> l = new ArrayList<String>();
								l.add(str);
								graph.put(temp,l);
							} else {
								(graph.get(temp)).add(str);
							}
						}
					}
					word[j] = before;
				}
			}
			cur = queue;
		}
		if (found == true) {
			ArrayList<String> path = new ArrayList<String>();
			trace(res, graph, path, beginWord, endWord);
		}
		return res;
	}
	public void trace(List<List<String>> res, 
			HashMap<String, ArrayList<String>> graph,
			ArrayList<String> path,
			String start, String now) {
		path.add(now);
		if (now.compareTo(start) == 0) {
			ArrayList<String> ans = new ArrayList<String>(path);
			Collections.reverse(ans);
			res.add(ans);
			path.remove(path.size()-1);
			return;
		}
		ArrayList<String> cur = graph.get(now);
		for (int i = 0; i < cur.size(); ++i) {
			trace(res,graph,path,start,cur.get(i));
		}
		path.remove(path.size()-1);
	}

	public List<List<String>> findLadders2(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> res = new ArrayList<List<String>>();
		Set<String> dict = new HashSet<String>(wordList);
		List<String> list = new ArrayList<String>();
		list.add(beginWord);

		Queue<List<String>> queue = new LinkedList<List<String>>();
		queue.offer(list);

		int level = 1;
		int minLevel = Integer.MAX_VALUE;

		Set<String> words = new HashSet<String>();

		while(!queue.isEmpty()) {
			List<String> cur = queue.poll();
			if(cur.size() > level) {
				for(String w : words) {
					dict.remove(w);
				}
				words.clear();
				level = cur.size();
				if(level > minLevel) {
					break;
				}
			}
			String last = cur.get(cur.size()-1);
			for(int i=0; i<last.length(); i++) {
				StringBuilder newWord = new StringBuilder(last);
				for(char ch='a'; ch<='z'; ch++) {
					newWord.setCharAt(i, ch);
					if (!dict.contains(newWord.toString())) {
						continue;
					}
					words.add(newWord.toString());
					List<String> nextPath = cur;
					nextPath.add(newWord.toString());
					if(newWord.toString().equals(endWord)) {
						res.add(nextPath);
						minLevel = level;
					} else {
						queue.offer(nextPath);
					}
				}
			}

		}
		return res;
	}
	//http://www.voidcn.com/article/p-udyjpbrr-b.html
	@@@
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
		System.out.println(obj.findLadders2("hit", "cog", wordList1));
	}
}
