package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.

Example 1:
Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5
Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Example 2:
Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0
Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */

public class n127_Word_Ladder {
	//BFS
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		HashSet<String> dict = new HashSet<String>(wordList);				//wordList

		Queue<String> queue = new LinkedList<String>();
		queue.offer(beginWord);

		int step = 1;

		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			
			for(int i=0; i<levelSize; i++) {
				String cur = queue.poll();
				
				for(int j=0; j<cur.length(); j++) {
					StringBuilder newWord = new StringBuilder(cur);
					//char[] newWord = cur.toCharArray();					//plan B
					for(char ch='a'; ch<='z'; ch++) {
						newWord.setCharAt(j, ch);							//setCharAt!!!
						
						if(dict.contains(newWord.toString())) {				 
							if(newWord.toString().equals(endWord)) {		//stringBuild need toString
								step++;										//don't foget!
								return step;
							}
							
							dict.remove(newWord.toString());				//need to remove, Time Limit Exceeded
							queue.offer(newWord.toString());				//need to add to queue, for Next move	
						}
						
						/*newWord[j] = ch;									//plan B
						String strCurr = new String(newWord);
						if(dict.contains(strCurr)) {
							if(strCurr.equals(endWord)) {
								return step+1;
							}
							dict.remove(strCurr);
							queue.offer(strCurr);
						}*/
					}
				}
			}
			step++;				//why here, cuz every time add into Queue means found one step
		}
		
		return 0;
	}

	public static void main(String[] args) {
		n127_Word_Ladder obj = new n127_Word_Ladder();
		List<String> wordList = new ArrayList<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		System.out.println(wordList);
		System.out.println(obj.ladderLength("hit", "cog", wordList));
	}
}
