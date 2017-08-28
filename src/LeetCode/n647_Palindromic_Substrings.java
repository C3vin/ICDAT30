package LeetCode;

//Input: "aaa" Output: 6, Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
public class n647_Palindromic_Substrings {
	int count = 0;
	public int countSubstrings(String s) {
		for(int i=0; i<s.length(); i++) {
			helper(s, i, i);		//odd case	
			helper(s, i, i+1);		//even case
		}
		return count;
	}
	
	private void helper(String s, int begin, int end) {
		while(begin >= 0 && end <= s.length()-1 && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
			count++;			//use global val, because it will only count match val. e.g. abc will count once for each char.
		}
	}
	
	public static void main(String[] args) {
		n647_Palindromic_Substrings obj = new n647_Palindromic_Substrings();
		String s = "abc";
		System.out.println(obj.countSubstrings(s));
	}
}
