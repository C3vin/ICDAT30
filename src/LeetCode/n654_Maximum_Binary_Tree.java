package LeetCode;

/*
Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
Note:
The size of the given array will be in the range [1,1000].
 */
public class n654_Maximum_Binary_Tree {
	//Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return helper(nums, 0, nums.length-1);
	}

	private TreeNode helper(int[] nums, int start, int end) {
		if(start > end) {
			return null;
		}

		int index = -1;
		int max = Integer.MIN_VALUE;
		for(int i=start; i<=end; i++) {
			if(max < nums[i]) {
				index = i;
				max = nums[i];
			}
		}
		
		TreeNode root = new TreeNode(max);

		root.left = helper(nums, start, index-1);
		root.right = helper(nums, index+1, end);
		
		return root;
	}
	
	public static void main(String[] args) {
		n654_Maximum_Binary_Tree obj = new n654_Maximum_Binary_Tree();
		System.out.println(obj.constructMaximumBinaryTree(new int[] {3,2,1,6,0,5}));
	}
}
