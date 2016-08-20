package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class n017_letter_combinations_of_a_phone_number {
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		String[] letters = new String[]{"+", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		
		if(digits == null || digits.equals("")) return result;
		
		generateString(result, letters, digits, "", 0);
		return result;
    }
    
    public void generateString(List<String> result, String[] letters, String digits, String s, int index) {
    	System.out.println("s:" +s + " index: "+index);
		if(index == digits.length()) {
			result.add(s);
			System.out.println("IN" + " result: "+result + "\n");
			return;
		}
		int num = digits.charAt(index) - '0';
		//System.out.println("num: "+num);
		for(int i=0; i<letters[num].length(); i++) {
			System.out.println("sss: " +s + " num: "+num + " i: " + i);
			generateString(result, letters, digits, s + letters[num].charAt(i), index+1);
		}
	}
	  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public List<String> letterCom(String digits) {
    	List<String> result = new ArrayList<String>();
    	String[] letter = new String[]{"+", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    	
    	if(digits == null || digits.equals("")) return result;
    	
    	generate(result, letter, digits, "", 0);
    	return result;
    }
    
	  private void generate(List<String> result, String[] letter, String digits, String tmp, int index) {
		  if(index == digits.length()) {
			  result.add(tmp);
			  return;
		  }
		
		  int num = digits.charAt(index) - '0';
		  for(int i=0; i<letter[num].length(); i++) {
			  generate(result, letter, digits, tmp + letter[num].charAt(i), index+1);
		  }
		
	}

	public static void main(String[] args) {
		  n017_letter_combinations_of_a_phone_number obj = new n017_letter_combinations_of_a_phone_number();
		  //System.out.println(obj.letterCombinations("23"));
		  System.out.println(obj.letterCom("23"));
	  }
}
