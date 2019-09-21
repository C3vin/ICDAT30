package LeetCode;
/*
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
word1 and word2 may be the same and they represent two individual words in the list.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
Input: word1 = “makes”, word2 = “coding”
Output: 1

Input: word1 = "makes", word2 = "makes"
Output: 3
Note:
You may assume word1 and word2 are both in the list.
 */
public class n245_Shortest_Word_Distance_III {
	//cs
	//time:O(n) space:O(1)
	public int shortestWordDistance(String[] words, String word1, String word2) {
		int res = words.length;
		int a = -1;
		int b = -1;
		for(int i=0; i<words.length; i++) {
			if(words[i].equals(word1)) {
				a = i;
			}
			if(words[i].equals(word2)) {
				if(word1.equals(word2)) {
					a = b;
				}
				b = i;
			}
		}
		System.out.println(a + " : "+b);
		if(a != -1 && b != -1) {
			res = Math.min(res, Math.abs(a - b));
		}
		return res;
	}
	public static void main(String[] args) {
		n245_Shortest_Word_Distance_III obj = new n245_Shortest_Word_Distance_III();
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
	/*	System.out.println(obj.shortestWordDistance(words, "makes", "coding"));
		System.out.println(obj.shortestWordDistance(words, "makes", "makes"));*/
		System.out.println(obj.shortestWordDistance(new String[] {"a","a"}, "a", "a"));
	}
}
