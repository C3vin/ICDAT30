package LeetCode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

//Given s = "the sky is blue",
//return "blue is sky the".
public class n151_Reverse_Words_in_a_String {
	public String reverseWords(String s) {
		String[] str = s.split(" ");
		StringBuilder sb = new StringBuilder();

		for(int i=str.length-1; i>=0; i--) {			
			if (!str[i].isEmpty()) {		//F: need this to handle ""
				sb.append(str[i]).append(" ");
			}
		}
		return sb.length() == 0 ? "" : sb.substring(0, sb.length()-1);
	}
	
	public String reverseWords2(String s) {
		String[] str = s.split(" ");
		ArrayList<String> list = new ArrayList<String>();
		if(str == null ||str.length == 0) 
			return "";
		
		for(int i=0; i<str.length; i++) {
			if(!str[i].equals(" "))
				list.add(str[i]);
		}
		Collections.reverse(list);

		String ans = new String();
		for(int i=0; i<list.size(); i++)
			ans = ans + list.get(i) + " ";
		
		ans = ans + list.get(list.size()-1);
		return ans;
	}
	
	public static void main(String[] args) {
		n151_Reverse_Words_in_a_String obj = new n151_Reverse_Words_in_a_String();
		String s = " I am iron man";			//" 1"
		System.out.println(obj.reverseWords(s));
		System.out.println(obj.reverseWords2(s));
	}
}

//s="  I am iron man " s.split(" ")
/*0: 
  1: 
  2: I
  3: am
  4: iron
  5: man
  So, it will omit the latest and between words, but check the first and second one! 
*/