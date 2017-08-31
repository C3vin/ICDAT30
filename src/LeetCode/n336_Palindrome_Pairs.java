package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Given words = ["abcd", "dcba", "lls", "s", "sssll"]
//Return [[0, 1], [1, 0], [3, 2], [2, 4]]
//The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
public class n336_Palindrome_Pairs {

	//Time Limit Exceeded, but I like it!
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		HashMap<Integer, String> map = new HashMap<Integer, String>();	//map no order, but we lock it's index.

		for(int i=0; i<words.length; i++) {
			map.put(i, words[i]);
		}
		for(int i=0; i<words.length; i++) {
			for(int j=0; j<words.length; j++) {
				if(j == i)
					continue;
				String tmp = map.get(i) + map.get(j);
				if(isPalindrome(tmp)) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(i);
					list.add(j);
					res.add(list);
				}
			}
		}
		return res;
	}

	private boolean isPalindrome(String tmp) {
		for(int i=0; i<tmp.length()/2; i++) {
			if(tmp.charAt(i) != tmp.charAt(tmp.length()-1-i))
				return false;
		}
		
		return true;
	}
	/*private boolean isPalindrome(String tmp) {
		int l=0;
		int r=tmp.length()-1;
		while(l < r) {
			if(tmp.charAt(l) != tmp.charAt(r)) 
				return false;
			l++;
			r--;
		}
		return true;
	}*/

	public static void main(String[] args) {
		n336_Palindrome_Pairs obj = new n336_Palindrome_Pairs();
		//String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
		String[] words = {"bat", "tab", "cat"};
		System.out.println(obj.palindromePairs(words));
	}
}
