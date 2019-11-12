package LeetCode;

import LeetCode.n105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal.TreeNode;

/*
Given a binary tree, flatten it to a linked list in-place.
For example, given the following tree:
    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
 */
public class n114_Flatten_Binary_Tree_to_Linked_List {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	} 
	public void flatten(TreeNode root) {
		if(root == null) {
			return;
		}
		if(root.left != null) {
			flatten(root.left);
		}
		if(root.right != null) {
			flatten(root.right);
		}
		TreeNode currentNode = root.right;
		root.right = root.left;
		root.left = null;
		
		while(root.right != null) {
			root = root.right;
		}
		root.right = currentNode;
	} 
	public static void main(String[] args) {
		n114_Flatten_Binary_Tree_to_Linked_List obj = new n114_Flatten_Binary_Tree_to_Linked_List();
		TreeNode p1 = obj.new TreeNode(1);
		TreeNode p2 = obj.new TreeNode(2);
		TreeNode p3 = obj.new TreeNode(3);
		TreeNode p4 = obj.new TreeNode(4);
		TreeNode p5 = obj.new TreeNode(5);
		TreeNode p6 = obj.new TreeNode(6);
		p1.left = p2;
		p1.right = p5;
		p2.left = p3;
		p2.right = p4;
		p5.right = p6;
		
		obj.flatten(p1);
	}
}
