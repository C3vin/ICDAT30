package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class n112_Path_Sum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null)
			return false;
		
		sum = sum - root.val;
		System.out.println(sum);
		
		if(root.left == null && root.right == null)
			return sum == 0;	//F: in the latest node, if sum == 0 match it! 
		else
			return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
		
	}
	
	public boolean hasPathSum2(TreeNode root, int sum) {
		if(root == null)
			return false;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		Queue<Integer> value = new LinkedList<Integer>();
		value.offer(root.val);
		
		while(!queue.isEmpty()) {
			TreeNode tmp = queue.poll();
			int sumValue = value.poll();
			
			if(tmp.left == null && tmp.right == null && sumValue == sum) 
				return true;
			
			if(tmp.left != null) {
				queue.offer(tmp.left);
				value.offer(sumValue + tmp.left.val);
			}
			
			if(tmp.right != null) {
				queue.offer(tmp.right);
				value.offer(sumValue + tmp.right.val);
			}
		}
		return false;
	}
	public static void main(String[] args) {
		n112_Path_Sum obj = new n112_Path_Sum();
		TreeNode p1 = obj.new TreeNode(5);
		TreeNode p2 = obj.new TreeNode(4);
		TreeNode p3 = obj.new TreeNode(8);
		TreeNode p4 = obj.new TreeNode(11);
		TreeNode p5 = obj.new TreeNode(13);
		TreeNode p6 = obj.new TreeNode(4);
		TreeNode p7 = obj.new TreeNode(7);
		TreeNode p8 = obj.new TreeNode(2);
		TreeNode p9 = obj.new TreeNode(1);
		p1.left = p2;
		p1.right = p3;
		p2.left = p4;
		p3.left = p5;
		p3.right = p6;
		p4.left = p7;
		p4.right = p8;
		p6.right = p9;
		System.out.println(p1.val + " " + p1.left.val + " " + p1.right.val + " "+ p2.left.val + " " + p3.left.val 
				+ " " + p3.right.val + " " +p4.left.val + " " + p4.right.val + " " + p6.right.val);

		System.out.println(obj.hasPathSum(p1, 22));
		System.out.println(obj.hasPathSum2(p1, 22));
	}
}
