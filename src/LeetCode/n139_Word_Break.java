package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class n139_Word_Break {
	public boolean wordBreak(String s, Set<String> wordDict) {
		/*		boolean[] t = new boolean[s.length()+1];
		t[0] = true; //set first to be true, why?
		//Because we need initial state

		for(int i=0; i<s.length(); i++){
			//should continue from match position
			if(!t[i]) 
				continue;

			System.out.println("@@");
			for(String a: wordDict){
				int len = a.length();
				int end = i + len;
				if(end > s.length())
					continue;

				if(t[end]) continue;

				if(s.substring(i, end).equals(a)){
					t[end] = true;
				}
			}
		}
		return t[s.length()];*/

		//code ganker sol
		if(s==null || s.length()==0)  
			return true;  
		boolean[] res = new boolean[s.length()+1];  //why need +1? cuz res[0]
		res[0] = true;  
		for(int i=0; i<s.length(); i++)  {  		//F: not <=
			StringBuilder str = new StringBuilder(s.substring(0,i+1));  
			System.out.println(str);
			for(int j=0; j<=i; j++)  {  			//Need <=
				if(res[j] && wordDict.contains(str.toString()))  {  //F: Need res[j] true
					res[i+1] = true;  
					break;  
				}  
				str.deleteCharAt(0);  //delete the first element and check rest
			}  
		}  
		return res[s.length()];  
	}

	public static void main(String[] args) {
		n139_Word_Break obj = new n139_Word_Break();
		String s = "leetcode";
		Set<String> wordDict = new HashSet<String>(Arrays.asList("leet", "code"));
		System.out.println(obj.wordBreak(s, wordDict));
	}
}
