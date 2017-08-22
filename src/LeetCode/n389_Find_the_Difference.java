package LeetCode;

import java.util.HashMap;

/*Input:
  s = "abcd"
  t = "abcde"
  Output:
  e*/
public class n389_Find_the_Difference {
	//hashmap
	public char findTheDifference(String s, String t) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<s.length(); i++) {
			if(!map.containsKey(s.charAt(i)))
				map.put(s.charAt(i), 1);
			else
				map.put(s.charAt(i), map.get(s.charAt(i))+1);
		}
		for(int i=0; i<t.length(); i++) {
			if(map.containsKey(t.charAt(i))) {
				map.put(t.charAt(i), map.get(t.charAt(i))-1);
				if(map.get(t.charAt(i)) < 0)
					return t.charAt(i);
			} else {
				return t.charAt(i);
			}

		}
		return 0;
	}
	//+-
	public char findTheDifference2(String s, String t) {
		char res = 0;
		for(int i=0; i<s.length(); i++) 
			res -= s.charAt(i);						//can't use res = res - s.charAT(i)
		
		for(int i=0; i<t.length(); i++) 
			res += t.charAt(i);
			
		return res;
	}
	public static void main(String[] args) {
		n389_Find_the_Difference obj = new n389_Find_the_Difference();
		String s = "abcd";
		String t = "abcde";
		System.out.println(obj.findTheDifference(s, t));
		System.out.println(obj.findTheDifference2(s, t));
	}
}
