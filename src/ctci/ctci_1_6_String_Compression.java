package ctci;

/*
String Compression: Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
"compressed" string would not become smaller than the original string, your method should return
the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */
public class ctci_1_6_String_Compression {

	//sol2
	public String compress(String str) {
		StringBuilder sb = new StringBuilder();
		int countConsective  = 0;
		
		for(int i=0; i<str.length(); i++) {
			countConsective++;					//first one
			
			//why >=, cuz handle latest value
			if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				sb.append(str.charAt(i)).append(countConsective);
				countConsective = 0;			//set back to default
			}
		}
		
		return sb.toString();	//sb.length() < str.length() ? sb.toString() : str;
	}
	
	public static void main(String[] args) {
		ctci_1_6_String_Compression obj = new ctci_1_6_String_Compression();
		String str = "aabcccccaaa";
		System.out.println(str);
		System.out.println(obj.compress(str));
	}
}
