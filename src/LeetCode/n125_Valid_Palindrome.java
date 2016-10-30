package LeetCode;

public class n125_Valid_Palindrome {
	public boolean isPalindrome(String s) {
		if(s.length() == 0 || s == null || s.length() < 2) return true;
        int len = s.length();
        int i=0;
        int j=len-1;

        while(i < j) {
        	char c1 = s.charAt(i);
        	char c2 = s.charAt(j);

        	if (!((c1 >= '0' && c1 <= '9') || (c1>='a' && c1 <= 'z') || (c1>='A' && c1 <= 'Z'))) {
				i++;
				continue;
			}
        	if (!((c2 >= '0' && c2 <= '9') || (c2>='a' && c2 <= 'z') || (c2>='A' && c2 <= 'Z'))) {
				j--;
				continue;
			}

			if(c1>='A' && c1<='Z') {
				c1 += 'a' - 'A';
			}
			if(c2>='A' && c2<='Z') {
				c2 += 'a' - 'A';
			}
			if(c1 == c2) {
				i++;
				j--;
			} else 
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		n125_Valid_Palindrome obj = new n125_Valid_Palindrome();
		System.out.println(obj.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(obj.isPalindrome("ab"));
	}
}