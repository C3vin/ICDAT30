package LeetCode;

//Given s = "the sky is blue",
//return "blue is sky the".
public class n151_Reverse_Words_in_a_String {
	public String reverseWords(String s) {
		String[] str = s.split(" ");
		for(int i=0; i<str.length; i++) {
			System.out.println(i + ": "+str[i]);
		}
		StringBuilder sb = new StringBuilder();

		for(int i=str.length-1; i>=0; i--) {			//--i can't use i--, will miss last one 'e'
			if (!str[i].equals("")) {		//F: need this to handle ""
				sb.append(str[i]).append(" ");
			}
		}
		System.out.println(sb.length());
		return sb.length() == 0 ? "" : sb.substring(0, sb.length()-1);
	}
	
	public static void main(String[] args) {
		n151_Reverse_Words_in_a_String obj = new n151_Reverse_Words_in_a_String();
		String s = "   a   b ";			//" 1"
		System.out.println(obj.reverseWords(s));
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