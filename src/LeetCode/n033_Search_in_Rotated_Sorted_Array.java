package LeetCode;

public class n033_Search_in_Rotated_Sorted_Array {
	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;

		while(left<=right) {
			int mid = (left+right)/2;
			if(nums[mid] == target) 
				return mid;

			if(nums[left] < nums[mid]) {
				if(nums[left]<=target && target < nums[mid]) {
					right = mid-1;
				} else
					left = mid +1;
			}else {
				if(nums[right]>=target && target > nums[mid]) {
					left = mid+1;
				} else
					right = mid-1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		n033_Search_in_Rotated_Sorted_Array obj = new n033_Search_in_Rotated_Sorted_Array();
		int[] nums = {4,5,6,7,0,1,2};
		for(int i=0; i<nums.length; i++) 
			System.out.println(obj.search(nums, nums[i]));
	}
}
