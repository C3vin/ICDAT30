package LeetCode;

import javax.swing.plaf.SliderUI;

/*
Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]
 */
public class n541_Reverse_String_II {
	public String reverseStr(String s, int k) {
		int len = s.length();
		char[] ch = s.toCharArray();
		
		for(int i=0; i<len; i = i+2*k) {	//need 2*k
			if(len - i < k) {
				reverse(ch, i, len);		//reserve all
			} else {
				reverse(ch, i, i+k); 		//i+k, e.g. (ch, 0, 2)-> abcd, so we can change only ch[0] and ch[1]
			}
		}
		return new String(ch);
	}
	public void reverse(char[] ch, int start, int end) {
		for(int i=start; i<(start+end)/2; i++) {			//F: need start + end to get the length, also need to / 2 !!!
			char tmp = ch[i];
			ch[i] = ch[end-1-i+start];	//Need +start. e.g. (ch,4,6) ch[end-1-i] -> ch[6-1-4] = ch[1]. So will swap the wrong item
			ch[end-1-i+start] = tmp;
		}
	}

	public String reverseStr2(String s, int k) {
		char[] ch = s.toCharArray();
		int len = s.length();
		
		for(int i=0; i<len; i=i+2*k) {
			if(len-i < k) {
				reverse2(ch, i, len);
			} else {
				reverse2(ch, i, i+2*k-1);
			}
		}
		return new String(ch);
	}
	private void reverse2(char[] ch, int s, int e) {
		for(int i=s; i<e; i++) {
			char tmp = ch[i];
			ch[i] = ch[i+1+s];
			ch[i+1+s] = tmp;
		}
	}
	public static void main(String[] args) {
		n541_Reverse_String_II obj = new n541_Reverse_String_II();
		String s = "abcdefg";
		System.out.println(obj.reverseStr(s, 2));
	}
}
