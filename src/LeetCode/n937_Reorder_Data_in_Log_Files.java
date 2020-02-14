package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  Then, either:

Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, 
with the identifier used in case of ties. The digit-logs should be put in their original order.

Return the final order of the logs.

Example 1:
Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 */
public class n937_Reorder_Data_in_Log_Files {
	//Amazon
	public String[] reorderLogFiles(String[] logs) {
		if(logs.length == 0) {		//no JAVA for String[] == null
			return logs;
		}
		HashMap<String,String> map = new HashMap<String, String>();
		List<String> letterLogs = new ArrayList<String>();
		List<String> digitLogs = new ArrayList<String>();

		for(String log : logs) {
			if(Character.isDigit(log.charAt(log.length()-1))) {
				digitLogs.add(log);
			} else {
				String value = log.substring(log.indexOf(" ")+1);
				String key = log.substring(0, log.indexOf(" "));
				letterLogs.add(value);
				map.put(key, value);
			}
		}
		Collections.sort(letterLogs);
		System.out.println(map);
		String[] res = new String[logs.length];

		StringBuilder sb = new StringBuilder();
		for(int i=0; i<letterLogs.size(); i++) {
			sb = new StringBuilder(map.get(letterLogs.get(i)));
			sb.append(" "+ letterLogs.get(i) + " ");
			res[i] = sb.toString();
		}
		//System.out.println("#size: "+res.length + " : " + res[res.length-1]);
		
		for(int i=0; i<res.length; i++) {
			if(res[i] == null) {
				for(int j=0; j<digitLogs.size(); j++) {
					res[i] = digitLogs.get(j);
					i++;
				}
			}
		}

		//https://www.itread01.com/content/1543067163.html   ISSUE with same letterLog
		//https://leetcode.com/problems/reorder-data-in-log-files/discuss/193872/Java-Nothing-Fancy-15-lines-2ms-all-clear.
		for(String s : res) {
			System.out.println(s);
		}
		//separateLettersDigits(logs, letterLogs, digitLogs);
		//sortLetterLogs(letterLogs);
		//return generateOutput(letterLogs, digitLogs);
		return res;
	}
	//"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"
	private void separateLettersDigits(String[] logs, List<String> letterLogs, List<String> digitLogs) {
		for(String log : logs) {
			if(Character.isDigit(log.charAt(log.length()-1))) {
				digitLogs.add(log);
			} else {
				letterLogs.add(log.substring(log.indexOf(" ")+1));
				//letterLogs.add(log);
			}
		}
	}
	private void sortLetterLogs(List<String> letterLogs) {
		Collections.sort(letterLogs);
		/*Collections.sort(letterLogs, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String s1 = o1.substring(o1.indexOf(" ")+1);
				String s2 = o2.substring(o2.indexOf(" ")+1);

				return s1.equals(s2) ? o1.compareTo(o2) : s1.compareTo(s2);
			}
		});*/
	}

	public String[] reorderLogFiles2(String[] logs) {
		HashMap<String,String> map = new HashMap<>();
		ArrayList<String> arr = new ArrayList<>();
		ArrayList<String> numarr = new ArrayList<>();
		for(int i = 0;i < logs.length;i++){
			for(int j = 0;j < logs[i].length();j++){
				if(logs[i].charAt(j) == ' '){
					String flag = logs[i].substring(0,j);
					String key = logs[i].substring(j+1,logs[i].length());
					if(key.charAt(0) >= '0' && key.charAt(0) <= '9' ){
						numarr.add(key);
					}else{
						arr.add(key);
					}
					map.put(key,flag);
					break;
				}
			}
		}
		System.out.println("X: "+map);
		String[] ans = new String[logs.length];
		int i = 0;
		for(i = 0;i < arr.size();i++){
			String value = arr.get(i);
			StringBuilder sb = new StringBuilder(map.get(value));
			
			sb.append(" "+value);
			ans[i] = sb.toString();
		}
		for(int j = 0;j < numarr.size();j++,i++){
			String value = numarr.get(j);

			StringBuilder sb = new StringBuilder(map.get(value));
			sb.append(" "+value);
			ans[i] = sb.toString();
		}

		for(String s : ans) {
			System.out.println(s);
		}
		return ans;
	}
	public static void main(String[] args) {
		n937_Reorder_Data_in_Log_Files obj = new n937_Reorder_Data_in_Log_Files();
		//System.out.println(obj.reorderLogFiles(new String[] {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"}));
		System.out.println(obj.reorderLogFiles(new String[] {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"}));
		//System.out.println(obj.reorderLogFiles2(new String[] {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"}));
	}
}
