package DSA;

import java.util.LinkedList;
import java.util.Queue;

public class Q6_3n4_searching_element_in_binary_tree {
	public class TreeNode {
		int val;
		String v;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		TreeNode(String v) { v = null; }
	}
	
	public boolean findInBT(TreeNode root, int data){
		if(root == null)
			return false;
		if(root.val == data) 
			return true;
		
		return findInBT(root.left, data) || findInBT(root.right, data); 
	}
	
	//sol2: using level order traversal  
	public boolean findInBT2(TreeNode root, int data){
		if(root == null) return false;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			TreeNode tmp = queue.poll();
			if(tmp.val == data)
				return true;
			
			if(tmp.left != null) 
				queue.offer(tmp.left);
			if(tmp.right != null)
				queue.offer(tmp.right);
		}
		return false;
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
		Q6_3n4_searching_element_in_binary_tree obj = new Q6_3n4_searching_element_in_binary_tree();
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
		System.out.println(obj.findInBT(p1, 3));
		System.out.println(obj.findInBT2(p1, 3));
	}
}
