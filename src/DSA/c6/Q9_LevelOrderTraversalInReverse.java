package DSA.c6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q9_LevelOrderTraversalInReverse {
	public class TreeNode {
		int val;
		String v;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		TreeNode(String v) { v = null; }
	}
	
	//orig sol has a bug, fixed. right first, then left
	public void levelOrderTraversalInReverse(TreeNode root) {
		if(root == null) 
			return;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while(!queue.isEmpty()) {
			TreeNode tmp = queue.poll();
			if(tmp.right != null) 
				queue.offer(tmp.right);
			if(tmp.left != null)
				queue.offer(tmp.left);
			stack.push(tmp);
		}
		
		while(!stack.isEmpty()) 
			System.out.print(stack.pop().val + " ");
		
	}
	public static void main(String[] args) {
		Q9_LevelOrderTraversalInReverse obj = new Q9_LevelOrderTraversalInReverse();
		TreeNode p1 = obj.new TreeNode(1);
		TreeNode p2 = obj.new TreeNode(2);
		TreeNode p3 = obj.new TreeNode(3);
		TreeNode p4 = obj.new TreeNode(4);
		TreeNode p5 = obj.new TreeNode(5);
		TreeNode p6 = obj.new TreeNode(6);
		TreeNode p7 = obj.new TreeNode(7);
		p1.left = p2;
		p1.right = p3;
		p1.left = p2;
		p2.right = p5;
		p2.left = p4;
		p3.right = p7;
		p3.left = p6;

		System.out.println(p1.val + " " + p1.left.val + " " + p1.right.val + " "+ p2.left.val + " " + p2.right.val + " " + p3.left.val + " " +p3.right.val);
		obj.levelOrderTraversalInReverse(p1);
	}
}
