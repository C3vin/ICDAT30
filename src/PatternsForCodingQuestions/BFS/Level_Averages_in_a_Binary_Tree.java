package PatternsForCodingQuestions.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Level_Averages_in_a_Binary_Tree {
	public static List<Double> findLevelAverages(TreeNode root) {
		List<Double> result = new ArrayList<Double>();
		if(root == null) {
			return result;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			double sum = 0;
			for(int i=0; i<levelSize; i++) {
				TreeNode currentNode = queue.poll();
				// add the node's value to the running sum
				sum = sum + currentNode.val;
				
				if(currentNode.left != null) {
					queue.offer(currentNode.left);
				}
				if(currentNode.right != null) {
					queue.offer(currentNode.right);
				}
			}
			// append the current level's average to the result array
			result.add(sum / levelSize);
		}
		
		return result;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		List<Double> result = Level_Averages_in_a_Binary_Tree.findLevelAverages(root);
		System.out.print("Level averages are: " + result);
	}
}
