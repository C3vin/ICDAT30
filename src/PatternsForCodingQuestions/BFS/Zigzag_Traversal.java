package PatternsForCodingQuestions.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Zigzag_Traversal {
	public static List<List<Integer>> traverse(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		boolean leftToRight = true;

		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> currentLevel = new LinkedList<Integer>();
			for(int i=0; i<levelSize; i++) {
				TreeNode currentNode = queue.poll();

				if(leftToRight) {
					currentLevel.add(currentNode.val);
				} else {
					currentLevel.add(0, currentNode.val);
				}

				if(currentNode.left != null) {
					queue.offer(currentNode.left);
				} 
				if(currentNode.right != null) {
					queue.offer(currentNode.right);
				}
			}
			result.add(currentLevel);
			leftToRight = !leftToRight;			//must use !
		}

		return result;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(17);
		List<List<Integer>> result = Zigzag_Traversal.traverse(root);
		System.out.println("Zigzag traversal: " + result);
	}
}
