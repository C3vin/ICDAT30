package LeetCode;

import java.util.Arrays;

/*
Given an array of characters chars, compress it using the following algorithm:
Begin with an empty string s. For each group of consecutive repeating characters in chars:
If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.
After you are done modifying the input array, return the new length of the array.

Follow up:
Could you solve it using only O(1) extra space?

 
Example 1:
Input: chars = ["a","a","b","b","c","c","c"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".

Example 2:
Input: chars = ["a"]
Output: Return 1, and the first character of the input array should be: ["a"]
Explanation: The only group is "a", which remains uncompressed since it's a single character.

Example 3:
Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".

Example 4:
Input: chars = ["a","a","a","b","b","a","a"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","3","b","2","a","2"].
Explanation: The groups are "aaa", "bb", and "aa". This compresses to "a3b2a2". Note that each group is independent even if two groups have the same character.

Constraints:

1 <= chars.length <= 2000
chars[i] is a lower-case English letter, upper-case English letter, digit, or symbol.
 */
public class n443_String_Compression {
	public int compress(char[] chars) {
		int res = 0;
		int index = 0;
		
		while(index < chars.length) {
			int count = 0;
			
			char cur = chars[index];
			
			while(index < chars.length && chars[index] == cur) {
				count++;
				index++;
			}
			
			chars[res] = cur;
			res++;
			
			if(count != 1) {
				String req = count + "";
				for(char c : req.toCharArray()) {
					chars[res] = c;
					res++;
				}
			}
		}
		
		for(char c : chars) 
			System.out.print(c);
		
		return res;
	}
	
	public int compress2(char[] chars) {
		if(chars == null || chars.length == 0) {
			return 0;
		}
		
        int count = 1;//represent the times char appears;
        int res = 0;
        
        for(int i=1; i<=chars.length; i++) {
            if(i < chars.length && chars[i] == chars[i-1]) {	//avoid post processing for last char
                count++;
                
            } else {
                chars[res] = chars[i - 1];
                res++;
                
                if(count <= 1) {
                	continue;		//if count freq < 2, do not append; just continue; e.g. example 3, ["a","b","1","2"]
                }
                
                String s = String.valueOf(count);
                for(int k = 0; k<s.length(); k++) {
                    chars[res] = s.charAt(k);
                    res++;
                }
                
                count = 1;			//after append, need to reset to 1 !!!!!!!!!!
            }
        }
		
		for(char c : chars) 
			System.out.print(c);
		
        return res;
	}
	
	public static void main(String[] args) {
		n443_String_Compression obj = new n443_String_Compression();
//		System.out.println(obj.compress(new char[] {'a','a','b','b','c','c','c'}));
//		System.out.println(obj.compress(new char[] {'a'}));
		System.out.println(obj.compress(new char[] {'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
		System.out.println(obj.compress(new char[] {'a','a','a','b','b','a','a'}));
		
		System.out.println(obj.compress2(new char[] {'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
		System.out.println(obj.compress2(new char[] {'a','a','a','b','b','a','a'}));
	}
}
