package LeetCode;

//Given a word, you need to judge whether the usage of capitals in it is right or not.
//We define the usage of capitals in a word to be right when one of the following cases holds:
//1) All letters in this word are capitals, like "USA".
//2) All letters in this word are not capitals, like "leetcode".
//3) Only the first letter in this word is capital if it has more than one letter, like "Google".
//Otherwise, we define that this word doesn't use capitals in a right way.
//Input: "USA" Output: True |  Input: "FlaG" Output: False
public class n520_Detect_Capital {
	public boolean detectCapitalUse(String word) {
		//case 1
		if(word.toUpperCase().equals(word))
			return true;
		//case 2 & case 3
		if(word.substring(1).toLowerCase().equals(word.substring(1)))
			return true;

		return false;
	}
	public static void main(String[] args) {
		n520_Detect_Capital obj = new n520_Detect_Capital();
		System.out.println(obj.detectCapitalUse("USA"));
		System.out.println(obj.detectCapitalUse("FlaG"));
	}
}