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

//Better!
public class n017_letter_combinations_of_a_phone_number {
	public List<String> letterCom(String digits) {
		String[] dicts = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		List<String> result = new ArrayList<String>();

		String path = new String();
		if(digits == null || digits.equals("")) {
			return result;
		}
		
		helper(digits, result, path, dicts, 0);	//0: place, place of position 
		
		return result;
	}
	private void helper(String digits, List<String> result, String tmp, String[] dicts, int place) {
		if(place == digits.length()) {			//need to match the digits numbers size
			result.add(tmp);
			return;
		}
		
		int num = digits.charAt(place) - '0';		

		for(int i=0; i<dicts[num].length(); i++) {		//if we choose 7, the length will become 4
			helper(digits, result, tmp+dicts[num].charAt(i), dicts, place+1); 		//tmp+letter[num].charAt(i) !!! and place+1 not i+1
		}
	}

	//dfs Better! But greedy! easy to forget in dfs part
	public List<String> letterCombinations_dfs(String digits) {
		String[] dicts = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		List<String> res = new ArrayList<String>();
		String path = new String();
		
		dfs(digits, res, path, dicts);
		
		return res;
	}
	
	private void dfs(String digits, List<String> res, String path, String[] dicts) {
		if(digits.isEmpty()) {
			return;
			
		} else if(digits.length() == 1) {
			for(char letter : dicts[digits.charAt(0) - '0'].toCharArray()) {		//Character is okay!
				res.add(path + letter);
			}
		} else {
			for(char letter : dicts[digits.charAt(0) - '0'].toCharArray()) {
				dfs(digits.substring(1), res, path+letter, dicts);
			}
		}
	}
	
	//sol2
/*	public List<String> letterCombinations(String digits) {
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
	}*/

	public static void main(String[] args) {
		n017_letter_combinations_of_a_phone_number obj = new n017_letter_combinations_of_a_phone_number();
		System.out.println(obj.letterCom("27"));
		System.out.println(obj.letterCom("6"));
		System.out.println(obj.letterCombinations_dfs("23"));
	}
}
