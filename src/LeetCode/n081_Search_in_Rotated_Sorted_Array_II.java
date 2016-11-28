package LeetCode;

public class n081_Search_in_Rotated_Sorted_Array_II {
	public boolean search(int[] nums, int target) {
		int left=0;
		int right=nums.length-1;

		while(left<=right) {
			int mid = (left+right)/2;
			if(nums[mid]==target)
				return true;

			if(nums[left]<nums[mid]) {
				if(nums[left]<=target&& target<nums[mid]){
					right=mid-1;
				}else{
					left=mid+1;
				}
			}else if(nums[left]>nums[mid]) {
				if(nums[mid]<target&&target<=nums[right]){
					left=mid+1;
				}else{
					right=mid-1;
				}
			}else {			
				left++;				//this diff for deal with dup
			}    
		}
		return false; 
	}
	public static void main(String[] args) {
		n081_Search_in_Rotated_Sorted_Array_II obj = new n081_Search_in_Rotated_Sorted_Array_II();
		int[] nums = {2,3,4,1,1,2};
		int target = 1;
		System.out.println(obj.search(nums, target));
	}
}
