package LeetCode;

import java.util.LinkedList;

public class n101_Symmetric_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
		return isSymmetricTree(root.left, root.right);
	}
	//recursively 
	private boolean isSymmetricTree(TreeNode left, TreeNode right) {
		if(left == null && right == null) 
			return true;
		else if (left == null || right == null) 
			return false;

		if(left.val == right.val) {
			if(isSymmetricTree(left.left, right.right) && isSymmetricTree(left.right, right.left))
				return true;
		}
		else 
			return false;
		return false;
	}

	//iteratively
	public boolean isSymmetric2(TreeNode root) {
		    if(root == null)
		        return true;
		    if(root.left == null && root.right == null)
		        return true;
		    if(root.left == null || root.right == null)
		        return false;
		    LinkedList<TreeNode> q1 = new LinkedList<TreeNode>();
		    LinkedList<TreeNode> q2 = new LinkedList<TreeNode>();
		    q1.add(root.left);
		    q2.add(root.right);
		    while(!q1.isEmpty() && !q2.isEmpty()){
		        TreeNode n1 = q1.poll();
		        TreeNode n2 = q2.poll();
		        
		        if(n1.val != n2.val)
		            return false;
		        if((n1.left == null && n2.right != null) || (n1.left != null && n2.right == null))
		            return false;
		        if((n1.right == null && n2.left != null) || (n1.right != null && n2.left == null))
		            return false;
		        
		        if(n1.left != null && n2.right != null){
		            q1.add(n1.left);
		            q2.add(n2.right);
		        }
		        
		        if(n1.right != null && n2.left != null){
		            q1.add(n1.right);
		            q2.add(n2.left);
		        }            
		    }
		    return true;
	}
	
	public static void main(String[] args) {
		n101_Symmetric_Tree obj = new n101_Symmetric_Tree();
		TreeNode p1 = obj.new TreeNode(1);
		TreeNode p2 = obj.new TreeNode(2);
		TreeNode p3 = obj.new TreeNode(2);
		TreeNode p4 = obj.new TreeNode(3);
		TreeNode p5 = obj.new TreeNode(4);
		TreeNode p6 = obj.new TreeNode(4);
		TreeNode p7 = obj.new TreeNode(3);
		p1.left = p2;
		p1.right = p3;
		p1.left = p2;
		p2.right = p5;
		p2.left = p4;
		p3.right = p7;
		p3.left = p6;
		System.out.println(p1.val + " " + p1.left.val + " " + p1.right.val + " "+ p2.left.val + " " + p2.right.val + " " + p3.left.val + " " +p3.right.val);
		System.out.println(obj.isSymmetric(p1));
		System.out.println(obj.isSymmetric2(p1));
	}
}
