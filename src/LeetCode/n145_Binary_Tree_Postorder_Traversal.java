package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given a binary tree, return the postorder traversal of its nodes' values.

Example:
Input: [1,null,2,3]
   1
    \
     2
    /
   3
Output: [3,2,1]
Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class n145_Binary_Tree_Postorder_Traversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	//Recursion
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		helper(root, res);
		
		return res;
	}
	private void helper(TreeNode root, List<Integer> res) {
		if(root == null) {
			return;
		}
		
		helper(root.left, res);
		helper(root.right, res);
		res.add(root.val);
	}
	
	//Iteration DFS
	public List<Integer> postorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode last = null;
		
		while(root != null || !stack.isEmpty()) {
			if(root != null) {
				stack.push(root);
				root = root.left;
			} else {
				TreeNode tmpNode = stack.peek();	//can't use root, it will infinite
				
				if(tmpNode.right != null && tmpNode.right != last) {	//must && 
					root = tmpNode.right;		//F: tmpNode not root
				} else {
					res.add(tmpNode.val);
					last = tmpNode;				//update last when  add into res
					stack.pop();
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		n145_Binary_Tree_Postorder_Traversal obj = new n145_Binary_Tree_Postorder_Traversal();
		TreeNode p1 = obj.new TreeNode(1);
		TreeNode p2 = obj.new TreeNode(2);
		TreeNode p3 = obj.new TreeNode(3);
		TreeNode p4 = obj.new TreeNode(4);
		TreeNode p5 = obj.new TreeNode(5);
		TreeNode p6 = obj.new TreeNode(6);
		p1.left = p2;
		p1.right = p3;
		p2.left = p4;
		p2.right = p5;
		p3.left = p6;

		System.out.println(obj.postorderTraversal(p1));
		System.out.println(obj.postorderTraversal2(p1));
	}
}
