package LeetCode;

public class n027_Remove_Element {
	 public int removeElement(int[] nums, int val) {
		 if(nums.length == 0) return 0;
		 
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
		 int[] nums = {3,3};
		 System.out.println(obj.removeElement(nums, 3));
	 }
}
