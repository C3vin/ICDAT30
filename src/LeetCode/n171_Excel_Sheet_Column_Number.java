package LeetCode;

/*
Given a column title as appear in an Excel sheet, return its corresponding column number.
For example:
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
    
Example 1:
Input: "A"
Output: 1

Example 2:
Input: "AB"
Output: 28

Example 3:
Input: "ZY"
Output: 701
*/
public class n171_Excel_Sheet_Column_Number {
	public int titleToNumber(String s) {
		
	}
	public static void main(String[] args) {
		n171_Excel_Sheet_Column_Number obj = new n171_Excel_Sheet_Column_Number();
		System.out.println(obj.titleToNumber("A"));
		System.out.println(obj.titleToNumber("AB"));
		System.out.println(obj.titleToNumber("ZY"));
	}
}
