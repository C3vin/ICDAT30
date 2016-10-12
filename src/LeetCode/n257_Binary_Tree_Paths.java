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

	//sol2
	public List<String> resultList2 = new ArrayList<String>();
	public List<String> binaryTreePaths2(TreeNode root) {
		if(root == null) 
			return resultList2;
		getPath(root, root.val + "");
		
		return resultList2;
	}
	private void getPath(TreeNode node, String path) {
		if(node.left == null && node.right == null) 
			resultList2.add(path);
		if(node.left != null)
			getPath(node.left, path + "->" + node.left.val);
		if(node.right != null)
			getPath(node.right, path + "->" + node.right.val);
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
		System.out.println(obj.binaryTreePaths2(p1));
	}
}
