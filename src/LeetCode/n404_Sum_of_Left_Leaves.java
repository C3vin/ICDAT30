package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class n404_Sum_of_Left_Leaves {
	public class TreeNode {
		int val;
		String v;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		TreeNode(String v) {v = null;}
	}
	public int sumOfLeftLeaves(TreeNode root) {
		if(root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int res = 0;
		
		while(!queue.isEmpty()) {
			TreeNode tmp = queue.poll();
			if(tmp.left != null && tmp.left.left == null && tmp.left.right == null)
				res = res + tmp.left.val;
			if(tmp.left != null)
				queue.offer(tmp.left);
			if(tmp.right != null)
				queue.offer(tmp.right);
		}
		return res;
	}
	
	//DFS
	public int sumOfLeftLeaves2(TreeNode root) {
		if(root == null)
			return 0;
		
		if(root.left != null && root.left.left == null && root.left.right == null) 
			return root.left.val + sumOfLeftLeaves2(root.right);					//F: root.left.val
		
		return sumOfLeftLeaves2(root.left) + sumOfLeftLeaves2(root.right);
	}
	public static void main(String[] args) {
		n404_Sum_of_Left_Leaves obj = new n404_Sum_of_Left_Leaves();
		TreeNode p1 = obj.new TreeNode(3);
		TreeNode p2 = obj.new TreeNode(9);
		TreeNode p3 = obj.new TreeNode(20);
		TreeNode p4 = obj.new TreeNode(15);
		TreeNode p5 = obj.new TreeNode(7);
		p1.left = p2;
		p1.right = p3;
		p3.left = p4;
		p3.right = p5;
		
		System.out.println(obj.sumOfLeftLeaves(p1));
		System.out.println(obj.sumOfLeftLeaves2(p1));
	}
}
