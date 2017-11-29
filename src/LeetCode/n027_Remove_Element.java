package LeetCode;

//Given an array and a value, remove all instances of that value in-place and return the new length.
//Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
//The order of elements can be changed. It doesn't matter what you leave beyond the new length.
//Given nums = [3,2,2,3], val = 3,
//Your function should return length = 2, with the first two elements of nums being 2.

public class n027_Remove_Element {
	 public int removeElement(int[] nums, int val) {
		 if(nums.length == 0) 
			 return 0;
		 
		 int count = 0;
		 for(int i=0; i< nums.length; i++) {
			 if(nums[i] != val) {
				 nums[count++] = nums[i];
			 }
		 } 
		 return count;
	 }
	 public static void main(String[] args) {
		 n027_Remove_Element obj = new n027_Remove_Element();
		 int[] nums = {3,1,213,3};
		 System.out.println(obj.removeElement(nums, 3));
	 }
}
