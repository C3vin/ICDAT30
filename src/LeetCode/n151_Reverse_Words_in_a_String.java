package LeetCode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/*
Given an input string, reverse the string word by word.

Example 1:
Input: "the sky is blue"
Output: "blue is sky the"

Example 2:
Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

Example 3:
Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 */
public class n151_Reverse_Words_in_a_String {
	//Good!
	public String reverseWords3(String s) {
        StringBuilder sb = new StringBuilder();
        if(s == null || s.length() == 0) {
            return sb.toString();
        }
        
        String[] str = s.split(" ");
        
        for(int i=str.length-1; i>=0; i--) {
            if(!str[i].isEmpty()) {           //"a good   example"
                sb.append(str[i]).append(" ");
            }
        }
        
        return sb.substring(0, sb.length()-1);  //sb.toString().trim(); <- I like trim()
	}
	
	public String reverseWords(String s) {
		String[] str = s.split(" ");				// " " 
		StringBuilder sb = new StringBuilder();

		for(int i=str.length-1; i>=0; i--) {			
			if (!str[i].isEmpty()) {				//F: need this to handle "", e.g. [, I, am, iron, man], this can handle str[0] (no need)
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
		Collections.reverse(list);				//Collections
		
		String ans = new String();
		for(int i=0; i<list.size(); i++)
			ans = ans + list.get(i) + " ";
		
		ans = ans + list.get(list.size()-1);	 
		return ans;
	}
	
	public static void main(String[] args) {
		n151_Reverse_Words_in_a_String obj = new n151_Reverse_Words_in_a_String();
		String s = " I am iron man";			//" I"
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