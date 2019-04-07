package LeetCode;

/*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
Input: ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Note:
All given inputs are in lowercase letters a-z.
 */
public class n014_longest_common_prefix {
	public String longestCommonPrefix(String[] strs) {
		if(strs==null || strs.length==0)
			return "";
		if(strs.length==1) 
			return strs[0];

		int minLen = strs[0].length();		        //Need this for the for loop, default minLen 

		//update the minLen
		for(int i=0; i<strs.length; i++) {
			if(minLen > strs[i].length())
				minLen = strs[i].length();
		}
		for(int i=0; i<minLen; i++){
			for(int j=0; j<strs.length-1; j++){		//why -1, cuz handle j+1 boundary 
				String s1 = strs[j];
				String s2 = strs[j+1];
				if(s1.charAt(i)!=s2.charAt(i)){		//buz we start from head to end, e.g. aaaaab, b=5
					return s1.substring(0, i);
				}
			}
		}
		//handle same value {c,c} or diff only one value {cxxx,cxx}, {cx,c} 
		return strs[0].substring(0, minLen);
	}

	//sol2
	public String longestCommonPrefix2(String[] strs) {
		if(strs == null || strs.length == 0) {
			return "";
		}

		String pre = strs[0];

		int i = 1;
		while(i < strs.length) {
			while(strs[i].indexOf(pre) != 0) {
				pre = pre.substring(0, pre.length()-1); //will cut last char
			}
			i++;
		}
		return pre;
	}

	public static void main(String[] args) {
		n014_longest_common_prefix obj = new n014_longest_common_prefix();
		System.out.println(obj.longestCommonPrefix(new String[] {"aaaaaaaae", "aaaaabyrrrrrr", "aaaaaew"}));
		System.out.println(obj.longestCommonPrefix(new String[] {"flower","flow","flight"}));
		System.out.println(obj.longestCommonPrefix(new String[] {"dog","racecar","car"}));
		System.out.println(obj.longestCommonPrefix(new String[] {"",""}));
		System.out.println(obj.longestCommonPrefix(new String[] {"cxxxx","c"}));

		System.out.println(obj.longestCommonPrefix2(new String[] {"cxxxx","c"}));
	}
}
