package LeetCode;

public class n521_Longest_Uncommon_Subsequence_I {
	public int findLUSlength(String a, String b) {
		if(a.length() != b.length())
			return Math.max(a.length(), b.length());
		else if(!a.equals(b)) {
			return a.length();			//or b.length()
		} else 
			return -1;
	}
	public static void main(String[] args) {
		n521_Longest_Uncommon_Subsequence_I obj = new n521_Longest_Uncommon_Subsequence_I();
		String a = "aba"; 
		String b = "cdc";
		System.out.println(obj.findLUSlength(a, b));
	}
}
