package LeetCode;

/*
Given two strings s and t, determine if they are both one edit distance apart.
Note: 
There are 3 possiblities to satisify one edit distance apart:
Insert a character into s to get t
Delete a character from s to get t
Replace a character of s to get t

Example 1:
Input: s = "ab", t = "acb"
Output: true
Explanation: We can insert 'c' into s to get t.

Example 2:
Input: s = "cab", t = "ad"
Output: false
Explanation: We cannot get t from s by only one step.

Example 3:
Input: s = "1203", t = "1213"
Output: true
Explanation: We can replace '0' with '1' to get t.
 */
public class n161_One_Edit_Distance {
	/*
     i                           i
S: a c d      replace       S: a b d
T: a b c d   --------->     T: a b c d    --->  "d" != "cd", no good
     j                           j
now we try to insert T(j) to S(i) and we get:

     i                           i
S: a c d      insert        S: a b c d
T: a b c d   --------->     T: a b c d    --->  "cd" == "cd", viola!
     j                           j	 
To keep the code simple, we make s is always shorter than t, so we don't need to try deletion.	 
	 */
	public boolean isOneEditDistance(String s, String t) {
		if(s == null || t == null) {
			return false;
		}

		//handle "acbe", "acb" case
		if(s.length() > t.length()) {
			return isOneEditDistance(t, s);
		}
		
		int i=0; 
		int j=0;
		while(i<s.length() && j<t.length()) {
			if(s.charAt(i) != t.charAt(i)) {
				//replace, insert
				return (s.substring(i+1).equals(t.substring(j+1)) || (s.substring(i).equals(t.substring(j+1))));
			}
			i++;
			j++;
		}
		return t.length() - j == 1;
	}
	public static void main(String[] args) {
		n161_One_Edit_Distance obj = new n161_One_Edit_Distance();
		System.out.println(obj.isOneEditDistance("acbe", "acb"));
	}
}
