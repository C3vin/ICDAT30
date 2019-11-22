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
			TreeNode curLeft = leftNode.poll();
			TreeNode curRight = rightNode.poll();

			if(curLeft.val != curRight.val)
				return false;
			if((curLeft.left == null && curRight.right != null) || (curLeft.left != null && curRight.right == null))
				return false;
			if((curLeft.right == null && curRight.left != null) || (curLeft.right != null && curRight.left == null))
				return false;

			if(curLeft.left != null && curRight.right != null){
				leftNode.add(curLeft.left);
				rightNode.add(curRight.right);
			}

			if(curLeft.right != null && curRight.left != null){
				leftNode.add(curLeft.right);
				rightNode.add(curRight.left);
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
				return true;
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
		//		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		//		queue.offer(root);
		//		queue.offer(root);
		//		
		//		while(!queue.isEmpty()) { 
		//			TreeNode t1 = queue.poll();
		//			TreeNode t2 = queue.poll();
		//			if(t1 == null && t2 == null) {
		//				return true;
		//			}
		//			if(t1 == null || t2 == null) {
		//				return false;
		//			}
		//			if(t1.val != t2.val) {
		//				return false;
		//			}
		//			queue.offer(t1.left);
		//			queue.offer(t2.right);
		//			queue.offer(t1.right);
		//			queue.offer(t2.left);
		//		}
		//		return true;
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
