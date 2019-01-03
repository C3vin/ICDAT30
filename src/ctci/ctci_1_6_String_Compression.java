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
	
	//sol3
	public String compress3(String str) {
		int finalLength = countCompression(str);
		/*if(finalLength >= str.length())			//for deal with "A"
			return str;*/
		
		/*
		One other benefit of this approach is that we can initialize StringBuilder to its necessary capacity
		up-front. Without this, StringBuilder will (behind the scenes) need to double its capacity every time it
		hits capacity. The capacity could be double what we ultimately need.
		 */
		StringBuilder sb = new StringBuilder(finalLength);	// initialize capacity
		int countConsecutive = 0;
		
		for(int i=0; i<str.length(); i++) {
			countConsecutive++;
			
			if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				sb.append(str.charAt(i)).append(countConsecutive);
				countConsecutive = 0; 			//set back to default
			}
		}
		return sb.toString();
	}
	
	public int countCompression(String str) {
		int compressedLength = 0;
		int countConsecutive = 0;
		for(int i=0; i<str.length(); i++) {
			countConsecutive++;
			
			if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				//compressedLength += 1;
				compressedLength += +1 + String.valueOf(countConsecutive).length();
				countConsecutive = 0; 			//set bacl to default
			}
		}
		return compressedLength;
	}
	
	public static void main(String[] args) {
		ctci_1_6_String_Compression obj = new ctci_1_6_String_Compression();
		String str = "abccc";
		System.out.println(str);
		System.out.println(obj.compress(str));
		System.out.println(obj.compress3(str));
		
		System.out.println(obj.compress("AAABBBBCC"));
		System.out.println(obj.compress3("AAABBBBCC"));
		System.out.println(obj.compress("AAABC"));
		System.out.println(obj.compress3("AAABC"));
		System.out.println(obj.compress("A"));
		System.out.println(obj.compress3("A"));
	}
}
