package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class n515_Find_Largest_Value_in_Each_Tree_Row {
	public class TreeNode {
		int val;
		String v;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		TreeNode(String v) {v = null;}
	}
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> res = new LinkedList<Integer>();
		if(root == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		queue.offer(null);
		
		int max = Integer.MIN_VALUE;
		while(!queue.isEmpty()) {
			TreeNode tmp = queue.poll();
			
			if(tmp != null) {
				max = Math.max(max, tmp.val);		//need to put in here! 
				if(tmp.left != null)
					queue.offer(tmp.left);
				if(tmp.right != null)
					queue.offer(tmp.right);
			} else {
				res.add(max);
				max = Integer.MIN_VALUE;
				if(!queue.isEmpty())
					queue.offer(null);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		n515_Find_Largest_Value_in_Each_Tree_Row obj = new n515_Find_Largest_Value_in_Each_Tree_Row();
		TreeNode p1 = obj.new TreeNode(1);
		TreeNode p2 = obj.new TreeNode(3);
		TreeNode p3 = obj.new TreeNode(2);
		TreeNode p4 = obj.new TreeNode(5);
		TreeNode p5 = obj.new TreeNode(3);
		TreeNode p6 = obj.new TreeNode(9);
		p1.left = p2;
		p1.right = p3;
		p2.left = p4;
		p2.right = p5;
		p3.right = p6;
		System.out.println(obj.largestValues(p1));
	}
}
