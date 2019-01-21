package LeetCode;

import java.util.HashSet;
import java.util.Set;

/*
Every email consists of a local name and a domain name, separated by the @ sign.
For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.
Besides lowercase letters, these emails may contain '.'s or '+'s.
If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name.  For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not apply for domain names.)
If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does not apply for domain names.)
It is possible to use both of these rules at the same time.
Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails? 

Example 1:
Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
Output: 2
Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails

Note:
1 <= emails[i].length <= 100
1 <= emails.length <= 100
Each emails[i] contains exactly one '@' character.
 */
public class n929_Unique_Email_Addresses {
	//so1
	public int numUniqueEmails(String[] emails) {
		if(emails == null || emails.length == 0) 
			return 0;

		HashSet<String> localNames = new HashSet<>();
		for(String email : emails) {
			String[] arr = email.split("@");
			String localName = arr[0];
			int indexOfPlus = localName.indexOf("+");
			if(indexOfPlus != -1) {
				localName = localName.substring(0, indexOfPlus);
			}
			//why replaceAll?
			localName = localName.replaceAll("\\.", "");
			localNames.add(localName + "@" + arr[1]);
		}
		return localNames.size();
	}

	//sol2
	public int numUniqueEmails2(String[] emails) {
		if(emails == null || emails.length == 0) 
			return 0;

		HashSet<String> localNames = new HashSet<>();

		for(String email : emails) {
			String[] arr = email.split("@");
			String localName = arr[0];
			StringBuilder sb = new StringBuilder();				//sb need to be in this loop, if not will add on old sb

			for(int i=0; i<localName.length(); i++) {
				if(localName.charAt(i) == '+') {
					localNames.add(sb.toString() + "@" + arr[1]);
					break;
				} else if(localName.charAt(i) == '.') {
					continue; 
				} else {
					sb.append(localName.charAt(i));
				}
			}
		}
		return localNames.size();
	}

	//sol3
	public int numUniqueEmails3(String[] emails) {
		Set<String> set = new HashSet<>();

		for (String email : emails) {
			String localName = email.split("@")[0];
			String domainName = email.split("@")[1];

			localName = localName.replace(".", "");
			int idx = localName.indexOf('+');
			if (idx != -1) {
				localName = localName.substring(0, idx);
			}
			set.add(localName+"@"+domainName);
		}
		return set.size();
	}

public static void main(String[] args) {
	n929_Unique_Email_Addresses obj = new n929_Unique_Email_Addresses();
	String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
	System.out.println(obj.numUniqueEmails(emails));
	System.out.println(obj.numUniqueEmails2(emails));
	System.out.println(obj.numUniqueEmails3(emails));
}
}
