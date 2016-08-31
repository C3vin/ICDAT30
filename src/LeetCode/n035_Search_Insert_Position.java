package LeetCode;

public class n035_Search_Insert_Position {
	public int searchInsert(int[] nums, int target) {
		if(nums == null || nums.length == 0) return 0;
		
		int L = 0;
		int R = nums.length-1;
		
		while(L <= R) {
			int Mid = (L+R)/2;
			if(nums[Mid] == target)
				return Mid;
			if(nums[Mid] < target) {
				L = Mid+1;
			} else
				R = Mid-1;
		}
		return L;
	}
	
	public static void main(String[] args) {
		n035_Search_Insert_Position obj = new n035_Search_Insert_Position();
		int[] nums = {1,3,5,6};
		System.out.println(obj.searchInsert(nums, 5));
	}
}
