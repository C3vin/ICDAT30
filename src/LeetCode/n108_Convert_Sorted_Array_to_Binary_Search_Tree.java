package LeetCode;

/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of 
the two subtrees of every node never differ by more than 1.

Example:
Given the sorted array: [-10,-3,0,5,9],
One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
      0
     / \
   -3   9
   /   /
 -10  5
 */
public class n108_Convert_Sorted_Array_to_Binary_Search_Tree {
	public class TreeNode {
		int val;
		String v;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		TreeNode(String v) { v = null; }
	}
	public TreeNode sortedArrayToBST(int[] nums) {
		return helper(nums, 0, nums.length-1);
	}
	private TreeNode helper(int[] nums, int start, int end) {
		if(start > end) {
			return null;
		}
		int mid = (end - start)/2 + start;

		TreeNode node = new TreeNode(nums[mid]);	//map to the new node
		node.left = helper(nums, start, mid-1);			
		node.right = helper(nums, mid+1, end);			
		
		return node;
	}
	public static void main(String[] args) {
		n108_Convert_Sorted_Array_to_Binary_Search_Tree obj = new n108_Convert_Sorted_Array_to_Binary_Search_Tree();
		int[] nums = {1,2,3,4,5,6,7};
		System.out.println(obj.sortedArrayToBST(nums));
	}
}
