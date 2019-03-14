package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:
Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]
 */
public class n093_Restore_IP_Addresses {
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<String>();
		dfs(s, 0, 4, "", res);
		return res;
	}
	//dfs
	private void dfs(String s, int start, int remains, String path, List<String> res) {
		if(remains == 0) {
			if(start == s.length()) {
				res.add(path.substring(1, path.length()));
				return;
			}
		}
		for(int len=1; len<=3 && start+len<=s.length(); len++) {
			String part = s.substring(start, start+len);
			int num = Integer.parseInt(part);
			if(num <= 255 && String.valueOf(num).equals(part)) {
				dfs(s, start+len, remains-1, path+"."+part, res);
			}
		}
	}

	public List<String> restoreIpAddresses2(String s) {
		List<String> res = new ArrayList<String>();
		String item = new String();
		if(s.length() <4 || s.length() >12) {
			return res;
		}

		dfs2(s, 0, item, res);
		return res;
	}
	//dfs
	private void dfs2(String s, int start, String item, List<String> res) {
		if(start == 3 && isValid(s)) {
			res.add(item + s);			 
			return;
		}
		for(int i=0; i<3 && i<s.length()-1; i++) {
			String substr = s.substring(0, i+1);				//to get (0,1)(0,2)(0,3)
			if(isValid(substr)) {
				String newS = s.substring(i+1, s.length());		//i+1 to get the new s
				dfs2(newS, start+1, item+substr+'.', res);
			}
		}
	}
	
	private boolean isValid(String s) {
		if(s.charAt(0) == '0') {
			return s.equals("0");		//cuz '001', '01' is invalid value
		}

		int num = Integer.parseInt(s);

		if(num<=255 && num >0) {
			return true;
		} else {
			return false;
		}
	}
	public static void main(String[] args) {
		n093_Restore_IP_Addresses obj = new n093_Restore_IP_Addresses();
		String s = "25525511135";
		System.out.println(obj.restoreIpAddresses(s));
		System.out.println(obj.restoreIpAddresses2(s));
	}
}
