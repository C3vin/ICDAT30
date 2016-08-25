package LeetCode;

public class n028_Implement_strStr {
	public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null) return -1;
		if(needle.length() > haystack.length()) return -1;
		//if(needle.equals(haystack)) return 0;
		
		for(int i=0; i<=haystack.length() - needle.length(); i++) {
			int j=0;
			while(j<needle.length() && haystack.charAt(i+j) == needle.charAt(j)) {
				j++;
			}
			if(j == needle.length()) return i;
		}
		
		return -1;
	}

	public static void main(String[] args) {
		n028_Implement_strStr obj = new n028_Implement_strStr();
		System.out.println(obj.strStr("21112341", "234"));
	}
}
