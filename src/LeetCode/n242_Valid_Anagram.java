package LeetCode;

public class n242_Valid_Anagram {
	public boolean isAnagram(String s, String t) {
		if(s.length() != t.length())
			return false;

		int[] list = new int[26];
		for(int i=0; i<s.length(); i++) {
			list[s.charAt(i) - 'a']++;
			list[t.charAt(i) - 'a']--;

		}
		for(int i: list) {
			if(i!=0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		n242_Valid_Anagram obj = new n242_Valid_Anagram();
		String s = "anagram"; 
		String t = "nagarad";
		System.out.println(obj.isAnagram(s, t));
	}
}
