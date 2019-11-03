package PatternsForCodingQuestions.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
};
public class Binary_Tree_Level_Order_Traversal {
	//time:O(n) space:O(n)
	//BFS - Queue
	private static List<List<Integer>> traverse(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> currentLevel = new ArrayList<Integer>(levelSize);
			for(int i=0; i<levelSize; i++) {
				TreeNode currentNode = queue.poll();
				currentLevel.add(currentNode.val);

				if(currentNode.left != null) {
					queue.offer(currentNode.left);
				}
				if(currentNode.right != null) {
					queue.offer(currentNode.right);
				}
			}
			result.add(currentLevel);
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
		List<List<Integer>> result = Binary_Tree_Level_Order_Traversal.traverse(root);
		System.out.println("Level order traversal: " + result);
	}
}
