package LeetCode;

import java.util.HashSet;

public class n136_Single_Number {
	//XOR Time Complexity: O(N), Space Complexity: O(1);  
	public int singleNumber(int[] nums) {
		int res = 0;
		for(int i=0; i<nums.length; i++) {
			res = res ^ nums[i];
		}
		return res;
	}
	//HashSet Time Complexity: O(N^2), Space Complexity: O(N);
	public int singleNumber2(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i=0; i<nums.length; i++) {
			if(set.contains(nums[i]))
				set.remove(nums[i]);
			else
				set.add(nums[i]);
		}
		
		for(int i=0; i<nums.length; i++) {
			if(set.contains(nums[i]))
				return nums[i];
		}
		return -1;
	}
	public static void main(String[] args) {
		n136_Single_Number obj = new n136_Single_Number();
		int[] nums = {1,1,2,3,3};				//a xor b xor a = a xor a xor b = 0 xor b = b. 
		System.out.println(obj.singleNumber(nums));
		System.out.println(obj.singleNumber2(nums));
	}
}
