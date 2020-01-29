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
	public void nextPermutation(int[] nums) {
		int i = nums.length-2;
		while(i>=0 && nums[i+1] <= nums[i]) {
			i--;
		}
		
		//handle special case
		if(i < 0) {
			reverse(nums, 0);
			//System.out.println("special");	//3,2,1
			return;
		}
		
		int j = nums.length-1;
		while(j>=0 && nums[j] <= nums[i]) {
			j--;
		}
		
		swap(nums, i, j);
		reverse(nums, i+1);
		
		for(int n:nums)
			System.out.print(n);
		System.out.print("\n");
	}
	private void reverse(int[] nums, int start) {
		int end = nums.length-1;
		while(start < end) {				//swap index start and end 1 by 1, use 'while'
			swap(nums, start, end);
			start++;
			end--;
		}
	}
	private void swap(int[] nums, int start, int end) {
		int tmp = nums[end];
		nums[end] = nums[start];
		nums[start] = tmp;
	}
	
	public static void main(String[] args) {
		n031_Next_Permutation obj = new n031_Next_Permutation();
		obj.nextPermutation(new int[] {1, 2, 3});
		obj.nextPermutation(new int[] {3, 2, 1});
		obj.nextPermutation(new int[] {1, 2, 7, 4, 3, 1});
		obj.nextPermutation(new int[] {1, 2, 0, 3, 0, 1, 2, 4});
		obj.nextPermutation(new int[] {5,4,7,5,3,2});
	}
}
