package LeetCode;

/*
Implement next permutation, which rearranges numbers into the lexicographically 
next greater permutation of numbers.
If such arrangement is not possible, it must rearrange it as the lowest possible order 
(ie, sorted in ascending order).
The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs 
are in the right-hand column.
1,2,3 -> 1,3,2
3,2,1 -> 1,2,3
1,1,5 -> 1,5,1

e.g. 
1 2 7 4 3 1
  ^
1 2 7 4 3 1
  	    ^
1 3 7 4 2 1
  ^     ^
1 3 1 2 4 7
    ^ ^ ^ ^
e.g.
7 4 3 2 1 1 

 */
public class n031_Next_Permutation {
	//Good!!! From back ~ 1) find i and 2)f find j, swap, and reverse the rest 
	public void nextPermutation2(int[] nums) {
		if(nums == null || nums.length <= 1) {
			return;
		}

		int i = nums.length - 2;					//why -2? cuz from back to front, compare n[i](n.length-2) vs n[i+1](n.length-1) 
		while(i >= 0 && nums[i] >= nums[i + 1]) {   //{1, 2, 7, 4, 3, 1}
			i--; 									// Find 1st id i that breaks descending order
		}

		if(i >= 0) {                           		// If not entirely descending
			int j = nums.length - 1;              	// Start from the end
			while(nums[j] <= nums[i]) {				// handle this case e.g. {1, 2, 7, 4, 3, 1} 
				j--;           						// F: find first j 'larger' than i, but need to use j <= i
			}

			swap(nums, i, j);                     	// Switch i and j		{1, 3, 7, 4, 2, 1} 
		}

		reverse(nums, i + 1, nums.length - 1);      // Reverse the descending sequence {1, 2, 1, 2, 4, 7} 

		for(int n : nums) {
			System.out.print(n);
		}
		System.out.println();
	}
	
	private void reverse(int[] nums, int start, int end) {
		//int end = nums.length-1;
		while(start < end) {				//swap index start and end 1 by 1, use 'while'
			swap(nums, start, end);
			start++;
			end--;
		}
	}
	private void swap(int[] nums, int start, int end) {
		int tmp = nums[start];
		nums[start] = nums[end];
		nums[end] = tmp;
	}
	

	
	public void nextPermutation(int[] nums) {

		int i = nums.length-2;

		while(i>=0 && nums[i+1] <= nums[i]) {	//find out first non-increasing 'index', keep while looping
			i--;
		}

		//handle special case
		if(i < 0) {
			reverse(nums, 0, nums.length-1); 	//3,2,1

			for(int n : nums)
				System.out.print(n);
			System.out.print("\n");

			return;								//need this return to stop here
		}

		int j = nums.length-1;
		while(j>=0 && nums[j] <= nums[i]) {		//find out first 'index' large than nums[i]
			j--;
		}

		swap(nums, i, j);
		reverse(nums, i+1, nums.length-1);

		for(int n : nums)
			System.out.print(n);
		System.out.print("\n");
	}

	public static void main(String[] args) {
		n031_Next_Permutation obj = new n031_Next_Permutation();
		//		obj.nextPermutation2(new int[] {1, 2, 3});
		//		obj.nextPermutation2(new int[] {3, 2, 1});
		//		obj.nextPermutation2(new int[] {1, 1, 5});
		//		obj.nextPermutation2(new int[] {1});

		obj.nextPermutation2(new int[] {1, 3, 1});
		obj.nextPermutation2(new int[] {1, 2});
		obj.nextPermutation2(new int[] {1, 2, 7, 4, 3, 1});
		obj.nextPermutation2(new int[] {1, 2, 0, 3, 0, 1, 2, 4});
		obj.nextPermutation2(new int[] {5, 4, 7, 5, 3, 2});
	}
}
