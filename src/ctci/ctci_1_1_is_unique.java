package ctci;

public class ctci_1_1_is_unique {
	public boolean isUniqueChars(String str) {
		if(str.length() > 128)
			return false;
		
		boolean res[] = new boolean[128];
		for(int i=0; i<str.length(); i++) {
			int val = str.charAt(i);
			if(res[val]) {
				return false;
			}
			res[val] = true ;
		}
		
		return true;
	}
	
	public static void main(String args[]) {
		ctci_1_1_is_unique obj = new ctci_1_1_is_unique();
		System.out.println(obj.isUniqueChars("ctci"));
	}
}
