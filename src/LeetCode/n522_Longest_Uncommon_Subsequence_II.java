package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//The input will be a list of strings, and the output needs to be the length of the longest uncommon subsequence. If the longest uncommon subsequence doesn't exist, return -1.
//"aba", "cdc", "eae", output = 3
public class n522_Longest_Uncommon_Subsequence_II {
	//Brute Force
	public int findLUSlength(String[] strs) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		int number = 1;
		for(int i=0; i<strs.length; i++) {
			for(String s : getSubseqs(strs[i])) {
				if(map.containsKey(s)) {
					map.put(s, map.get(s)+1);
				} else {
					map.put(s, number);
				}
			}
			/*			if(map.containsKey(strs[i])) {
				map.put(strs[i], map.get(strs[i])+1);
			} else {
				map.put(strs[i], number);
			}*/
		}
		int res = -1;
		for (String s: map.keySet()) {
			if (map.get(s) == 1)
				res = Math.max(res, s.length());
		}
		return res;
	}

	public static Set<String> getSubseqs(String s) {
		Set<String> res = new HashSet<>();
		if (s.length() == 0) {
			res.add("");
			return res;
		}
		Set<String> subRes = getSubseqs(s.substring(1));
		res.addAll(subRes);
		for (String seq : subRes) 
			res.add(s.charAt(0) + seq);

		return res;
	}
	
	//Checking Subsequence //use this method!
	public int findLUSlength2(String[] strs) {
		int res = -1;
		for(int i=0; i<strs.length; i++) {
			int j;
			for(j=0; j<strs.length; j++) {
				if(i == j)
					continue;
				if(isSubsequence(strs[i], strs[j])) {
					break;
				}
			}
			if(j == strs.length)						//compare to latest value
				res = Math.max(res, strs[i].length());
		}
		return res;
	}
	private boolean isSubsequence(String s, String t) {
		int j = 0;
		for(int i = 0; i < t.length() && j < s.length(); i++) {
			if(s.charAt(j) == t.charAt(i))
				j++;
		}
		return j == s.length();				//why use j, because need one flag outside for loop to determine if it move to latest one.
	}
	public static void main(String[] args) {
		n522_Longest_Uncommon_Subsequence_II obj = new n522_Longest_Uncommon_Subsequence_II();
		//String[] s = {"ADXCPY", "AXY"};
		//String[] s = {"aba", "cdc", "abc"};
		String[] s = {"aaa", "aaa", "aa"};		//return -1
		//System.out.println(obj.findLUSlength(s));
		System.out.println(obj.findLUSlength2(s));
	}
}
