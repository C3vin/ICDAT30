package LeetCode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class n026_Remove_Duplicates_from_Sorted_Array {
	public int removeDuplicates(int[] nums) {
		if(nums.length == 0 || nums == null) return 0;
		if(nums.length < 2) return nums.length;

		int count = 1;
		for(int i=1; i<nums.length; i++) {
			//TODO: change 
			if(nums[i] != nums[i-1]) {
				if(count != i)
					nums[i-1] = nums[i];
				count++;
			}
		}
		System.out.print(Arrays.toString(nums));


		return count;
	}

	public static void main(String[] args) {
		n026_Remove_Duplicates_from_Sorted_Array obj = new n026_Remove_Duplicates_from_Sorted_Array();
		int[] nums = {1,1,1,2}; // test {1,2}
		System.out.println("\nCount: "+obj.removeDuplicates(nums));
	}
}
