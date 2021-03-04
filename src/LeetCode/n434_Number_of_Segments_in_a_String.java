package LeetCode;

//Input: "Hello, my name is John"   Output: 5
public class n434_Number_of_Segments_in_a_String {
	  public int countSegments(String s) {
		  int count=0;
		  
		  for(int i=0; i<s.length(); i++) {
			  if(s.charAt(i)==' ') {		//F: ' '(char) not " "(string)
				  continue;
			  }
			  
			  count++;
			  
			  while(s.charAt(i) != ' ' && i<s.length()-1) {		//F: need -1, cuz index range
				  i++;
			  }
		  }
		  return count;
	  }
	  public static void main(String[] args) {
		  n434_Number_of_Segments_in_a_String obj = new n434_Number_of_Segments_in_a_String();
		  //System.out.println(obj.countSegments("Hello, my name is John"));
		  System.out.println(obj.countSegments(", , , ,        a, eaefa"));
	  }
}
