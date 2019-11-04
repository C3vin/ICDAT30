package PatternsForCodingQuestions.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Tree_Boundary {
	public static List<TreeNode> findBoundary(TreeNode root) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		if(root == null) {
			return result;
		}

		List<TreeNode> leftView = new ArrayList<TreeNode>();
		List<TreeNode> rightView = new LinkedList<TreeNode>();

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			for(int i=0; i<levelSize; i++) {
				TreeNode currentNode = queue.poll();

				if(currentNode.left == null && currentNode.right == null) {
					continue;
				} else if(i == 0) {
					leftView.add(currentNode);
				} else if(i == levelSize-1) {
					rightView.add(0, currentNode);
				}

				if(currentNode.left != null) {
					queue.offer(currentNode.left);
				}
				if(currentNode.right != null) {
					queue.offer(currentNode.right);
				}
			}
		}
		result.addAll(leftView);
		result.addAll(findLeavesDFS(root));
		result.addAll(rightView);

		return result;
	}
	private static List<TreeNode> findLeavesDFS(TreeNode root) {
		List<TreeNode> leaves = new ArrayList<>();
		//...
		return leaves;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.left.left.left = new TreeNode(9);
		root.left.right = new TreeNode(3);
		root.left.right.left = new TreeNode(15);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		root.right.right.left = new TreeNode(6);
		List<TreeNode> result = Tree_Boundary.findBoundary(root);
		for (TreeNode node : result) {
			System.out.print(node.val + " ");
		}
	}
}
