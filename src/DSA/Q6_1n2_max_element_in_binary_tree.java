package DSA;

import java.util.LinkedList;
import java.util.Queue;

public class Q6_1n2_max_element_in_binary_tree {
	public class TreeNode {
		int val;
		String v;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		TreeNode(String v) { v = null; }
	}
	
	public int findMaxElement(TreeNode root) {
		int maxValue = Integer.MIN_VALUE;
		if(root != null) {
			int leftMax = findMaxElement(root.left);
			int rightMax = findMaxElement(root.right);
			
			if(leftMax > rightMax) {
				maxValue = leftMax;
			} else
				maxValue = rightMax;
			
			if(root.val > maxValue)
				maxValue = root.val;
		}
		return maxValue;
	}
	//sol, using level order traversal to sol this without recursion q
	public int findMaxElement2(TreeNode root) {
		int maxValue = Integer.MIN_VALUE;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root); 	//no need to add null
		
		while(!queue.isEmpty()) {
			TreeNode tmp = queue.poll();
			if(tmp.val > maxValue) 
				maxValue = tmp.val;
			
			if(tmp.left != null)
				queue.offer(tmp.left);
			if(tmp.right != null)
				queue.offer(tmp.right);
		}
		
		return maxValue;
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
		Q6_1n2_max_element_in_binary_tree obj = new Q6_1n2_max_element_in_binary_tree();
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
		System.out.println(obj.findMaxElement(p1));
		System.out.println(obj.findMaxElement2(p1));
	}
}
