package LeetCode;

/*
Implement strStr().
Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:
Input: haystack = "hello", needle = "ll"
Output: 2

Example 2:
Input: haystack = "aaaaa", needle = "bba"
Output: -1

Clarification:
What should we return when needle is an empty string? This is a great question to ask during an interview.
For the purpose of this problem, we will return 0 when needle is an empty string. 
This is consistent to C's strstr() and Java's indexOf().
 */
public class n028_Implement_strStr {
	//Substring: Linear Time Slice
	public int strStr(String haystack, String needle) {
		int hlen = haystack.length();
		int nlen = needle.length();
		
		for(int i=0; i<hlen-nlen+1; i++) {
			if(haystack.substring(i, i+nlen).equals(needle)) {
				return i;
			}
		}
		
		return -1;
	}

	//BM (Boyer-Moore)
	public int strStrBM(String haystack, String needle) {
		int hlen = haystack.length();
		int nlen = needle.length();
		int[] jump = new int[256];  // hashmap char-> index, assume ASCII
		for(int i=0; i<jump.length; i++) {
			jump[i]=-1;
		}
		for(int i=0; i<nlen; i++) {
			jump[needle.charAt(i)] = i; // index of last occurrence
		}
		int skip=0;
		for(int i=0; i<hlen-nlen+1; i+=skip) { // !!! not i<hlen 
			skip=0;
			for(int j=nlen-1; j>=0; j--) {
				if(haystack.charAt(i+j)!=needle.charAt(j)) {
					skip =Math.max( 1, j-jump[haystack.charAt(i+j)] );    // max is j+1, min is 1 (do not allow <0);
					break;
				}
			}
			if(skip==0) return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		n028_Implement_strStr obj = new n028_Implement_strStr();
		System.out.println(obj.strStr("111234", "1234"));
		System.out.println(obj.strStrBM("111234", "1234"));
		System.out.println(obj.strStr("hello", "ll"));
		System.out.println(obj.strStrBM("hello", "ll"));
	}
}
