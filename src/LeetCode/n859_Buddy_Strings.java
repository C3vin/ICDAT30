package LeetCode;

/*
Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.
Example 1:
Input: A = "ab", B = "ba"
Output: true

Example 2:
Input: A = "ab", B = "ab"
Output: false

Example 3:
Input: A = "aa", B = "aa"
Output: true

Example 4:
Input: A = "aaaaaaabc", B = "aaaaaaacb"
Output: true

Example 5:
Input: A = "", B = "aa"
Output: false
 */
public class n859_Buddy_Strings {
	public boolean buddyStrings(String A, String B) {
		if(A.length() != B.length()) {
			return false;
		}

		int[] a = new int[26];
		int[] b = new int[26];
		int diff = 0;

		for(int i=0; i<A.length(); i++) {
			a[A.charAt(i) - 'a']++;
			b[B.charAt(i) - 'a']++;

			if(A.charAt(i) != B.charAt(i)) {
				diff++;
			}
		}
		
		for(int i=0; i<a.length; i++) {
			if(diff == 0 && a[i] > 1) {		//why > 1
				return true;
			}
			if(a[i] != b[i]) {
				return false;
			}
		}
		return diff == 2;
	}
	public static void main(String[] args) {
		n859_Buddy_Strings obj = new n859_Buddy_Strings();
		System.out.println(obj.buddyStrings("ab", "ba"));
		System.out.println(obj.buddyStrings("ab", "ab"));
		System.out.println(obj.buddyStrings("aaaaaaabc", "aaaaaaacb"));
		System.out.println(obj.buddyStrings("", "aa"));
	}
}
