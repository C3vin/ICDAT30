package LeetCode;

import java.util.ArrayList;
import java.util.List;
@Alg(type="DFS", com="AA,G,F", level="med", num=17)
public class n017_letter_combinations_of_a_phone_number {
	/**
	 *Digit string "23"
	 *["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]. 
	 */
	public List<String> letterCom(String digits) {
		List<String> result = new ArrayList<String>();
		String[] letter = new String[]{"+", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		String tmp = new String();
		if(digits == null || digits.equals("")) 
			return result;
		generate(result, letter, digits, tmp, 0);
		return result;
	}
	private void generate(List<String> result, String[] letter, String digits, String tmp, int index) {
		if(index == digits.length()) {
			result.add(tmp);
			return;
		}
		int num = digits.charAt(index) - '0';
		for(int i=0; i<letter[num].length(); i++) {		//if we choose 7, the length will become 4
			generate(result, letter, digits, tmp+letter[num].charAt(i), index+1); //tmp+letter[num].charAt(i)
		}
	}
	public static void main(String[] args) {
		n017_letter_combinations_of_a_phone_number obj = new n017_letter_combinations_of_a_phone_number();
		System.out.println(obj.letterCom("23"));
	}
}
