package ctci;

/*
One Away: There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away.
e.g.
pale, ple -> true
pales, pale -> true
pale, bale -> true
pale, bae -> false
 */
public class ctci_1_5_One_Away {
	//sol1
	boolean oneEditAway(String first, String second) {
		if(first.length() == second.length()) {
			return oneEditReplace(first, second);
		} else if(first.length() + 1 == second.length()) {
			return oneEditInsert(first, second);
		} else if(first.length() -1 == second.length()) {
			return oneEditInsert(second, first);
		}
		return false;
	}

	private boolean oneEditReplace(String s1, String s2) {
		boolean foundDifference = false;
		for(int i=0; i<s1.length(); i++) {
			if(s1.charAt(i) != s2.charAt(i)) {
				if(foundDifference) {
					return false;
				}
				foundDifference = true;
			}
		}
		return true;
	}

	private boolean oneEditInsert(String s1, String s2) {
		int index1 = 0;
		int index2 = 0;
		while(index2 < s2.length() && index1 < s1.length()) {
			if(s1.charAt(index1) != s2.charAt(index2)) {
				if(index1 != index2) {
					return false;
				}
				index2++;
			} else {
				index1++;
				index2++;
			}
		}
		return true; 
	}

	//sol2
	private boolean oneEditAway1(String first, String second) {
		//length check
		if(Math.abs(first.length() - second.length()) > 1) {
			return false;
		}

		//get shorter string
		String shorter = first.length() < second.length() ? first : second;
		//get longer string
		String longer = first.length() < second.length() ? second : first;

		int index1 = 0;
		int index2 = 0;
		boolean foundDifference = false;
		while(index2 < longer.length() && index1 < shorter.length()) {
			if(shorter.charAt(index1) != longer.charAt(index2)) {
				//ensure that this is the first difference found
				if(foundDifference) {
					//e.g. "bal","pale", use below check length to find another diff
					return false;	
				}
				foundDifference = true;

				//on replace, move shorter pointer
				if(shorter.length() == longer.length()) {
					index1++;
				}
			} else {
				index1++; 	//if matching, move shorter pointer 
			}
			index2++;	//always move point for longer string
		}
		return true;
	}

	public static void main (String args[]) {
		ctci_1_5_One_Away obj = new ctci_1_5_One_Away();
		System.out.println(obj.oneEditAway("pales", "pale"));
		System.out.println(obj.oneEditAway1("bal", "pale"));
	}
}
