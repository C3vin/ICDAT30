package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". 
We can keep "shifting" which forms the sequence:
"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

Example:
Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
Output: 
[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
 */
public class n249_Group_Shifted_Strings {
	public List<List<String>> groupStrings(String[] strings) {
		//Wait! How do I mod a negative number like -45?
		//Mentor: Just like a positive number, so that -45 mod 26 = -19, but then you add 26 to make the result positive, 
		//so that -45 mod 26 = -19 + 26 = 7.

		List<List<String>> res = new ArrayList<List<String>>();
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();

		for(String s : strings) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<s.length(); i++) {
				int val = (s.charAt(i) - s.charAt(0) + 26) % 26;
				sb.append(val + " ");	//F: need " ", e.g. 2 22
			}

			String str = sb.toString();	//Need to convert to String.

			//this is same way LC 49
/*			char[] ch = s.toCharArray();		//convert string to ch array
			for(int i=0; i<s.length(); i++) {
				ch[i] = (char) ((s.charAt(i) - s.charAt(0) + 26) % 26);
			}
			String str = String.valueOf(ch);	//convert ch array to string
*/			
			if(!map.containsKey(str)) {
				List<String> tmp = new ArrayList<String>();
				map.put(str, tmp);
			}
			map.get(str).add(s);		//can't use else, because need to add all s.
		}
		for(String s : map.keySet()) {
			res.add(map.get(s));		//Tip: add to list using map.get(s) to get the value.
		}

		return res;
	}

	public static void main(String[] args) {
		n249_Group_Shifted_Strings obj = new n249_Group_Shifted_Strings();
		String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		System.out.println(obj.groupStrings(strings));
	}
}
