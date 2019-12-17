package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
    Set<String> dict;
    Map<String, List<String>> mutation = new HashMap<>();
    Map<String, Integer> distance = new HashMap<>();
    //https://github.com/awangdev/LintCode/blob/master/Java/Word%20Ladder%20II.java
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> rst = new ArrayList<>();
        dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return rst;

        prep(beginWord);
        //dfs(start, end, new ArrayList<>(), rst); // option1
        bfs(beginWord, endWord, rst); // option2
        return rst;
	}
	  //BFS/Prep to populate mutation and distance map.
    public void prep(String start) {
        //Init
        Queue<String> queue = new LinkedList<>();
        dict.add(start);
        queue.offer(start);
        distance.put(start, 0);
        for (String s : dict) {
            mutation.put(s, new ArrayList<>());
        }
        // process queue
        while(!queue.isEmpty()) {
            String str = queue.poll();
            List<String> list = transform(str);

            for (String s : list) {
                mutation.get(s).add(str);
                if (!distance.containsKey(s)) { // only record dist->s once, as shortest
                    distance.put(s, distance.get(str) + 1);
                    queue.offer(s);
                }
            }
        }
    }
    
    // Option2: bfs, bi-directional search
    public void bfs(String start, String end, List<List<String>> rst) {
        Queue<List<String>> queue = new LinkedList<>();
        List<String> list = new ArrayList<>();
        list.add(end);
        queue.offer(new ArrayList<>(list));
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                list = queue.poll();
                String str = list.get(0);
                
                for (String s : mutation.get(str)) {//All prior-mutation sources
                    list.add(0, s);
                    if (s.equals(start)) {
                        rst.add(new ArrayList<>(list));
                    } else if (distance.containsKey(s) && distance.get(str) - 1 == distance.get(s)) {
                        //Only pick those that's 1 step away: keep minimum steps for optimal solution
                        queue.offer(new ArrayList<>(list));
                    }
                    list.remove(0);
                }
                size--;
            }
        }
    }
    //Generate all possible mutations for word. Check against dic and skip word itself.
    private List<String> transform(String word) {
        List<String> candidates = new ArrayList<>();
        StringBuffer sb = new StringBuffer(word);
        for (int i = 0; i < sb.length(); i++) {
            char temp = sb.charAt(i);
            for (char c = 'a'; c <= 'z'; c++) {
                if (temp == c) continue;
                sb.setCharAt(i, c);
                String newWord = sb.toString();
                if (dict.contains(newWord)) {
                    candidates.add(newWord);
                }
            }
            sb.setCharAt(i, temp);//backtrack
        }    
        return candidates;
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
