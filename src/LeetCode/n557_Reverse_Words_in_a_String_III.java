package LeetCode;

/*
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
Example 1:
Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Example 2:
Input: s = "God Ding"
Output: "doG gniD"
 */

public class n557_Reverse_Words_in_a_String_III {
	public String reverseWords2(String s) {
		String[] str = s.split(" ");

		StringBuilder sb = new StringBuilder();

		for(int i=0; i<str.length; i++) {
			char[] c = str[i].toCharArray();
			reverseString(c);						//LC344
			sb.append(c).append(" ");    

		}

		return sb.substring(0, sb.length()-1);      //sb.toString().trim();
	}

	//LC344. Reverse String
	public void reverseString(char[] s) {
		int left = 0;
		int right = s.length-1;

		while(left < right) {
			char tmp = s[left];
			s[left] = s[right];
			s[right] = tmp;

			left++;
			right--;
		}
	}

	public String reverseWords(String s) {
		if(s.length() == 0) {
			return s;
		}

		char[] ch = s.toCharArray();			//Need this, after same as LC 186

		int last = 0;
		for(int i=0; i<ch.length; i++) {
			if(ch[i] == ' ') {					//' ' not " "
				reverse(ch, last, i-1);
				last = i + 1;					
			}
		}
		reverse(ch, last, ch.length-1);			//last, not 0

		return new String(ch);					//new String
	}
	private void reverse(char[] ch, int l, int r) {
		while(l < r) {
			char tmp = ch[l];
			ch[l] = ch[r];
			ch[r] = tmp;

			l++;
			r--;
		}
	}
	public static void main(String[] args) {
		n557_Reverse_Words_in_a_String_III obj = new n557_Reverse_Words_in_a_String_III();
		String s = "Let's take LeetCode contest";
		System.out.println(s + "\n" +obj.reverseWords(s));
	}
}
