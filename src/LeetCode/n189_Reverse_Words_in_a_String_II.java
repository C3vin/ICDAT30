package LeetCode;

public class n189_Reverse_Words_in_a_String_II {
	public void reverseWords(char[] s) {
		if (s.length == 0) return;

		reverse(s, 0, s.length);	//-1
		System.out.println(s);
		
		for(int last = 0, j=0; j<=s.length; j++) {
			if(j==s.length || s[j] == ' ') {
				reverse(s, last, j);	//i-1
				last = j + 1;
			}
		}
		System.out.println(s);
	}
	public void reverse(char[] s, int l, int r) {
				while(l<r) {
			char tmp = s[l];
			s[l] = s[r];
			s[r] = tmp;
			l++;
			r--;
		}
		/*for (int i = 0; i < (end - begin) / 2; i++) {

			char temp = s[begin + i];

			s[begin + i] = s[end - i - 1];

			s[end - i - 1] = temp;

		}*/
	}

	public static void main(String[] args) {
		n189_Reverse_Words_in_a_String_II obj = new n189_Reverse_Words_in_a_String_II();
		char[] s = "the sky is blue".toCharArray();
		//obj.reverseWords(s);
		char[] s1 = "h1!".toCharArray();
		obj.reverseWords(s1);
	}
}
