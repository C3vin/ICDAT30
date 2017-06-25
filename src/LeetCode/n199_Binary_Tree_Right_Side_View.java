package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class n199_Binary_Tree_Right_Side_View {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new LinkedList<Integer>();
		if(root == null)
			return res;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		queue.offer(null);
		
		while(!queue.isEmpty()) {
			TreeNode tmp = queue.poll();
			
			if(tmp != null) {
				if(queue.peek() == null)
					res.add(tmp.val);
				if(tmp.left != null) 					//must left first, because we need NULL 
					queue.offer(tmp.left);
				if(tmp.right != null)				
					queue.offer(tmp.right);
			} else {
				if(!queue.isEmpty())
					queue.offer(null);
			}
		}
		return res;
	}
	
	//sol2: DFS
	int maxdepth = 0;									//F: need to use global variables
	public List<Integer> rightSideView2(TreeNode root) {
		List<Integer> res = new LinkedList<Integer>();
		
		if(root != null)
			helper(root, res, 1);
		
		return res;
	}
	private void helper(TreeNode root, List<Integer> res, int depth) {
		if(maxdepth < depth) {
			maxdepth = depth;
			res.add(root.val);
		}
		if(root.right != null)					//this time, we need to do right first
			helper(root.right, res, depth+1);
		if(root.left != null)
			helper(root.left, res, depth+1);
	}

	public static void main(String[] args) {
		n199_Binary_Tree_Right_Side_View obj = new n199_Binary_Tree_Right_Side_View();
		TreeNode p1 = obj.new TreeNode(1);
		TreeNode p2 = obj.new TreeNode(2);
		TreeNode p3 = obj.new TreeNode(3);
		TreeNode p5 = obj.new TreeNode(4);
		p1.left = p2;
		p1.right = p3;
		p2.right = p5;
		System.out.println(obj.rightSideView(p1));
		System.out.println(obj.rightSideView2(p1));
	}
}
