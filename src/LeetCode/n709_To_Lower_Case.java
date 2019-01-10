package LeetCode;

public class n709_To_Lower_Case {
	public static String toLowerCase(String str) {
		char[] ch = str.toCharArray();
		for(int i=0; i<str.length(); i++) {
			if(ch[i] >= 'A' && ch[i] <= 'Z') {
				ch[i] = (char) (ch[i] - 'A' + 'a');
			}
		}
		return new String(ch);
	}
	public static void main(String[] args) {
		System.out.println(toLowerCase("Hello"));
		System.out.println(toLowerCase("here"));
		System.out.println(toLowerCase("LOVELY"));
	}
}
