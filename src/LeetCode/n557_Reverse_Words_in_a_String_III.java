package LeetCode;

/*Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"*/

public class n557_Reverse_Words_in_a_String_III {
	public String reverseWords(String s) {
		if(s.length() == 0)
			return s;
		char[] ch = s.toCharArray();
		int last = 0;
		for(int i=0; i<ch.length; i++) {
			if(ch[i] == ' ') {					//' ' not " "
				reverse(ch, last, i-1);
				last = i + 1;					//i + 1 not i only
			}
/*			if(i == ch.length-1)				//handle last word with no space
				reverse(ch, last, i);*/
		}
		reverse(ch, last, ch.length-1);			//same as 10ms
		
		return new String(ch);
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
		System.out.println(obj.reverseWords(s));
	}
}
