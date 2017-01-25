package LeetCode;

import java.util.Arrays;

//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
//P   A   H   N
//A P L S I I G
//Y   I   R
//And then read line by line: "PAHNAPLSIIGYIR"
//convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".`
public class n006_ZigZag_Conversion {
	public String convert(String s, int nRows) {
		if(s.length() == 0 || nRows <= 1) return s;
		
		String[] ans = new String[nRows];
		Arrays.fill(ans, "");
		int row=0;
		int delta=1;
		for(int i=0; i<s.length(); i++) {
			ans[row] = ans[row] + s.charAt(i);
			row = row + delta;
			if(row >= nRows) {
				row = nRows-2;
				delta = -1;
			}
			if(row <0) {	//reset
				row = 1;
				delta = 1;
			}
		}
		String ret = "";
		for(int i=0; i<nRows; i++) { //link all strings to one string
			ret = ret + ans[i];
		}
		return ret;
	}
	public static void main(String[] args) {
		n006_ZigZag_Conversion obj = new n006_ZigZag_Conversion();
		//System.out.println(obj.convert("PAYPALISHIRING", 3));
		System.out.println(obj.convert("PAYPALISHIRING", 4));
	}
}
	
