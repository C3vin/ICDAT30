package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
Consider all the leaves of a binary tree.  From left to right order, 
the values of those leaves form a leaf value sequence.

For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
Two binary trees are considered leaf-similar if their leaf value sequence is the same.
Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

Note:

Both of the given trees will have between 1 and 100 nodes.
 */
public class n872_Leaf_Similar_Trees {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    	List<Integer> leafRoot1 = new ArrayList<Integer>();
    	List<Integer> leafRoot2 = new ArrayList<Integer>();
    	
    	helper(root1, leafRoot1);
    	helper(root2, leafRoot2);
    	
    	return leafRoot1.equals(leafRoot2);
    }
    private void helper(TreeNode root, List<Integer> leafRoot) {
    	if(root == null) {
    		return;
    	}
    	
    	if(root.left == null && root.right == null) {
    		leafRoot.add(root.val);
    	}
    	
    	helper(root.left, leafRoot);
    	helper(root.right, leafRoot);
    }
    
    public static void main(String[] args) {
    	n872_Leaf_Similar_Trees obj = new n872_Leaf_Similar_Trees();
		TreeNode p1 = obj.new TreeNode(1);
		TreeNode p2 = obj.new TreeNode(2);
		TreeNode p3 = obj.new TreeNode(3);
		TreeNode p4 = obj.new TreeNode(4);
		TreeNode p5 = obj.new TreeNode(5);
		p1.left = p2;
		p1.right = p3;
		p2.right = p5;
		p3.right = p4;
		TreeNode q1 = obj.new TreeNode(1);
		TreeNode q2 = obj.new TreeNode(2);
		TreeNode q3 = obj.new TreeNode(3);
		TreeNode q4 = obj.new TreeNode(4);
		TreeNode q5 = obj.new TreeNode(5);
		q1.left = q2;
		q1.right = q3;
		q2.right = q5;
		q3.right = q4;
    	System.out.println(obj.leafSimilar(p1, q1));
    }
}
