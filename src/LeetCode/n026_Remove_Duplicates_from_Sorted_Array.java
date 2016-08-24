package LeetCode;

import java.util.Arrays;

public class n026_Remove_Duplicates_from_Sorted_Array {
	public int removeDuplicates(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		if(nums.length < 2) return nums.length;

		int count=0;
		for(int i=1; i < nums.length; i++) {
			if(nums[i] != nums[count]){
				//if(count != i) 
					nums[++count] = nums[i];
				//count++;
			}

		}
		System.out.println(Arrays.toString(nums));

		return count+1;
	}

	public static void main(String[] args) {
		n026_Remove_Duplicates_from_Sorted_Array obj = new n026_Remove_Duplicates_from_Sorted_Array();
		int[] nums = {1,1,1,2,2};
		System.out.println(obj.removeDuplicates((nums)));
	}
}
