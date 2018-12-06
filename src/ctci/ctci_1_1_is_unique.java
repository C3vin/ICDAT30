package ctci;

/*
 * 
1.1 Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
cannot use additional data structures?
 */
public class ctci_1_1_is_unique {
	//sol#1
	public boolean isUniqueChars(String str) {
		if (str.length() > 128)
			return false;
		
		boolean res[] = new boolean[128];
		for (int i=0; i<str.length(); i++) {
			int val = str.charAt(i);
			if (res[val]) {
				return false;
			}
			res[val] = true ;
		}
		
		return true;
	}
	
	//sol#2 
	//TODO: bit vector
	
	public static void main(String args[]) {
		ctci_1_1_is_unique obj = new ctci_1_1_is_unique();
		System.out.println(obj.isUniqueChars("ctci"));
		System.out.println(obj.isUniqueChars("dance"));
	}
}
