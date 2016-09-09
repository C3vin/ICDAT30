package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class n127_Word_Ladder {
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord == null || beginWord.isEmpty() || endWord == null || endWord.isEmpty())
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
