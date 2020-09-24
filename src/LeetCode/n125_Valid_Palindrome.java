package LeetCode;

/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 */
public class n125_Valid_Palindrome {
	public boolean isPalindrome(String s) {
		if(s.length() == 0 || s == null || s.length() < 2) {
			return true;
		}
		
        int i=0;
        int j=s.length()-1;
        s = s.toLowerCase();		//F: change to low case, because 'A' == 'a' in this case
        
        while(i < j) {
        	char c1 = s.charAt(i);
        	char c2 = s.charAt(j);

        	if (!((c1 >= '0' && c1 <= '9') || (c1>='a' && c1 <= 'z'))) {		//skip special char, but need 0-9 because it is not special char!
				i++;
				continue;
			}
        	if (!((c2 >= '0' && c2 <= '9') || (c2>='a' && c2 <= 'z'))) {
				j--;
				continue;
			}

			if(c1 == c2) {
				i++;			//don't forget need to move next if they match! 
				j--;
			} else {
				return false;
			}
		}
        
		return true;
	}
	
	public static void main(String[] args) {
		n125_Valid_Palindrome obj = new n125_Valid_Palindrome();
		System.out.println(obj.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(obj.isPalindrome("0P "));
	}
}
