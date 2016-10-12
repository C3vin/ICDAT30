package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class n257_Binary_Tree_Paths {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public List<String> resultList = new ArrayList<String>();

	public List<String> binaryTreePaths(TreeNode root) {
		if (root == null) {
			return resultList;
		}
		ArrayList<String> curr = new ArrayList<String>();
		ArrayList<ArrayList<String>> singleResult = new ArrayList<ArrayList<String>>();	 	//ArrayList<ArrayList<String> to store multiple results
		
		getTreePath(root, singleResult, curr);

		for(ArrayList<String> s : singleResult) {
			StringBuilder sb = new StringBuilder();
			sb.append(s.get(0));
			for(int i=1; i<s.size(); i++) {   //start at second ->
				sb.append("->" + s.get(i));
			}
			resultList.add(sb.toString());
		}

		return resultList;
	}
	private void getTreePath(TreeNode node, ArrayList<ArrayList<String>> singleResult, ArrayList<String> curr) {
		curr.add(String.valueOf(node.val));	//Returns the string representation of the int argument.
		if (node.left == null && node.right == null) {
			singleResult.add(curr);
			return;
		}
		if (node.left != null) {
			ArrayList<String> temp = new ArrayList<String>(curr);			//??
			getTreePath(node.left, singleResult, temp);
		}
		if (node.right != null) {
			ArrayList<String> temp = new ArrayList<String>(curr);
			getTreePath(node.right, singleResult, temp);
		}
	}

	public static void main(String[] args) {
		n257_Binary_Tree_Paths obj = new n257_Binary_Tree_Paths();
		TreeNode p1 = obj.new TreeNode(1);
		TreeNode p2 = obj.new TreeNode(2);
		TreeNode p3 = obj.new TreeNode(3);
		TreeNode p5 = obj.new TreeNode(5);
		p1.left = p2;
		p1.right = p3;
		p2.right = p5;
		System.out.println(obj.binaryTreePaths(p1));
	}
}
