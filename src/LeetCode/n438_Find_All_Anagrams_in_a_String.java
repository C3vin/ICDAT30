package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class n438_Find_All_Anagrams_in_a_String {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new LinkedList<Integer>();
		int slen = s.length();
		int plen = p.length();

		//record each character in p to target
		int[] target = new int[256];
		for(int i=0; i<plen; i++) {
			target[p.charAt(i)]++;
		}

	/*	for(int i=0; i<target.length; i++)
		System.out.println(i + " : " + target[i]);*/
		//two points, initialize count to p's length
		int left = 0;
		int right = 0;
		int count = plen;
		while(right < slen) {
			//move right everytime, if the character exists in p's target, decrease the count
	        //current target value >= 1 means the character is existing in p
			if(target[s.charAt(right++)]-- >= 1)
				count--;
			
/*			for(int i=0; i<target.length; i++)
				System.out.println(i + " : " + target[i]);*/
			if(count == 0)
				res.add(left);
			
			//if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
	        //++ to reset the hash because we kicked out the left
	        //only increase the count if the character is in p
			//the count >= 0 indicate it was original in the hash, cuz it won't go below 0
			if(right - left == plen && target[s.charAt(left++)]++ >= 0) {
				System.out.println(left + " : " + right);
				count++;
			}
		}

		return res;
	}

	public List<Integer> findAnagrams2(String s, String p) {
		List<Integer> res = new LinkedList<Integer>();
		int slen = s.length();
		int plen = p.length();

		//record each character in p to target
		int[] target = new int[256];
		for(int i=0; i<plen; i++) {
			target[p.charAt(i)]++;
		}

		int left = 0;
		int right = 0;
		int count = plen;
		while(right < slen) {
			if(target[s.charAt(right)] >= 1) {
				count--;
			}
			target[s.charAt(right)]--;
			right++;
			
			if(count == 0)
				res.add(left);
			
			if(right - left == plen) {
				if(target[s.charAt(left)] >= 0) {
					count++;
				}
				target[s.charAt(left)]++;
				left++;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		n438_Find_All_Anagrams_in_a_String obj = new n438_Find_All_Anagrams_in_a_String();

		String s = "cbaebabacd";
		String p = "abc";
		String s1 = "abab";
		String p1 = "ab";
		//System.out.println(obj.findAnagrams(s, p));		//[0, 6]
		//System.out.println(obj.findAnagrams(s1, p1));		//[0, 1, 2]
		System.out.println(obj.findAnagrams2(s1, p1));
	}
}
