package PatternsForCodingQuestions.DFS;

public class Sum_of_Path_Numbers {
	public static int findSumOfPathNumbers(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int pathSum = 0;
		return findRootToLeafPathNumbers(root, pathSum);
	}
	private static int findRootToLeafPathNumbers(TreeNode currentNode, int pathSum) {
		if(currentNode == null) {
			return 0;
		}
		
		// calculate the path number of the current node
		pathSum = pathSum * 10 + currentNode.val;
		// if the current node is a leaf, return the current path sum.
		if(currentNode.left == null && currentNode.right == null) {
			return pathSum;
		}
		
		//+
		return findRootToLeafPathNumbers(currentNode.left, pathSum) + findRootToLeafPathNumbers(currentNode.right, pathSum);
	}
	public static void main(String[] args) {
	    TreeNode root = new TreeNode(1);
	    root.left = new TreeNode(0);
	    root.right = new TreeNode(1);
	    root.left.left = new TreeNode(1);
	    root.right.left = new TreeNode(6);
	    root.right.right = new TreeNode(5);
	    System.out.println("Total Sum of Path Numbers: " + Sum_of_Path_Numbers.findSumOfPathNumbers(root));
	  }
}
