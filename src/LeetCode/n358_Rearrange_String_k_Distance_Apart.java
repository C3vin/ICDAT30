package LeetCode;

/*
Given a non-empty string s and an integer k, rearrange the string such that the same characters are at least distance k from each other.
All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".

Example 1:
Input: s = "aabbcc", k = 3
Output: "abcabc" 
Explanation: The same letters are at least distance 3 from each other.

Example 2:
Input: s = "aaabc", k = 3
Output: "" 
Explanation: It is not possible to rearrange the string.

Example 3:
Input: s = "aaadbbcc", k = 2
Output: "abacabcd"
Explanation: The same letters are at least distance 2 from each other.
 */
public class n358_Rearrange_String_k_Distance_Apart {
	public String rearrangeString(String s, int k) {
		if(s == null || s.length() == 0) {
			return s;
		}
		int[] count = new int[26];
		int[] valid = new int[26];
		for(char c : s.toCharArray()) {
			count[c - 'a']++;
		}
		StringBuilder res = new StringBuilder();
		for(int i=0; i<s.length(); i++) {
			int nextLetter = findNext(count, valid, i);
			if(nextLetter == -1) {
				return "";
			}
			res.append((char)('a' + nextLetter));
			valid[nextLetter] = i+k;
			count[nextLetter]--;
		}
		return res.toString();
	}
	//find next big count
	private int findNext(int[] count, int[] valid, int index) {
		int max = 0;
		int res = -1;
		for(int i=0; i<count.length; i++) {
			if(count[i] > max && valid[i] <= index) {
				res = i;
				max = count[i];
			}
		}
		return res;
	}
	public static void main(String[] args) {
		n358_Rearrange_String_k_Distance_Apart obj = new n358_Rearrange_String_k_Distance_Apart();
		System.out.println(obj.rearrangeString("aabbcc", 3));
		System.out.println(obj.rearrangeString("aaabc", 3));
		System.out.println(obj.rearrangeString("aaadbbcc", 2));
	}
}
