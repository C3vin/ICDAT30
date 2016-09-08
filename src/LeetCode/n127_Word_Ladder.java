package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class n127_Word_Ladder {
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		if(beginWord==null || endWord==null || beginWord.length()==0 || endWord.length()==0 || beginWord.length()!=endWord.length())  
			return 0;  

		LinkedList<String> queue = new LinkedList<String>();  
		HashSet<String> visited = new HashSet<String>();  
		int level= 1;  		//the start string already count for 1
		int lastNum = 1;  	// # of remaining elements in current level
		int curNum = 0;  	// # of remaining elements in next level

		queue.offer(beginWord);  
		visited.add(beginWord);  

		while(!queue.isEmpty()) {  
			String cur = queue.poll();  
			lastNum--;  

			for(int i=0; i<cur.length(); i++) {  
				char[] charCur = cur.toCharArray();  
				System.out.println("i: " +i +" : " +charCur[i]);
				
				for(char c='a'; c<='z'; c++) {  
					charCur[i] = c;  
					String temp = new String(charCur);  

					if(temp.equals(endWord))  
						return level+1;  
					if(wordList.contains(temp) && !visited.contains(temp)) {  
						curNum++;  
						queue.offer(temp);  
						visited.add(temp);  
						//System.out.println(temp);
					}  
				}  
			}  
			if(lastNum==0) {  
				lastNum = curNum;  
				curNum = 0;  
				level++;  
			}  
		}  
		return 0;  
	}

	public static void main(String[] args) {
		n127_Word_Ladder obj = new n127_Word_Ladder();
		String[] wordLists=  {"hot","dot","dog","lot","log"};
		Set<String> wordList = new HashSet<String>();
		for(int i=0; i<wordLists.length; i++) {
			wordList.add(wordLists[i]);
		}
		System.out.println(obj.ladderLength("hit", "cog", wordList));
	}
}
