package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class n018_4Sum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums == null || nums.length <4) return res;

		Arrays.sort(nums);

		for(int i=0; i<nums.length-3; i++) {
			if(i!=0 && nums[i] == nums[i-1])			//F:&&  and i-1
				continue;
			for(int j=i+1; j<nums.length-2; j++) {
				if(j!=i+1 && nums[j] == nums[j-1])		//F:&&	and j-1
					continue;
				int l = j+1;
				int r = nums.length-1;

				while(l<r) {			
					int sum = nums[i]+nums[j]+nums[l]+nums[r];
					if(sum < target) {					//F:do < and > and ==
						l++;
					} else if(sum > target){
						r--;
					}
					else {      //(sum == target) 
						List<Integer> tmp = new ArrayList<Integer>();
					tmp.add(nums[i]);
					tmp.add(nums[j]);
					tmp.add(nums[l]);
					tmp.add(nums[r]);
					res.add(tmp);
					l++;
					r--;

					while(l<r && nums[l] == nums[l-1]) 
						l++;
					while(l<r && nums[r] == nums[r+1])
						r--;
					}
				}   
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		n018_4Sum obj = new n018_4Sum();
		int[] nums = {1, 0, -1, 0, -2, 2};
		System.out.println(obj.fourSum(nums, 0));
	}
}
