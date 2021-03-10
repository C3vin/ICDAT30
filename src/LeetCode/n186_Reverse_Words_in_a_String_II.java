package LeetCode;
/*
Given an input string , reverse the string word by word. 

Example:
Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]

Note: 
A word is defined as a sequence of non-space characters.
The input string does not contain leading or trailing spaces.
The words are always separated by a single space.
Follow up: Could you do it in-place without allocating extra space?
 */
public class n186_Reverse_Words_in_a_String_II {
	public void reverseWords(char[] s) {
		if(s.length == 0) {
			return;
		}

		//1, reverse whole sentence 
		reverseArray(s, 0, s.length-1);						//["e","u","l","b"," ","s","i"," ","y","k","s"," ","e","h","t"]

		//2, reverse each word
		int start = 0;
		for(int i=0; i<s.length; i++) {
			if (s[i] == ' ') {	
				reverseArray(s, start, i-1);				//["b","l","u","e"," ","i","s"," ","s","k","y"," ","e","h","t"]
				start = i + 1;								//update start index
			}
		}
		//3, revere the last word, if there is only one word this will solve the corner case
		// also last word don't have ' ' so need this step to reverse last word
		reverseArray(s, start, s.length-1);					//["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"] reverse last str
		
		for(int i=0; i<s.length; i++)
			System.out.print(s[i]);
	}
	public void reverseArray(char[] s, int l, int r) {
		//swap
		while(l < r) {
			char temp = s[l];
			s[l] = s[r];
			s[r] = temp;
			
			l++;
			r--;
		}
	}
	public static void main(String[] args) {
		n186_Reverse_Words_in_a_String_II obj = new n186_Reverse_Words_in_a_String_II();
		obj.reverseWords(new char[] {'t','h','e',' ','s','k','y',' ','h','i','g','h'});		
		System.out.println();
		obj.reverseWords(new char[] {'h','i','!'});
	}
}
