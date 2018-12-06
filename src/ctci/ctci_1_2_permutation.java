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
	
	public static void main (String args[]) {
		ctci_1_2_permutation obj = new ctci_1_2_permutation();
		System.out.println(obj.permutation("dog", "god"));
	}

}
