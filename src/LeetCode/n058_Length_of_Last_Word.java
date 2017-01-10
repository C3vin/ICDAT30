package LeetCode;

//Given s = "Hello World", return 5.
public class n058_Length_of_Last_Word {
	public int lengthOfLastWord(String s) {
		s = s.trim();
		int count=0;
		boolean flag = true;
		for(int i=s.length()-1; i>= 0; i--) {
			if(s.charAt(i) != ' ' && flag == true) {
				count++;
			} else 
				flag = false;
		}
		return count;
	}
	
	public int lengthOfLastWord2(String s) {
		String[] ss = s.split(" ");
		
		if(ss == null || ss.length == 0)
			return 0;
		
		return ss[ss.length-1].length();
	}
	
	public static void main(String[] args) {
		n058_Length_of_Last_Word obj = new n058_Length_of_Last_Word();
		System.out.println(obj.lengthOfLastWord("hello world"));
		System.out.println(obj.lengthOfLastWord2("hello world Z "));
	}
}
