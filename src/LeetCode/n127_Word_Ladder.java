package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
			for(int i=0;i<cur.length();i++) {  
				char[] charCur = cur.toCharArray();
				for(char c='a';c<='z';c++)  {  
					charCur[i] = c;  
					String temp = new String(charCur);  
					if(temp.equals(endWord))   				//Need temp because we need to use String to compare with endWord  
						return level+1;  
					if(wordList.contains(temp) && !visited.contains(temp)) {  
						curNum++;  							
						queue.offer(temp);  
						visited.add(temp);  
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

	public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
		if(!wordList.contains(endWord)) {	//make sure endWord is in the list
            return 0;
        }
		
		int level = 0;
		Queue<String> queue = new LinkedList<String>();
		queue.offer(beginWord);
		
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			for(int i=0; i<levelSize; i++) {
				String cur = queue.poll();
				if(cur.equals(endWord)) {
					return level+1;
				}
				
				for(int j=0; j<cur.length(); j++) {
					char[] word = cur.toCharArray();
					for(char ch='a'; ch<'z'; ch++) {
						word[j] = ch;
						String check = new String(word);
						if(!check.equals(cur) && wordList.contains(check)) {
							queue.add(check);
							wordList.remove(check);
						}
					}
				}
			}
			level++;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		n127_Word_Ladder obj = new n127_Word_Ladder();
		String[] wordLists=  {"hot","dot","dog","lot","log", "cog"};
		Set<String> wordList = new HashSet<String>();
		for(int i=0; i<wordLists.length; i++) {
			wordList.add(wordLists[i]);
		}
		System.out.println("WordLists: "+Arrays.toString(wordLists) + "\nFirst: "+"hit" + " \nEnd: "+"cog");
		System.out.println(obj.ladderLength("hit", "cog", wordList));
		
		List<String> wordList1 = new ArrayList<String>();
		wordList1.add("hot");
		wordList1.add("dot");
		wordList1.add("dog");
		wordList1.add("lot");
		wordList1.add("log");
		wordList1.add("cog");
		System.out.println(obj.ladderLength2("hit", "cog", wordList1));
	}
}
