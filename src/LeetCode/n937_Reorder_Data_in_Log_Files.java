package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
	//https://www.itread01.com/content/1543067163.html   ISSUE with same letterLog
	//https://leetcode.com/problems/reorder-data-in-log-files/discuss/193872/Java-Nothing-Fancy-15-lines-2ms-all-clear
	public String[] reorderLogFiles(String[] logs) {
		if(logs.length == 0) {		//no JAVA for String[] == null
			return logs;
		}
		List<String> letterLogs = new ArrayList<String>();
		List<String> digitLogs = new ArrayList<String>();

		for(String log : logs) {
			if(Character.isDigit(log.charAt(log.length()-1))) {
				digitLogs.add(log);
			} else {
				letterLogs.add(log);
			}
		}
		
		//in Java 8, List interface is supports the sort method, no need Collections.sort anymore
		letterLogs.sort((String o1, String o2) -> {
			String s1 = o1.substring(o1.indexOf(" ") + 1);
			String s2 = o2.substring(o2.indexOf(" ") + 1);
			
			return s1.equals(s2) ? o1.compareTo(o2) : s1.compareTo(s2);
		});
		//OR Collections.sort(letterLogs, new Comparator<String>() 
/*		letterLogs.sort(new Comparator<String>() {
		public int compare(String o1, String o2) {
			String s1 = o1.substring(o1.indexOf(" ") + 1);
			String s2 = o2.substring(o2.indexOf(" ") + 1);

			return s1.equals(s2) ? o1.compareTo(o2) : s1.compareTo(s2);
		}
		});*/
		letterLogs.addAll(digitLogs); 				//addAll

		String[] res = new String[logs.length];
		for(int i=0; i<logs.length; i++) {
			res[i] = letterLogs.get(i);
		}

		for(String s : res) {
			System.out.println("res: "+s);
		}
		
		return res;
	}

	public String[] reorderLogFiles2(String[] logs) {
		if(logs.length == 0) return logs;

		List<String> letterLogs = new ArrayList<>(), digitLogs = new ArrayList<>();
		separateLettersDigits(logs, letterLogs, digitLogs);
		sortLetterLogs(letterLogs);
		
		return generateOutput(letterLogs, digitLogs);  
	}
	private void separateLettersDigits(String[] input, List<String> letterLogs, List<String> digitLogs) { 
		for(String log : input) {
			if(Character.isDigit(log.charAt(log.length()-1))){
				digitLogs.add(log);
			} else {
				letterLogs.add(log);
			}
		}
	}
	private void sortLetterLogs(List<String> letterLogs) {
		letterLogs.sort((String o1, String o2) -> {
			String s1 = o1.substring(o1.indexOf(" ") + 1);
			String s2 = o2.substring(o2.indexOf(" ") + 1);
			
			return s1.equals(s2) ? o1.compareTo(o2) : s1.compareTo(s2);
		});
		/*Collections.sort(letterLogs, new Comparator<String>() {
			public int compare(String o1, String o2) {
				String s1 = o1.substring(o1.indexOf(" ") + 1);
				String s2 = o2.substring(o2.indexOf(" ") + 1);

				return s1.equals(s2) ? o1.compareTo(o2) : s1.compareTo(s2);
			}
		});
*/	}

	private String[] generateOutput(List<String> letterLogs, List<String> digitLogs) {
		String[] output = new String[letterLogs.size() + digitLogs.size()];
		for(int i = 0; i < letterLogs.size(); i++) {
			output[i] = letterLogs.get(i);
		}
		for(int i = letterLogs.size(); i < output.length; i++) {
			output[i] = digitLogs.get(i-letterLogs.size());
		}
		
		for(String s : output) {
			System.out.println("output: "+s);
		}
		
		return output;  
	}

	public static void main(String[] args) {
		n937_Reorder_Data_in_Log_Files obj = new n937_Reorder_Data_in_Log_Files();
		System.out.println(obj.reorderLogFiles(new String[] {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"}));
		System.out.println(obj.reorderLogFiles(new String[] {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"}));

		System.out.println(obj.reorderLogFiles2(new String[] {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"}));
		System.out.println(obj.reorderLogFiles2(new String[] {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"}));
	}
}
