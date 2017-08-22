package LeetCode;

import java.util.HashMap;
import java.util.HashSet;

//Input: "abccccdd"
//Output: 7
//Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
public class n409_Longest_Palindrome {
	//hashmap
	public int longestPalindrome(String s) {
		int count = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<s.length(); i++) {
			if(map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i))+1);
			} else 
				map.put(s.charAt(i), 1);
		}
		for(int i=0; i<s.length(); i++) {
			if(map.get(s.charAt(i))/2 > 0) {
				count = count + map.get(s.charAt(i))/2; 
				map.put(s.charAt(i), map.get(s.charAt(i))%2);
			}
		}
		for(int x : map.values()) {
			if(x != 0) {
				return count * 2 + 1;
			}
		}
		return count * 2;
	}
	//hashset +-
	public int longestPalindrome2(String s) {
		int count = 0;
		HashSet<Character> set = new HashSet<Character>();
		for(int i=0; i<s.length(); i++) {
			if(set.contains(s.charAt(i))) {
				set.remove(s.charAt(i));			//need to remove so +-
				count++;
			} else {
				set.add(s.charAt(i));
			}
		}
		if(!set.isEmpty())
			return count * 2 + 1;
		
		return count * 2;
	}
	public static void main(String[] args) {
		n409_Longest_Palindrome obj = new n409_Longest_Palindrome();
		String s = "abccccdd";
		System.out.println(obj.longestPalindrome(s));
		System.out.println(obj.longestPalindrome2(s));
	}
}
