package PatternsForCodingQuestions.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Level_Order_Successor {
	public static TreeNode findSuccessor(TreeNode root, int key) {
		if(root == null) {
			return null;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		while(!queue.isEmpty()) {
			//int levelSize = queue.size();		//No need to track of all the levels
			//for(int i=0; i<levelSize; i++) {
				TreeNode currentNode = queue.poll();

				if(currentNode.left != null) {
					queue.offer(currentNode.left);
				}
				if(currentNode.right != null) {
					queue.offer(currentNode.right);
				}
				// break if we have found the key
				if(currentNode.val == key) {
					break;
				}
			//}
		}
		return queue.peek();
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		TreeNode result = Level_Order_Successor.findSuccessor(root, 12);
		if (result != null)
			System.out.println(result.val + " ");
		result = Level_Order_Successor.findSuccessor(root, 9);
		if (result != null)
			System.out.println(result.val + " ");
	}
}
