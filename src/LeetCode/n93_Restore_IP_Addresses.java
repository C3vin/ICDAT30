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
	public static void main(String[] args) {
		n93_Restore_IP_Addresses obj = new n93_Restore_IP_Addresses();
		String s = "25525511135";
		System.out.println(obj.restoreIpAddresses(s));
	}
}
