package LeetCode;

/*
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). 
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, 
which together with x-axis forms a container, such that the container contains the most water.
Note: You may not slant the container and n is at least 2.

Example:
Input: [1,8,6,2,5,4,8,3,7]
Output: 49
 */
public class n011_Container_With_Most_Water {
	//cs
	//time:O(n) space:O(1)
	public int maxArea(int[] height) {
		int res = 0;
		int l = 0; 
		int r = height.length-1;
		
		while(l < r) {
			res = Math.max(res, Math.min(height[l], height[r]) * (r - l));	//length * width = square!
			if(height[l] < height[r]) {
				l++;
			} else {
				r--;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		n011_Container_With_Most_Water obj = new n011_Container_With_Most_Water();
		System.out.println(obj.maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
	}
}
