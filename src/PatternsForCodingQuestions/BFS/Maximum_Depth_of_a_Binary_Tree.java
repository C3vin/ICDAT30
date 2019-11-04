package PatternsForCodingQuestions.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Maximum_Depth_of_a_Binary_Tree {
	public static int findDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int maximumTreeDepth = 0;

		while(!queue.isEmpty()) {
			maximumTreeDepth++;
			int levelSize = queue.size();
			for(int i=0; i<levelSize; i++) {
				TreeNode currentNode = queue.poll();
				
				if(currentNode.left != null) {
					queue.offer(currentNode.left);
				}
				if(currentNode.right != null) {
					queue.offer(currentNode.right);
				}
			}
		}
		return maximumTreeDepth;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		System.out.println("Tree Maximum Depth: " + Maximum_Depth_of_a_Binary_Tree.findDepth(root));
		root.left.left = new TreeNode(9);
		root.right.left.left = new TreeNode(11);
		System.out.println("Tree Maximum Depth: " + Maximum_Depth_of_a_Binary_Tree.findDepth(root));
	}
}
