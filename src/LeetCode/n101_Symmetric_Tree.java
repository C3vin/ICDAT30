package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
    1
   / \
  2   2
 / \ / \
3  4 4  3

But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
 */
public class n101_Symmetric_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	//O(n) O(n)
	public boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
		return isSymmetricTree(root.left, root.right);
	}
	//recursive
	//DFS
	private boolean isSymmetricTree(TreeNode pLeft, TreeNode pRight) {
		if(pLeft == null && pRight == null) {		//must on the top, handle leaf
			return true;
		}
		if(pLeft.val != pRight.val) {
			return false;
		}
		if(pLeft == null || pRight == null) {
			return false;
		}

		return isSymmetricTree(pLeft.left, pRight.right) && isSymmetricTree(pLeft.right, pRight.left);
	}

	//iteratively
	//DFS
	public boolean isSymmetric2(TreeNode root) {
		if(root == null) {
			return true;
		}
		if(root.left == null && root.right == null) {
			return true;
		}
		if(root.left == null || root.right == null) {
			return false;
		}
		LinkedList<TreeNode> leftNode = new LinkedList<TreeNode>();
		LinkedList<TreeNode> rightNode = new LinkedList<TreeNode>();
		leftNode.add(root.left);
		rightNode.add(root.right);

		while(!leftNode.isEmpty() && !rightNode.isEmpty()){
			TreeNode currentLeftNode = leftNode.poll();
			TreeNode currentRightNode = rightNode.poll();

			if(currentLeftNode.val != currentRightNode.val)
				return false;
			if((currentLeftNode.left == null && currentRightNode.right != null) || (currentLeftNode.left != null && currentRightNode.right == null))
				return false;
			if((currentLeftNode.right == null && currentRightNode.left != null) || (currentLeftNode.right != null && currentRightNode.left == null))
				return false;

			if(currentLeftNode.left != null && currentRightNode.right != null){
				leftNode.add(currentLeftNode.left);
				rightNode.add(currentRightNode.right);
			}

			if(currentLeftNode.right != null && currentRightNode.left != null){
				leftNode.add(currentLeftNode.right);
				rightNode.add(currentRightNode.left);
			}            
		}
		return true;
	}

	//Iterative //O(n) O(n)
	//BFS
	public boolean isSymmetric3(TreeNode root) {
		if(root == null) {
			return true;
		}

		Queue<TreeNode> leftQueue = new LinkedList<TreeNode>();
		Queue<TreeNode> rightQueue = new LinkedList<TreeNode>();

		leftQueue.offer(root.left);
		rightQueue.offer(root.right);

		while(!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
			TreeNode currentLeftNode = leftQueue.poll();
			TreeNode currentRightNode = rightQueue.poll();

			if(currentLeftNode == null && currentRightNode == null) {
				continue;			//F: must continue NOT return true		
			}
			if(currentLeftNode == null || currentRightNode == null) {
				return false;
			}
			if(currentLeftNode.val != currentRightNode.val) {
				return false;
			}

			leftQueue.offer(currentLeftNode.left);		//left first
			leftQueue.offer(currentLeftNode.right);

			rightQueue.offer(currentRightNode.right);	//right first
			rightQueue.offer(currentRightNode.left);
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
		System.out.println(obj.isSymmetric3(p1));
	}
}
