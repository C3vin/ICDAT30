package LeetCode;

/*
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3

Input: word1 = "makes", word2 = "coding"
Output: 1
Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class n243_Shortest_Word_Distance {
	//cs
	//time:O(n)
	public int shortestDistance(String[] words, String word1, String word2) {
		int res = words.length;
		int a = -1;
		int b = -1;
		for(int i=0; i<words.length; i++) {
			if(words[i].equals(word1)) {
				a = i;
			} else if(words[i].equals(word2)){
				b = i;
			}
			if(a != -1 && b != -1) {
				res = Math.min(res, Math.abs(a-b));
			}
		}
		return res;
	}

	//cs
	//time:O(n^2) space:O(1)
	public int shortestDistance2(String[] words, String word1, String word2) {
		int res = words.length;
		for(int i=0; i<words.length; i++) {
			if(words[i].equals(word1)) {
				for(int j=0; j<words.length; j++) {
					if(words[j].equals(word2)) {
						res = Math.min(res, Math.abs(i-j));
					}
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		n243_Shortest_Word_Distance obj = new n243_Shortest_Word_Distance();
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		System.out.println(obj.shortestDistance(words, "coding", "practice"));
		System.out.println(obj.shortestDistance(words, "makes", "coding"));
		System.out.println(obj.shortestDistance2(words, "coding", "practice"));
		System.out.println(obj.shortestDistance2(words, "makes", "coding"));
	}
}
