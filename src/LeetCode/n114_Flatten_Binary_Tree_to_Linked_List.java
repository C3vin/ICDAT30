package LeetCode;

import java.util.Stack;

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

	//BT template 
	public void flatten3(TreeNode root) {
		//base case
		if(root == null) {
			return;
		}

		//1. start flatten into a linked list
		flatten3(root.left);		//need to be first
		flatten3(root.right);

		//post-order !
		TreeNode left = root.left;
		TreeNode right = root.right;

		//2. move left under right node, replace the original right 
		root.left = null;    
		root.right = left;

		//3. get the original right node under new right node
		TreeNode tmp = root;
		while(tmp.right != null) {
			tmp = tmp.right;    
		}
		tmp.right = right;
		
	}

	public void flatten(TreeNode root) {
		//Preorder 
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

	//not use
	public void flatten2(TreeNode root) {
		if(root == null) {
			return; 
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		while(!stack.isEmpty()) {
			TreeNode currentNode = stack.pop();
			if(currentNode.right != null) {
				stack.push(currentNode.right);
			}
			if(currentNode.left != null) {
				stack.push(currentNode.left);
			}
			if(!stack.isEmpty()) {
				currentNode.right = stack.peek();	//why not push, cuz still need to go next round
			}
			currentNode.left = null;
		}
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

		//obj.flatten(p1);
		//obj.flatten2(p1);
		obj.flatten3(p1);
		System.out.println(p1.val + " -> " + p1.right.val);
	}
}
