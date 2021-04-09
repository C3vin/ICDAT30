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
	 public List<String> restoreIpAddresses4(String s) {
	        List<String> res = new ArrayList<String>();
	        String path = "";
	        int start = 0;
	        int count = 0;
	        
	        helper(s, path, res, count, start);
	        
	        return res;
	    }
	    
	    private void helper(String s, String path, List<String> res, int count, int start) {
	        if(count == 4) {
	            if(start == s.length()) {
	                res.add(path.substring(0, path.length()-1));
	            }
	            
	            return;
	        }
	        
	        for(int i=start+1; i<=s.length(); i++) {            //must <= ,cuz +1
	            if(isValid4(s.substring(start, i))) {
	                helper(s, path+s.substring(start, i)+".", res, count+1, i);
	            }
	        }
	    }
	    
	    private boolean isValid4(String s) {
	        if(s.startsWith("0") && !s.equals("0")) {           //need to ignore 0 for false
	            return false;
	        }
	        
	        return s.length() < 4 && 0 <=Integer.valueOf(s) && Integer.valueOf(s) < 256;
	    }
	    
	
	
	
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
	
	public List<String> restoreIpAddresses3(String s) {
		List<String> res = new ArrayList<String>();
		dfs3(s, 0, "", 0, res);
		return res;
	}
	private void dfs3(String s, int idx, String tmp, int count, List<String> res) {
		if(count > 4) {
			return;
		}
		if(count == 4 && idx == s.length()) {
			res.add(tmp.substring(0, tmp.length()-1));			//the reason is [255.255.11.135., 255.255.111.35.]
			return;
		}
		
		for(int i=1; i<4; i++) {								//i=1, cuz need for idx
			if(idx+i > s.length()) {							
				break;											//must have, otherwise will out of range
			}
			String sub = s.substring(idx, idx+i);
			if((sub.startsWith("0") && sub.length() > 1) || (i == 3 && Integer.parseInt(sub) > 255)) {
				continue;
			}
			dfs3(s, idx+i, tmp+sub+".", count+1, res);			//idx + i not +1
		}
	}
	
	public static void main(String[] args) {
		n093_Restore_IP_Addresses obj = new n093_Restore_IP_Addresses();
		String s = "25525511135";
		System.out.println(obj.restoreIpAddresses4(s));
		
		System.out.println(obj.restoreIpAddresses(s));
		System.out.println(obj.restoreIpAddresses2(s));
		System.out.println(obj.restoreIpAddresses3(s));
	}
}
