package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:
Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]
 */
public class n93_Restore_IP_Addresses {
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

	
	//http://www.voidcn.com/article/p-qrijogvv-hq.html
	//https://shmilyaw-hotmail-com.iteye.com/blog/2304783
	public List<String> restoreIpAddresses2(String s) {
		List<String> res = new ArrayList<String>();
		String item = new String();
		if(s.length() <4 || s.length() >12) {
			return res;
		}

		dfs2(s, 0, item, res);
		return res;
	}

	private void dfs2(String s, int start, String item, List<String> res) {
		if(start == 3 && isValid(s)) {
			System.out.println("@s: "+s);
			res.add(item + s);			//item + s?
			return;
		}
		for(int i=0; i<3 && i<s.length()-1; i++) {
			String substr = s.substring(0, i+1);
			if(isValid(substr)) {
				System.out.println("i: "+i+" sub: "+substr + " start: " + start + " item: " + item +" s:" +s);
				dfs2(s.substring(i+1, s.length()), start+1, item+substr+'.', res);
			}
		}
	}
	private boolean isValid(String s) {
		if(s.charAt(0) == '0') {
			return s.equals("0");
		}

		int num = Integer.parseInt(s);

		if(num<=255 && num >0) {
			return true;
		} else {
			return false;
		}
	}
	public static void main(String[] args) {
		n93_Restore_IP_Addresses obj = new n93_Restore_IP_Addresses();
		String s = "25525511135";
		//System.out.println(obj.restoreIpAddresses(s));
		System.out.println(obj.restoreIpAddresses2(s));
	}
}
