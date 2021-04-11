package LeetCode;

import java.util.Stack;

/*
Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], 
nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].
Return true if there is a 132 pattern in nums, otherwise, return false.

Follow up: The O(n^2) is trivial, could you come up with the O(n logn) or the O(n) solution?
 
Example 1:
Input: nums = [1,2,3,4]
Output: false
Explanation: There is no 132 pattern in the sequence.

Example 2:
Input: nums = [3,1,4,2]
Output: true
Explanation: There is a 132 pattern in the sequence: [1, 4, 2].

Example 3:
Input: nums = [-1,3,2,0]
Output: true
Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 */
public class n456_132_Pattern {
	//O(n) O(n)
	public boolean find132pattern(int[] nums) {
		if (nums.length < 3) {
            return false;
		}
		
        Stack<Integer> stack = new Stack<Integer>();
        
        int[] min = new int[nums.length];
        min[0] = nums[0];
        
        for(int i=1; i<nums.length; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }
        
        for(int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] > min[j]) {
                while (!stack.isEmpty() && stack.peek() <= min[j]) {		//while not if, cuz update to smallest 
                    stack.pop();	
                }
                if (!stack.isEmpty() && stack.peek() < nums[j]) {			//< not <=  
                    return true;
                }
                
                stack.push(nums[j]);
            }
        }
        
        return false;
	}
	
	public static void main(String[] args) {
		n456_132_Pattern obj = new n456_132_Pattern();
		System.out.println(obj.find132pattern(new int[] {1,2,3,4}));			//F
		System.out.println(obj.find132pattern(new int[] {3,1,4,2}));			//T
		System.out.println(obj.find132pattern(new int[] {-1,3,2,0}));			//T
		System.out.println(obj.find132pattern(new int[] {-1,0,1,-4,-3}));		//F
		System.out.println(obj.find132pattern(new int[] {-1,2,1,-4,-3}));		//T
	}
}
