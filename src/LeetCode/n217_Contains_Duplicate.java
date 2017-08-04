package LeetCode;

import java.util.HashSet;

public class n217_Contains_Duplicate {
	//21ms
	public boolean containsDuplicate(int[] nums) {
		if(nums == null || nums.length == 0)
			return false;
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0; i<nums.length; i++) {
			if(set.contains(nums[i]))
					return true;
			set.add(nums[i]);
		}
		return false;
	}
	//14ms
	public boolean containsDuplicate2(int[] nums) {
		if(nums == null || nums.length == 0)
			return false;
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0; i<nums.length; i++) {
			if(!set.add(nums[i]))
				return true;
		}
		return false;
	}
	public static void main(String[] args) {
		n217_Contains_Duplicate obj = new n217_Contains_Duplicate();
		int[] nums = {1,2,4,4};
		System.out.println(obj.containsDuplicate(nums));
		System.out.println(obj.containsDuplicate2(nums));
	}
}
