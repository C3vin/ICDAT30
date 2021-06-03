package LeetCode;

/*
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.
Example:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class n167_Two_Sum_II_Input_array_is_sorted {
	//O(n) O(1) 
	public int[] twoSum(int[] numbers, int target) {
		int left = 0;
		int right = numbers.length-1;
		
		while(left < right) {
			if(numbers[left] + numbers[right] == target) {
				return new int[] {left+1, right+1};				//why +1 for index 
			} else if(numbers[left] + numbers[right] < target) {	//already sorted!
				left ++;
			} else {
				right--;
			}
		}
		
		return new int[] {-1, -1};
	}
	
	public static void main(String[] args) {
		n167_Two_Sum_II_Input_array_is_sorted obj = new n167_Two_Sum_II_Input_array_is_sorted();
		System.out.println(obj.twoSum(new int[] {2,7,11,15}, 9));
	}
}
