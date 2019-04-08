package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Input: "hello"
Output: "holle"

Example 2:
Input: "leetcode"
Output: "leotcede"

Note:
The vowels does not include the letter "y".
 */

public class n345_Reverse_Vowels_of_a_String {
	//!!! reverse first and last vowels(a,e,i,o,u), and so on...
	
	public String reverseVowels(String s) {
		List<Character> list = new ArrayList<Character>();
		list.add('a');
		list.add('e');
		list.add('i');
		list.add('o');
		list.add('u');
		list.add('A');
		list.add('E');
		list.add('I');
		list.add('O');
		list.add('U');

		int start=0;
		int end=s.length()-1;
		char[] ch = s.toCharArray();	//F: fill out the character array

		while(start < end) {
			if(!list.contains(s.charAt(start))) {
				start++;
				continue;		//F: continue not break!
			}
			if(!list.contains(s.charAt(end))) {
				end--;
				continue;
			}
			char tmp = ch[start];	//swap
			ch[start] = ch[end];
			ch[end] = tmp;

			start++;	//after swap, go to next
			end--;
		}
		return new String(ch);
	}

	public String reverseVowels2(String s) {
		int start=0;
		int end=s.length()-1;
		char[] ch = s.toCharArray();	//F: fill out the character array

		while(start < end) {			//Need this to avoid crossover
			if(!checkVowel(ch[start])) {
				start++;
				continue;		//F: continue not break!
			}
			if(!checkVowel(s.charAt(end))) {
				end--;
				continue;
			}
			char tmp = ch[start];	//swap
			ch[start] = ch[end];
			ch[end] = tmp;

			start++;	//after swap, go to next
			end--;
		}
		return new String(ch);
	}
	public boolean checkVowel(char c) {
		if ('a' == c || 'e' == c || 'i' == c || 'o' == c || 'u' == c
				|| 'A' == c || 'E' == c || 'I' == c || 'O' == c || 'U' == c) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		n345_Reverse_Vowels_of_a_String obj = new n345_Reverse_Vowels_of_a_String();
		System.out.println(obj.reverseVowels("hello"));
		System.out.println(obj.reverseVowels("leetcode"));
		System.out.println(obj.reverseVowels2("hello"));
		System.out.println(obj.reverseVowels2("leetcode"));
	}
}
