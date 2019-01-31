package LeetCode;

//Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
//Input: "aba"  Output: True
//Input: "abca" Output: True, Explanation: You could delete the character 'c'.
public class n680_Valid_Palindrome_II {
	public boolean validPalindrome(String s) {
		int i = 0;
		int j = s.length()-1;
		
		while(i<j && s.charAt(i) == s.charAt(j)) {
			i++;
			j--;
		}
		//case
		if(i == j) // F: Need this, e.g. 'aba'
			return true;
		
		if(isPalindrome(s, i+1, j) || isPalindrome(s, i, j-1))	//try left & right delete one char
			return true;
		
		return false;
	}
	private boolean isPalindrome(String s, int i, int j) {
		while(i < j) {
			if(s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		n680_Valid_Palindrome_II obj = new n680_Valid_Palindrome_II();
		System.out.println(obj.validPalindrome("aba"));
		System.out.println(obj.validPalindrome("abca"));
		System.out.println(obj.validPalindrome("aaaba"));
		System.out.println(obj.validPalindrome("abcda"));
	}
}
