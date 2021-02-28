package LeetCode;

/*
Given an array nums of integers, return how many of them contain an even number of digits.

Example 1:
Input: nums = [12,345,2,6,7896]
Output: 2
Explanation: 
12 contains 2 digits (even number of digits). 
345 contains 3 digits (odd number of digits). 
2 contains 1 digit (odd number of digits). 
6 contains 1 digit (odd number of digits). 
7896 contains 4 digits (even number of digits). 
Therefore only 12 and 7896 contain an even number of digits.
Example 2:
Input: nums = [555,901,482,1771]
Output: 1 
Explanation: 
Only 1771 contains an even number of digits.
 */
public class n1295_Find_Numbers_with_Even_Number_of_Digits {
	public int findNumbers(int[] nums) {
        int res = 0;
        
        for(int i=0; i<nums.length; i++) {
            if(Integer.toString(nums[i]).length()%2 == 0) {     //convert Integer.toString
                res++;
            }
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		n1295_Find_Numbers_with_Even_Number_of_Digits obj = new n1295_Find_Numbers_with_Even_Number_of_Digits();
		System.out.println(obj.findNumbers(new int[] {12,345,2,6,7896}));
		System.out.println(obj.findNumbers(new int[] {555,901,482,1771}));
	}
}
