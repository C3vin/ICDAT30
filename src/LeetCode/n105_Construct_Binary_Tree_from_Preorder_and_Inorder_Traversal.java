package LeetCode;

import LeetCode.n109_Convert_Sorted_List_to_Binary_Search_Tree.TreeNode;

/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
For example, given
preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:
    3
   / \
  9  20
    /  \
   15   7
 */
public class n105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	} 
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length == 0 || inorder.length == 0) {
			return null;
		}
		return helper(preorder, 0, inorder, 0, inorder.length-1);
	}
	
	private TreeNode helper(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd) {
		if(preStart > preorder.length || inStart > inEnd) {
			return null;
		}
		
		TreeNode root = new TreeNode(preorder[preStart]);
		int inMid = 0;
		for(int i=inStart; i<=inEnd; i++) {		//can't use inorder.length
			if(inorder[i] == preorder[preStart]){
                inMid = i;
                preStart++;
            }
		}
		if(preStart < preorder.length) {
		System.out.println(preStart);
		root.left = helper(preorder, preStart, inorder, inStart, inMid-1);
		root.right = helper(preorder, preStart, inorder, inMid+1, inEnd);
		}
		return root;
	}
	/*
	https://segmentfault.com/a/1190000003753709
	https://hezhigang.github.io/2018/10/14/LeetCode-Algorithms-Construct-Binary-Tree-from-Preorder-and-Inorder-Traversal/
	http://bangbingsyb.blogspot.com/2014/11/leetcode-construct-binary-tree-from.html
	https://www.cnblogs.com/grandyang/p/4296500.html
	 */
	public static void main(String[] args) {
		n105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal obj = new n105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal();
		System.out.println(obj.buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7}));
	}
}
