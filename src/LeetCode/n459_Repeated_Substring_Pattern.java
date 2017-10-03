package LeetCode;

//Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. 
//You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
//Input: "abab" Output: True, Explanation: It's the substring "ab" twice.
//Input: "aba" Output: False
//Input: "abcabcabcabc" Output: True, Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
public class n459_Repeated_Substring_Pattern {
	public boolean repeatedSubstringPattern(String str) {
		int strLen = str.length();
		
		for(int i=strLen/2; i>=1; i--) {			//F: >= 1, cuz strLen%i == 0 will failed 
			if(strLen%i == 0) {
				int cp = strLen/i;
				String subStr = str.substring(0, i);
				StringBuilder sb = new StringBuilder();
				//copy cp times
				for(int j=0; j<cp; j++) {
					sb.append(subStr);
				}
				System.out.println(sb.toString());
				if(sb.toString().equals(str)) 
					return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		n459_Repeated_Substring_Pattern obj = new n459_Repeated_Substring_Pattern();
		//System.out.println(obj.repeatedSubstringPattern("abab"));
		System.out.println(obj.repeatedSubstringPattern("ababc"));
		//System.out.println(obj.repeatedSubstringPattern("abcabcabcabc"));
		//System.out.println(obj.repeatedSubstringPattern("aaa"));
	}
}
