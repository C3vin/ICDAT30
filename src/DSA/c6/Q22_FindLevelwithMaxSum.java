package DSA.c6;

import java.util.LinkedList;
import java.util.Queue;

public class Q22_FindLevelwithMaxSum {
	public class TreeNode {
		int val;
		String v;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		TreeNode(String v) { v = null; }
	}
	public int findLevelwithMaxSum(TreeNode root) {
		int maxSum = 0, currentSum = 0;
		if (root == null)
			return 0;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		queue.offer(null);

		while(!queue.isEmpty()) {
			TreeNode tmp = queue.poll();

			if(tmp != null) {
				currentSum = currentSum + tmp.val;
				
				if(tmp.left != null)
					queue.offer(tmp.left);
				if(tmp.right != null)
					queue.offer(tmp.right);
			} else {
				if(currentSum > maxSum) {
					maxSum = currentSum;
				}
				currentSum = 0;		//F: don't forget to return default 0
				// completion of a level;
				if(!queue.isEmpty()) 
					queue.offer(null);
			}
		}
		return maxSum;
	}
	public static void main(String[] args) {
		Q22_FindLevelwithMaxSum obj = new Q22_FindLevelwithMaxSum();
		TreeNode p1 = obj.new TreeNode(1);
		TreeNode p2 = obj.new TreeNode(2);
		TreeNode p3 = obj.new TreeNode(3);
		TreeNode p4 = obj.new TreeNode(4);
		TreeNode p5 = obj.new TreeNode(5);
		TreeNode p6 = obj.new TreeNode(6);
		TreeNode p7 = obj.new TreeNode(7);
		p1.left = p2;
		p1.right = p3;
		p2.right = p5;
		p2.left = p4;
		p3.right = p7;
		p3.left = p6;

		System.out.println(p1.val + " " + p1.left.val + " " + p1.right.val + " "+ p2.left.val + " " + p2.right.val + " " + p3.left.val + " " +p3.right.val);
		System.out.println(obj.findLevelwithMaxSum(p1));
	}
}
