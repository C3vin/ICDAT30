package LeetCode;

import java.util.HashMap;
import java.util.HashSet;

//"code" -> False, "aab" -> True, "carerac" -> True.
public class n266_Palindrome_Permutation {
	//hashset +- e.g. LC 409
	public boolean canPermutePalindrome(String s) {
		HashSet<Character> set = new HashSet<Character>();
		for(int i=0; i<s.length(); i++) {
			if(set.contains(s.charAt(i))) {
				set.remove(s.charAt(i));
			} else {
				set.add(s.charAt(i));
			}
		}
		return set.size() <= 1;
	}
	//HashMap
	public boolean canPermutePalindrome2(String s) {
		int count = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<s.length(); i++) {
			if(map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i))+1);
			} else 
				map.put(s.charAt(i), 1);
		}
		
/*		for(int i=0; i<s.length(); i++) {
			if(map.get(s.charAt(i))%2 > 0) {
				count = count + map.get(s.charAt(i))%2; 
				map.put(s.charAt(i), map.get(s.charAt(i))%2);
			}
		}*/
		for(char k : map.keySet()) {
			count = count + map.get(k)%2;
		}
		
		return count <= 1;
	}

	
	
	public boolean canPermutePalindrome3(String s) {
		HashSet<Character> set = new HashSet<Character>();
		for(int i=0; i<s.length(); i++) {
			if(set.contains(s.charAt(i))) {
				set.remove(s.charAt(i));
			} else
				set.add(s.charAt(i));
		}
		return set.size() <= 1;
	}
	public static void main(String[] args) {
		n266_Palindrome_Permutation obj = new n266_Palindrome_Permutation();
		String s = "code";
		System.out.println(obj.canPermutePalindrome(s));
		System.out.println(obj.canPermutePalindrome3(s));
	}
}
