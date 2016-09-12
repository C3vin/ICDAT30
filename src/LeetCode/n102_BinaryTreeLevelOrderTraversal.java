package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class n102_BinaryTreeLevelOrderTraversal {
	public class TreeNode {
		int val;
		String v;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		TreeNode(String v) { v = null; }
	}
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		
		if(root != null) 
			queue.add(root);
		else
			return results;
		int w = 1;

		List<Integer> r = new ArrayList<Integer>();
		while(queue.size() > 0) {
			TreeNode p = queue.poll();
			System.out.println(p.val);
			r.add(p.val);
			System.out.println("queue size: "+queue.size());
			if(p.left != null) queue.add(p.left);
			if(p.right != null) queue.add(p.right);

			if(r.size() == w) {
				System.out.println("r: " +r.size() + " w: " +w);
				System.out.println("queue size2: "+queue.size());
				w = queue.size();
				results.add(r);
				r = new ArrayList<Integer>();
			}
		}
		return results;
	}

	public static void main(String[] args) {
		//[3,9,20,null,null,15,7]
		/**
		 * [
  			[3],
  			[9,20],
  			[15,7]
		   ]
		 */
		n102_BinaryTreeLevelOrderTraversal obj = new n102_BinaryTreeLevelOrderTraversal();
		TreeNode p1 = obj.new TreeNode(3);
		TreeNode p2 = obj.new TreeNode(9);
		TreeNode p3 = obj.new TreeNode(20);
		TreeNode p4 = obj.new TreeNode(null);
		TreeNode p5 = obj.new TreeNode(null);
		TreeNode p6 = obj.new TreeNode(15);
		TreeNode p7 = obj.new TreeNode(7);
		p1.left = p2;
		p1.right = p3;
		p1.left = p2;
		p2.right = p5;
		p2.left = p4;
		p3.right = p7;
		p3.left = p6;
		
		System.out.println(p1.val + " " + p1.left.val + " " + p1.right.val + " "+ p2.left.v + " " + p2.right.v + " " + p3.left.val + " " +p3.right.val);
		System.out.println(obj.levelOrder(p1));
	}
}
