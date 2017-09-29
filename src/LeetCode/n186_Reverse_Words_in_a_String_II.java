package LeetCode;
//Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
//The input string does not contain leading or trailing spaces and the words are always separated by a single space.
//Given s = "the sky is blue",
//return "blue is sky the". do in place
public class n186_Reverse_Words_in_a_String_II {
	public void reverseWords(char[] s) {
		if (s.length == 0) 
			return;

		//reverse whole sentence 
		reverseArray(s, 0, s.length-1);			

		//reverse subarray
		int last = 0;
		for (int i=0; i<s.length; i++) {
			if (s[i] == ' ') {
				reverseArray(s, last, i-1);	
				last = i + 1;					//update last
			}
		}
		//revere the last word, if there is only one word this will solve the corner case
		reverseArray(s, last, s.length-1);	
		
		for(int i=0; i<s.length; i++)
			System.out.print(s[i]);
	}
	public void reverseArray(char[] s, int l, int r) {
		//swap
		while (l < r) {
			char temp = s[l];
			s[l] = s[r];
			s[r] = temp;

			l++;
			r--;
		}
	}
	public static void main(String[] args) {
		n186_Reverse_Words_in_a_String_II obj = new n186_Reverse_Words_in_a_String_II();
		char[] s = {'t','h','e',' ','s','k','y',' ','h','i','g','h'};
		obj.reverseWords(s);
		
		System.out.println();
		char[] s1 = {'h','i','!'};
		//char[] s = {'a','b','c'};
		obj.reverseWords(s1);
	}
}
