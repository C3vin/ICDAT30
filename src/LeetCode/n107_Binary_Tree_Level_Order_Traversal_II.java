package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class n107_Binary_Tree_Level_Order_Traversal_II {
	public class TreeNode {
		int val;
		String v;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		TreeNode(String v) { v = null; }
	}
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		if(root == null)
			return res;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		queue.offer(null);
		
		List<Integer> cur = new LinkedList<Integer>();			//F: need this
		
		while(!queue.isEmpty()) {
			TreeNode tmp = queue.poll();
			if(tmp != null) {
				cur.add(tmp.val);
				if(tmp.left != null)
					queue.offer(tmp.left);
				if(tmp.right != null)
					queue.offer(tmp.right);
			} else {
				res.add(0, cur);
				cur = new LinkedList<Integer>();	
				if(!queue.isEmpty())
					queue.offer(null);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		n107_Binary_Tree_Level_Order_Traversal_II obj = new n107_Binary_Tree_Level_Order_Traversal_II();
		TreeNode p1 = obj.new TreeNode(3);
		TreeNode p2 = obj.new TreeNode(9);
		TreeNode p3 = obj.new TreeNode(20);
		TreeNode p4 = obj.new TreeNode(15);
		TreeNode p5 = obj.new TreeNode(7);
		p1.left = p2;
		p1.right = p3;
		p3.left = p4;
		p3.right = p5;
		
		System.out.println(obj.levelOrderBottom(p1));
	}
}
