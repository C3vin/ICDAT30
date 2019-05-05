package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
Find all strobogrammatic numbers that are of length = n.

Example:
Input:  n = 2
Output: ["11","69","88","96"]
*/
public class n247_Strobogrammatic_Number_II {
	public List<String> findStrobogrammatic(int n) {
		List<String> one = Arrays.asList("0", "1", "8");	
		List<String> res = Arrays.asList("");

		if(n%2 == 1)
			res = one;							//update res, for odd 

		for(int i=(n%2)+2; i<=n; i=i+2) {		//F: i=i+2 e.g. n=4, i=2->4 (twice loop). 1) 00,11,69,88,96 2) 1001,1111,1691...
			List<String> list = new ArrayList<String>();
			for(String s : res) {
				if(i != n) {
					list.add("0" + s + "0");	//e.g. n=4, need 00.
				}
				list.add("1" + s + "1");
				list.add("6" + s + "9");
				list.add("8" + s + "8");
				list.add("9" + s + "6");
			}
			res = list;
		}
		return res;
	}
	public static void main(String[] args) {
		n247_Strobogrammatic_Number_II obj = new n247_Strobogrammatic_Number_II();
		System.out.println(obj.findStrobogrammatic(1));
		System.out.println(obj.findStrobogrammatic(2));
		System.out.println(obj.findStrobogrammatic(3));
		System.out.println(obj.findStrobogrammatic(4));
	}
}
/*n = 0:   none
  n = 1:   0, 1, 8
  n = 2:   11, 69, 88, 96
  n = 3:   101, 609, 808, 906, 111, 619, 818, 916, 181, 689, 888, 986
  n = 4:   1001, 6009, 8008, 9006, 1111, 6119, 8118, 9116, 1691, 6699, 8698, 9696, 1881, 6889, 8888, 9886, 1961, 6969, 8968, 9966*/
