package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:
Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class n017_letter_combinations_of_a_phone_number {
	String[] dicts = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	public List<String> letterCom(String digits) {
		List<String> result = new ArrayList<String>();

		String tmp = new String();
		if(digits == null || digits.equals("")) {
			return result;
		}
		
		generate(result, dicts, digits, tmp, 0);
		
		return result;
	}
	private void generate(List<String> result, String[] dicts, String digits, String tmp, int index) {
		if(index == digits.length()) {			//need to match the digits numbers
			result.add(tmp);
			return;
		}
		
		int num = digits.charAt(index) - '0';

		for(int i=0; i<dicts[num].length(); i++) {		//if we choose 7, the length will become 4
			generate(result, dicts, digits, tmp+dicts[num].charAt(i), index+1); 		//tmp+letter[num].charAt(i) !!! and index+1 not i+1
		}
	}

	//dfs
	public List<String> letterCombinations_dfs(String digits) {
		List<String> combin = new ArrayList<String>();
		dfs(digits, "", combin);
		return combin;
	}
	
	private void dfs(String digits, String path, List<String> combin) {
		if(digits.isEmpty()) {
			return;
		} else if(digits.length() == 1) {
			for(Character letter : dicts[digits.charAt(0) - '0'].toCharArray()) {
				combin.add(path + letter);
			}
		} else {
			for(Character letter : dicts[digits.charAt(0) - '0'].toCharArray()) {
				dfs(digits.substring(1), path + letter, combin);
			}
		}
	}
	
	//sol2
	public List<String> letterCombinations(String digits) {
		List<String> combin = new ArrayList<String>();
		if(digits.length() == 0) {
			return combin;
		}

		for(Character c : digits.toCharArray()) {
			String letters = dicts[c - '0'];
			if(combin.isEmpty()) {
				for(Character letter : letters.toCharArray()) {
					combin.add(String.valueOf(letter));			//convert char to string
				}
			} else {
				int length = combin.size();								
				for(Character letter : letters.toCharArray()) {
					for(int i=0; i<length; i++) {				//if we don't use length, java.lang.OutOfMemoryError: Java heap spac
						String before = combin.get(i);
						combin.add(before + letter);
					}
				}
				for(int i=0; i<length; i++) {					//need this to remove first element when we do first add, e.g. a,b,c
					combin.remove(0);
				}
			}
		}
		return combin;
	}

	public static void main(String[] args) {
		n017_letter_combinations_of_a_phone_number obj = new n017_letter_combinations_of_a_phone_number();
		System.out.println(obj.letterCom("23"));
//		System.out.println(obj.letterCombinations("23"));
//		System.out.println(obj.letterCombinations_dfs("23"));
	}
}
