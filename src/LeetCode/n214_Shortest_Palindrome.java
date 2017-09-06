package LeetCode;

//Given "aacecaaa", return "aaacecaaa".  Given "abcd", return "dcbabcd".
public class n214_Shortest_Palindrome {
	public String shortestPalindrome(String s) {
		int rightindex = 0;
		for(int i=0; i<s.length()/2+1; i++) {									//?? s.length()/2+1
			rightindex = helper(s, i, i, rightindex);	//odd case
			rightindex = helper(s, i, i+1, rightindex);	//even case
		}

		return new StringBuilder(s.substring(rightindex+1)).reverse()+s;
	}

	//need to return index
	private int helper(String s, int begin, int end, int rightindex) {
		while(begin >= 0 && end <= s.length()-1  && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		if(begin == -1) {
			return end-1;
		}
		return rightindex;
	}
	public static void main(String[] args) {
		n214_Shortest_Palindrome obj = new n214_Shortest_Palindrome();
		//String s = "aacecaaa";
		String s = "abcd";
		System.out.println(obj.shortestPalindrome(s));
	}
}
