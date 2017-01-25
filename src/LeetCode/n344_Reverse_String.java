package LeetCode;
//Given s = "hello", return "olleh".
public class n344_Reverse_String {
	//We can just change half of the string, O(n/2) 3m
	public String reverseString(String s) { 
		char[] ch = s.toCharArray();
		int half = s.length()/2;
		System.out.println(s.length());
		char tmp;
		//swap
		for(int i=0; i<half; i++) {			
			tmp = ch[i];
			ch[i] = ch[ch.length-i-1];		//F: need '-i'  
			ch[ch.length-i-1] = tmp;
		}
		return new String(ch);
	}

	/* public String reverseString2(String s) {
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            result += s.charAt(i);
        }
        return result;
    }*/

/*	public String reverseString3(String s) {
		return new StringBuffer(s).reverse().toString();
	}*/
	

	public static void main(String[] args) {
		n344_Reverse_String obj = new n344_Reverse_String();
		String s = "helloworld";
		System.out.println(obj.reverseString(s));
	}
}
