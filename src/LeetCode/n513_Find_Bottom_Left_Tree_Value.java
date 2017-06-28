package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class n513_Find_Bottom_Left_Tree_Value {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	public int findBottomLeftValue(TreeNode root) {
		if(root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		while(!queue.isEmpty()) {
			root = queue.poll();
			if(root.right != null) 
				queue.offer(root.right);
			if(root.left != null)
				queue.offer(root.left);
		}
		return root.val;
	}

	public int findBottomLeftValue2(TreeNode root) {
        if(root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int res = 0;
		
		while(!queue.isEmpty()) {
			TreeNode tmp = queue.poll();
			if(queue.peek() == null)			//improvement: Just first time (1) and last time (7) will add res!
				res = tmp.val;
			if(tmp.right != null) 
				queue.offer(tmp.right);
			if(tmp.left != null)
				queue.offer(tmp.left);
		}
		return res;
	}

	public static void main(String[] args) {	
		n513_Find_Bottom_Left_Tree_Value obj = new n513_Find_Bottom_Left_Tree_Value();
		TreeNode p1 = obj.new TreeNode(1);
		TreeNode p2 = obj.new TreeNode(2);
		TreeNode p3 = obj.new TreeNode(3);
		TreeNode p4 = obj.new TreeNode(4);
		TreeNode p5 = obj.new TreeNode(5);
		TreeNode p6 = obj.new TreeNode(6);
		TreeNode p7 = obj.new TreeNode(7);
		TreeNode p8 = obj.new TreeNode(8);
		p1.left = p2;
		p1.right = p3;
		p2.left = p4;
		p3.left = p5;
		p3.right = p6;
		p5.left = p7;
		p6.left = p8;
		System.out.println(p1.val + " " + p1.left.val + " " + p1.right.val + " "+ p2.left.val + " " + p3.left.val 
				+ " " + p3.right.val);

		System.out.println(obj.findBottomLeftValue(p1));
		System.out.println(obj.findBottomLeftValue2(p1));
	}
}
