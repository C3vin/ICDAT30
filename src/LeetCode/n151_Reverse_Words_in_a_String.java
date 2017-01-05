package LeetCode;

//Given s = "the sky is blue",
//return "blue is sky the".
public class n151_Reverse_Words_in_a_String {
	public String reverseWords(String s) {
		String[] str = s.split(" ");
		StringBuilder sb = new StringBuilder();

		for(int i=str.length-1; i>=0; i--) {			//--i can't use i--, will miss last one 'e'
			if (!str[i].equals("")) {
				sb.append(str[i]).append(" ");
			}
		}
		return sb.length() == 0 ? "" : sb.substring(0, sb.length()-1);
	}
	
	public static void main(String[] args) {
		n151_Reverse_Words_in_a_String obj = new n151_Reverse_Words_in_a_String();
		String s = "the sky is blue";
		System.out.println(obj.reverseWords(s));
	}
}
