package PatternsForCodingQuestions.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Minimum_Depth_of_a_Binary_Tree {
	public static int findDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int minimumTreeDepth = 0;
		
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			minimumTreeDepth++;		//add one for each level(depth)
			for(int i=0; i<levelSize; i++) {
				TreeNode currentNode = queue.poll();
				
				// check if this is a leaf node
				if(currentNode.left == null && currentNode.right == null) {
					return minimumTreeDepth; 
				}
				
				if(currentNode.left != null) {
					queue.offer(currentNode.left);
				}
				if(currentNode.right != null) {
					queue.offer(currentNode.right);
				}
			}
		}
		return minimumTreeDepth;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		System.out.println("Tree Minimum Depth: " + Minimum_Depth_of_a_Binary_Tree.findDepth(root));
		root.left.left = new TreeNode(9);
		root.right.left.left = new TreeNode(11);
		System.out.println("Tree Minimum Depth: " + Minimum_Depth_of_a_Binary_Tree.findDepth(root));
	}
}
