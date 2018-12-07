package ctci;

import java.util.Arrays;

/*
 * 
1.2 Check Permutation: Given two strings, write a method to decide if one is 
a permutation of the other. e.g. god , dog
 */
public class ctci_1_2_permutation {
	
	//sol#1 sort the string 
	private String sort(String str) {
		char[] content = str.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	
	public boolean permutation(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		
		return sort(s).equals(sort(t));		//just equals
	}
	
	//sol#2 
	public boolean permutation1(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		
		int[] res = new int[128];
		for(char c : s.toCharArray()) {
			System.out.println("s: "+c);
			res[c]++; 						//setup
			System.out.println("res_s: "+res[c]);
		}
		for(char c : t.toCharArray()) {
			System.out.println("t: "+c);
			res[c]--;
			System.out.println("res_t: "+res[c]);
			if(res[c]<0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main (String args[]) {
		ctci_1_2_permutation obj = new ctci_1_2_permutation();
		System.out.println(obj.permutation("dog", "god"));
		System.out.println(obj.permutation1("dogs", "godz"));
	}

}
