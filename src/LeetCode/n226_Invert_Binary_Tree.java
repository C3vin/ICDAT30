package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

@Alg(type="tree", com="NA", level="easy", num=226)
public class n226_Invert_Binary_Tree {
	/*
	 *      
	 4
   /   \
  2     7
 / \   / \				             
1   3 6   9

to 
	 4
   /   \
  7     2
 / \   / \				             
9   6 3   1
	 */

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public TreeNode invertTree(TreeNode root) {
		if(root == null) return root;		//need to return root!

		//SWAP
		TreeNode tmp = root.left;				
		root.left = invertTree(root.right);			//need invertTree() or won't change the subtree
		root.right = invertTree(tmp	);

		return root;
	}
	public TreeNode invertTree2(TreeNode root) {
		if(root == null)
			return root;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			
			//SWAP
			TreeNode tmp = node.left;
			node.left = node.right;
			node.right = tmp;     

			if(node.left != null) 
				queue.offer(node.left);
			if(node.right != null)
				queue.offer(node.right);
		}
		return root;
	}
	public static void main(String[] args) {
		n226_Invert_Binary_Tree obj = new n226_Invert_Binary_Tree();
		TreeNode t1 = obj.new TreeNode(4);
		TreeNode t2 = obj.new TreeNode(2);
		TreeNode t3 = obj.new TreeNode(7);
		TreeNode t4 = obj.new TreeNode(1);
		TreeNode t5 = obj.new TreeNode(3);
		TreeNode t6 = obj.new TreeNode(6);
		TreeNode t7 = obj.new TreeNode(9);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		System.out.println(t1.val + " " + t1.left.val + " " + t1.right.val);
		System.out.println(obj.invertTree(t1).left.val);
		System.out.println(obj.invertTree2(t1).left.val);	//diff than sol1, cuz tree invert already
	}
}