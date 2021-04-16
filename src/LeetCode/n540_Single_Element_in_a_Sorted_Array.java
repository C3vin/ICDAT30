package LeetCode;

/*
You are given a sorted array consisting of only integers where every element appears exactly twice, 
except for one element which appears exactly once. Find this single element that appears only once.

Follow up: Your solution should run in O(log n) time and O(1) space.
Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2

Example 2:
Input: nums = [3,3,7,7,10,11,11]
Output: 10
 */
public class n540_Single_Element_in_a_Sorted_Array {
	public int singleNonDuplicate(int[] nums) {
		//https://leetcode.com/problems/single-element-in-a-sorted-array/solution/
		//Good to read
		
		int left = 0;
		int right = nums.length - 1;
		
		while (left < right) {
			int mid = left + (right - left) / 2;
			
			boolean halvesAreEven = (right - mid) % 2 == 0;

			if(nums[mid + 1] == nums[mid]) {
				if(halvesAreEven) {
					//[1,1,O,D,D] 
					// m e v e n
					left = mid + 2;
				} else {
					//[1,1,E,V,E,N] Safe
					// m o d d o d
					right = mid - 1;
				}
			} else if(nums[mid - 1] == nums[mid]) {
				if(halvesAreEven) {
					//[1,1,E,V,E,N] Safe
					//   m e v e n
					right = mid - 2;
				} else {
					//[1,1,O,D,D]
					//   m o d d
					left = mid + 1;
				}
			} else {
				return nums[mid];
			}
		}

		return nums[left];
	}

	/*
EXPLANATION:-
Suppose array is [1, 1, 2, 2, 3, 3, 4, 5, 5]
we can observe that for each pair, 
first element takes even position and second element takes odd position
for example, 1 is appeared as a pair,
so it takes 0 and 1 positions. similarly for all the pairs also.

this pattern will be missed when single element is appeared in the array.

From these points, we can implement algorithm.
1. Take left and right pointers . 
    left points to start of list. right points to end of the list.
2. find mid.
    if mid is even, then it's duplicate should be in next index.
	or if mid is odd, then it's duplicate  should be in previous index.
	check these two conditions, 
	if any of the conditions is satisfied,
	then pattern is not missed, 
	so check in next half of the array. i.e, left = mid + 1
	if condition is not satisfied, then the pattern is missed.
	so, single number must be before mid.
	so, update end to mid.
3. At last return the nums[left]

Time: -  O(logN)
space:-  O(1)
	 */
	public int singleNonDuplicate2(int[] nums) {
		int left = 0;
		int right = nums.length-1;

		while(left < right) {
			int mid = left+(right-left)/2;

			if((mid%2 == 0 && nums[mid] == nums[mid+1]) || (mid%2 == 1 && nums[mid] == nums[mid-1])) {
				left = mid+1;
			} else {
				right = mid;
			}
		}

		return nums[left];
	}

	public static void main(String[] args) {
		n540_Single_Element_in_a_Sorted_Array obj = new n540_Single_Element_in_a_Sorted_Array();
		System.out.println(obj.singleNonDuplicate(new int[] {1,1,2,3,3,4,4,8,8}));
		System.out.println(obj.singleNonDuplicate2(new int[] {1,1,2,3,3,4,4,8,8}));
	}
}
