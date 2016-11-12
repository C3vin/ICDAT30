package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Alg(type="BFS", com="L,AA,A,M$,F", level="easy", num=102)
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
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		if(root == null) return res;

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>(); 
		queue.add(root);

		int curlevel = 0;
		int lastlevel = 1;

		while(!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			lastlevel--;
			tmp.add(cur.val);

			if(cur.left != null) {
				queue.add(cur.left);		//queue not tmp
				curlevel++;
			}
			if(cur.right != null) {
				queue.add(cur.right);
				curlevel++;
			}
			if(lastlevel == 0) {
				lastlevel = curlevel;
				curlevel = 0;
				res.add(tmp);
				tmp = new ArrayList<Integer>();
			}
		}
		return res;

		//Jidong
		/*		List<List<Integer>> results = new ArrayList<List<Integer>>();
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

		if(root != null) 
			queue.add(root);
		else
			return results;
		int current = 1;

		List<Integer> tmp = new ArrayList<Integer>();
		while(queue.size() > 0) {
			TreeNode p = queue.poll();
			System.out.println(p.val);
			tmp.add(p.val);
			System.out.println("queue size: "+queue.size());
			if(p.left != null) queue.add(p.left);
			if(p.right != null) queue.add(p.right);

			if(tmp.size() == current) {
				System.out.println("r: " +tmp.size() + " w: " +current);
				System.out.println("queue size2: "+queue.size());
				current = queue.size();
				results.add(tmp);
				tmp = new ArrayList<Integer>();
			}
		}
		System.out.println(results);
		return results;*/
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
