package LeetCode;

import LeetCode.n105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal.TreeNode;

/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
For example, given
inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 */
public class n106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	} 
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder.length == 0 || postorder.length == 0) {
			return null;
		}
		return helper(inorder, 0, inorder.length-1, postorder, postorder.length-1);
	}
	private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postEnd) {
		if(inStart > inEnd || postEnd < 0) {
			return null;
		}
		TreeNode root = new TreeNode(postorder[postEnd]);
		
		int inMid = 0;
		for(int i=inStart; i<=inEnd; i++) {		//start with inStart, end with inEnd
			if(inorder[i] == postorder[postEnd]) {
				inMid = i;
				break;
			}
		}
		
		int rightTreeSize = inEnd - inMid;		//F:
		System.out.println(postorder[postEnd]+ " : "+inMid + " : " + inStart + " postEnd: "+postEnd);
		root.left = helper(inorder, inStart, inMid-1, postorder, postEnd-rightTreeSize-1);
		root.right = helper(inorder, inMid+1, inEnd, postorder, postEnd-1);
		
		return root;
	}
	
	public static void main(String[] args) {
		n106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal obj = new n106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal();
		System.out.println(obj.buildTree(new int[] {9,3,15,20,7}, new int[] {9,15,7,20,3}));
	}
}
