package LeetCode;

/*
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, 
with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
Note: You are not suppose to use the library's sort function for this problem.

Example:
Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?
 */
public class n075_Sort_Colors {
	public void sortColors(int[] nums) {
		int zero_idx = 0; 
		int two_idx = nums.length-1;

		//why 'two_idx', cuz we don't need to check after swap to two_idx, also two_idx will smaller and smaller (dynamic)
		for(int i=0; i<=two_idx; i++) {			//must <=, cuz two_idx-- so the length change after that will miss check one idx e.g.[2,0,1] -> [1,0,2]
			if (nums[i] == 0) {
				int tmp = nums[i];
				nums[i] = nums[zero_idx];
				nums[zero_idx] = tmp;
				
				zero_idx++;
			} else if (nums[i] == 2) {
				int tmp = nums[i];
				nums[i] = nums[two_idx];
				nums[two_idx] = tmp;

				two_idx--;

				i--;								//why i--, cuz need to check the value after swap form 2.)
			}
		}
		
/*		for(int n : nums)
			System.out.println(n);*/
	}

	public static void main(String[] args) {
		n075_Sort_Colors obj = new n075_Sort_Colors();
		//obj.sortColors(new int[] {2,0,1});
		obj.sortColors(new int[] {2,0,2,1,1,0});
	}
}
