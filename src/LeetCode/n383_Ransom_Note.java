package LeetCode;

/*Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will 
return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
Each letter in the magazine string can only be used once in your ransom note.*/
//canConstruct("a", "b") -> false
//canConstruct("aa", "ab") -> false
//canConstruct("aa", "aab") -> true

public class n383_Ransom_Note {
	//sol1
	public boolean canConstruct(String ransomNote, String magazine) {
		byte[] b = new byte[magazine.length()];
		boolean ret = true;

		for(int i=0; i<ransomNote.length(); i++) {
			boolean found = false;
			char c = ransomNote.charAt(i);
			for(int j=0; j<magazine.length(); j++) {
				if(b[j] == 0 && magazine.charAt(j) == c) {
					b[j]++; 
					found = true;
					break;							//break, go to check next magazine char
				}
			}
			if(!found) {
				ret = false;
				break;								//use this 'break' can save the time, cuz not find in the magazine
			}
		}
		return ret;
	}
	//sol2 best sol
	public boolean canConstruct2(String ransomNote, String magazine) {
		int[] alph = new int[26];
		for(int i=0; i<magazine.length(); i++) {
			 alph[magazine.charAt(i)-'a']++;
		}
		for(int j=0; j<ransomNote.length(); j++) {
			if(--alph[ransomNote.charAt(j)-'a'] < 0)		//F: --first
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		n383_Ransom_Note obj = new n383_Ransom_Note();
		System.out.println(obj.canConstruct("aa", "aab"));	//true
		System.out.println(obj.canConstruct("aa", "ab"));	//false
		System.out.println(obj.canConstruct2("aa", "aab"));	//true
		System.out.println(obj.canConstruct2("aa", "ab"));	//false
	}
}
