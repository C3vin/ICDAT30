package LeetCode;

import java.util.Stack;

/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.

Example:
Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
 */
public class n042_Trapping_Rain_Water {
	public int trap(int[] height) {
		if (height == null || height.length == 0)  
			return 0;  

		int i, max, total = 0;
		int left[] = new int[height.length];
		int right[] = new int[height.length];  

		// from left to right
		left[0] = height[0];
		max = height[0];
		for (i=1; i<height.length; i++) {  				//i = 1
			left[i] = Math.max(max, height[i]);
			max = Math.max(max, height[i]);
		}  

		// from right to left
		right[height.length-1] = height[height.length-1];
		max = height[height.length-1];
		for (i=height.length-2; i>=0; i--) {  			//why height.length - 2?
			right[i] = Math.max(max, height[i]);
			max = Math.max(max, height[i]);
		}  

		// trapped water (when i==0, it cannot trapped any water)
		for (i=1; i<height.length-1; i++) {  
			int bit = Math.min(left[i], right[i]) - height[i];  
			if (bit > 0)  
				total += bit;  
		}  

		return total;  
		/***
		 *      index: 0  1  2  3  4  5  6  7  8  9  10 11
    		  	 A[index]: 0  1  0  2  1  0  1  3  2  1  2  1
  		      left[index]: 0  1  1  2  2  2  2  3  3  3  3  3
			 right[index]: 3  3  3  3  3  3  3  3  2  2  2  1
        	  	   min[i]: 0  1  1  2  2  2  2  3  2  2  2  1
          		   bit[i]: -  0  1  0  1  2  1  0  0  1  0  0 
		 */
	}
	//cs
	//time:O(n) space:O(1)
	public int trap2(int[] height) {
		int res = 0;
		int l = 0;
		int r = height.length-1;
		int lMax = 0;
		int rMax = 0;
		
		while(l < r) {
			if(height[l] < height[r]) {
				lMax = Math.max(lMax, height[l]);
				res = res + lMax - height[l];
				l++;
			} else {
				rMax = Math.max(rMax, height[r]);
				res = res + rMax - height[r];
				r--;
			}
		}
		return res;
	}

	//stack sol#5
	//https://leetcode.wang/leetCode-42-Trapping-Rain-Water.html 
	public int trap3(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
		
		int sumArea = 0;
		int current = 0;
		
		while(current < height.length) {
			while(!stack.isEmpty() && height[current] > height[stack.peek()]) {		//diff than LC84 
				int h = height[stack.peek()];
				stack.pop();
				
				if(stack.isEmpty()) {			//must check! 
					break;
				}
				
				int distance = current - stack.peek() - 1;
				
				int min = Math.min(height[stack.peek()], height[current]);		//diff than LC84, find the lowest h
				sumArea = sumArea + distance * (min - h);						//width * height(min)  min will always larger than h
			}
			stack.push(current);
			current++;
		}
		
		return sumArea;
	} 
	
	public static void main(String[] artgs) {
		n042_Trapping_Rain_Water obj = new n042_Trapping_Rain_Water();
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(obj.trap(height));
		System.out.println(obj.trap2(height));
		System.out.println(obj.trap3(height));
	}
}
