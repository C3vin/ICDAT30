package LeetCode;
//Given s = "the sky is blue",
//return "blue is sky the". do in place
public class n186_Reverse_Words_in_a_String_II {
	public void reverseWords(char[] s) {
		if (s.length == 0) 
			return;

		reverseArray(s, 0, s.length-1);			//reverse all

		int last = 0;
		for (int i=0; i<s.length; i++) {
			if (s[i] == ' ') {
				reverseArray(s, last, i-1);		//reverse subarray
				last = i + 1;					//update last
			}
			/*if (i == s.length-1) {		//F: handle abc, hi!, no space value
				reverseArray(s, last, i);
		}*/
		reverseArray(s, last, s.length-1);	
	}
	for(int i=0; i<s.length; i++)
		System.out.println(s[i]);
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
	//char[] s = {'t','h','e',' ','s','k','y'};
	char[] s = {'h','i','!'};
	//char[] s = {'a','b','c'};
	obj.reverseWords(s);
}
}
