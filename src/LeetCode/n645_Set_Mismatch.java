package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

//Input: nums = [1,2,2,4]
//Output: [2,3]	
public class n645_Set_Mismatch {
	//hashmap
	//Time complexity : O(n)O(n). Traversing over numsnums of size nn takes O(n)O(n) time. Considering each number from 11 to nn also takes O(n)O(n) time.
	//Space complexity : O(n)O(n). mapmap can contain atmost nn entries for each of the numbers from 11 to nn.
	public int[] findErrorNums(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int s : nums) {				//can't use int i, cuz need to avoid irrelative value
			if(!map.containsKey(s)) {   //map.put(s, map.getOrDefault(s, 0)+1);
				map.put(s, 1);
			} else {
				map.put(s, map.get(s)+1);
			}
		}
		int missing = 1;
		int dup = -1;
		for(int i=0; i<=nums.length; i++) {		//need <= because e.g. 4
			if(map.containsKey(i)) {	//in map
				if(map.get(i) == 2)		//can't use nums[i] need to use i only, because we start i=1 and nums.length so we will out of bound  
					dup = i;
			} else {					//not in map
				missing = i;
			}
		}        
		System.out.println(dup + " : "+ missing);
		return new int[] {dup, missing};
	}

	//sort SMART!
	//Time complexity : O(nlogn)O(nlogn). Sorting takes O(nlogn)O(nlogn) time.
	//Space complexity : O(logn)O(logn). Sorting takes O(logn)O(logn) space.
	public int[] findErrorNums2(int[] nums) {
		Arrays.sort(nums);
		int dup = -1; 
		int missing = 1;

		for(int i=1; i<nums.length; i++) {		    //can't use i=0, cuz will out of bound 
			if(nums[i] == nums[i-1]) {				//check all elements
				dup = nums[i];
			} else if(nums[i] > nums[i-1]+1) {		//Good!  4>2+1, 2>2+1(x), 2>1+1(x)  
				missing = nums[i-1]+1;
			}
		}
		if(nums[nums.length-1] != nums.length) { 	//F: check missing, because [1,1] can't update correct missing 
			missing = nums.length;
		}

		return new int[] {dup, missing};
	}
	public static void main(String[] args) {
		n645_Set_Mismatch obj = new n645_Set_Mismatch();
		//int[] nums = {1,2,2,4};
		int[] nums = {1,1};
		//System.out.println(obj.findErrorNums(nums));
		System.out.println(obj.findErrorNums2(nums));
	}
}
