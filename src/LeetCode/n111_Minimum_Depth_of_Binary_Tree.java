package LeetCode;

/*
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
Note: A leaf is a node with no children.
Example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.

case2:
     3
    / \
   9   20
  /   /  \
 8   15   7
return its minimum depth = 2.
 */
import java.util.LinkedList;
import java.util.Queue;

import LeetCode.n104_Maximum_Depth_of_Binary_Tree.TreeNode;
public class n111_Minimum_Depth_of_Binary_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	//Recursive
	//[LC104 - LC111 template]
	public int minDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}

		//so we can use he same LC104 template
		if(root.left == null) {		//no left, ONLY check right
			return minDepth(root.right)+1;
		}

		if(root.right == null) {	//no right, ONLY check left
			return minDepth(root.left)+1;
		}

		int leftDepth = minDepth(root.left);
		int rightDepth = minDepth(root.right);

		return Math.min(leftDepth, rightDepth) + 1;
	}

	//BFS 
	//[LC104 - LC111 template]
	public int minDepth2(TreeNode root) {
		if(root == null) {
			return 0;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		int level = 0;

		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			for(int i=0; i<levelSize; i++) {
				TreeNode currentNode = queue.poll();

				if(currentNode.left == null && currentNode.right == null) {
					level++;			//so we can use he same LC104 template
					return level;
				}

				if(currentNode.left != null) {
					queue.offer(currentNode.left);
				}
				if(currentNode.right != null) {
					queue.offer(currentNode.right);
				}
			}
			level++;
		}

		return level;
	}

	public static void main(String[] args) {
		n111_Minimum_Depth_of_Binary_Tree obj = new n111_Minimum_Depth_of_Binary_Tree();
		TreeNode p1 = obj.new TreeNode(1);
		TreeNode p2 = obj.new TreeNode(2);
		TreeNode p3 = obj.new TreeNode(3);
		TreeNode p4 = obj.new TreeNode(4);
		p1.left = p2;
		p1.right = p3;
		p2.left = p4;
		System.out.println(obj.minDepth(p1));
		System.out.println(obj.minDepth2(p1));
	}
}
