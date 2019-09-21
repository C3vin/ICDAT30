package LeetCode;
/*
Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list. Your method will be called repeatedly many times with different parameters. 

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3

Input: word1 = "makes", word2 = "coding"
Output: 1
Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class n244_Shortest_Word_Distance_II {
	
	HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
	
	//cs
	//space: O(n)
	public n244_Shortest_Word_Distance_II(String[] words) {
		for(int i=0; i<words.length; i++) {
			List<Integer> list = new ArrayList<Integer>();
			if(map.containsKey(words[i])) {
				list = map.get(words[i]);
				list.add(i);
				map.put(words[i], list);
			} else {
				list.add(i);
				map.put(words[i], list);
			}
		}
		//{makes=[1, 4], practice=[0], perfect=[2], coding=[3]}
	}
	//time:O(n*m)
	public int shortest(String word1, String word2) {
		List<Integer> l1 = map.get(word1);
		List<Integer> l2 = map.get(word2);
		int res = Integer.MAX_VALUE;
		for(int w1 : l1) {
			for(int w2 : l2) {
				res = Math.min(res, Math.abs(w1-w2));
			}
		}
		return res;
	}
	
	//time:O(n+m)
	public int shortest2(String word1, String word2) {
		List<Integer> l1 = map.get(word1);
		List<Integer> l2 = map.get(word2);
		int res = Integer.MAX_VALUE;
		int a = 0;
		int b = 0;
		
		while(a < l1.size() && b < l2.size()) {
			res = Math.min(res, Math.abs(l1.get(a) - l2.get(b)));
			if(l1.size() < l2.size()) {
				a++;
			} else {
				b++;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		n244_Shortest_Word_Distance_II obj = new n244_Shortest_Word_Distance_II(words);
		System.out.println(obj.map.toString());
		System.out.println(obj.shortest("coding", "practice"));
		System.out.println(obj.shortest("makes", "coding"));
	}
}
