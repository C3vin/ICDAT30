package LeetCode;

/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
If the last word does not exist, return 0.
Note: A word is defined as a character sequence consists of non-space characters only.

Example:
Input: "Hello World"
Output: 5

 */
public class n058_Length_of_Last_Word {
	public int lengthOfLastWord(String s) {
		s = s.trim();
		int count = 0;
		boolean flag = true;
		for(int i=s.length()-1; i>= 0; i--) {
			if(s.charAt(i) != ' ' && flag == true) {
				count++;
			} else 
				flag = false;
		}
		return count;
	}
	
	//sol2
	public int lengthOfLastWord2(String s) {
		String[] str = s.split(" ");
		
		if(str == null || str.length == 0)
			return 0;
		
		return str[str.length-1].length();		//get last string value length 
	}
	
	public static void main(String[] args) {
		n058_Length_of_Last_Word obj = new n058_Length_of_Last_Word();
		System.out.println(obj.lengthOfLastWord("hello world"));
		System.out.println(obj.lengthOfLastWord("hello world Z "));
		System.out.println(obj.lengthOfLastWord2("hello world"));
		System.out.println(obj.lengthOfLastWord2("hello world Z "));
	}
}
