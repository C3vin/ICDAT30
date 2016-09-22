package LeetCode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class n127_Word_Ladder {
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		if(beginWord==null || endWord==null || beginWord.length()==0 || endWord.length()==0 || beginWord.length()!=endWord.length())  
			return 0;  
		LinkedList<String> queue = new LinkedList<String>();  
		HashSet<String> visited = new HashSet<String>();  
		int level= 1;  
		int lastNum = 1;  
		int curNum = 0;  
		queue.offer(beginWord);  
		visited.add(beginWord);  

		while(!queue.isEmpty()) {  
			String cur = queue.poll();  
			lastNum--;  
			System.out.println("last: " + lastNum);
			for(int i=0;i<cur.length();i++) {  
				char[] charCur = cur.toCharArray();
				for(char c='a';c<='z';c++)  {  
					charCur[i] = c;  
					String temp = new String(charCur);  
					if(temp.equals(endWord))   				//why can't use charCur.equals  
						return level+1;  
					if(wordList.contains(temp) && !visited.contains(temp)) {  
						curNum++;  		//?
						queue.offer(temp);  
						visited.add(temp);  
						System.out.println("temp: " +temp + " ,visited: "+visited);
					}  
				}  
			}
			System.out.println("curNum: "+curNum + " queue: " + queue);
			if(lastNum==0) {  
				lastNum = curNum;  
				curNum = 0;  
				level++;  
			}  
		}  
		return 0;  

		/*        if (beginWord == null || beginWord.isEmpty() || endWord == null || endWord.isEmpty())
            return 0;

        int length = 1;
        LinkedList<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        HashSet<String> visited = new HashSet<String>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            //System.out.println("queue size: "+queue.size() + " queue: " +  queue);
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                for (int j = 0; j < curr.length(); j++) {
                    char[] charCurr = curr.toCharArray();
                    for (char c = 'a'; c < 'z'; c++) {
                        charCurr[j] = c;  // change one character at a time
                        String strCurr = new String(charCurr);
                        if (strCurr.equals(endWord)) {
                            return length + 1;
                        } else {
                            if (wordList.contains(strCurr) && !visited.contains(strCurr)) {
                                queue.offer(strCurr);
                                visited.add(strCurr);
                            }
                        }
                    }
                }
            }
            length++;
        }
        return 0;*/
	}

	public static void main(String[] args) {
		n127_Word_Ladder obj = new n127_Word_Ladder();
		String[] wordLists=  {"hot","dot","dog","lot","log"};
		Set<String> wordList = new HashSet<String>();
		for(int i=0; i<wordLists.length; i++) {
			wordList.add(wordLists[i]);
		}
		System.out.println("wordLists: "+Arrays.toString(wordLists));
		System.out.println(obj.ladderLength("hit", "cog", wordList));
	}
}
