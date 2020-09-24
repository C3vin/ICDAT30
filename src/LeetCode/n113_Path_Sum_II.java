package LeetCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import LeetCode.n145_Binary_Tree_Postorder_Traversal.TreeNode;

/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:
Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:
[
   [5,4,11,2],
   [5,8,4,5]
]
 */
public class n113_Path_Sum_II {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}

	//Recursion [LC112 - LC113 template] 
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();

		helper(root, sum, tmp, res);

		return res;
	}
	private static void helper(TreeNode root, int sum, List<Integer> tmp, List<List<Integer>> res) {
		if(root == null) {
			return;
		}

		tmp.add(root.val);				//must add the last element before the res.add if applicable

		if(root.left == null && root.right == null && root.val == sum) {
			res.add(new ArrayList<Integer>(tmp));
		}

		helper(root.left, sum - root.val, tmp, res);
		helper(root.right, sum - root.val, tmp, res);

		tmp.remove(tmp.size()-1);
	}

	//We are not using LC112 BFS approach, cuz we need too many lists to store all paths!!!
	//Iteration
	public List<List<Integer>> pathSum2(TreeNode root, int sum) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		if(root == null) {
			return res;
		}
		
		Deque<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		Deque<Integer> level = new LinkedList<Integer>();
		level.offer(1);

		List<Integer> curList = new LinkedList<Integer>();
		int curSum = 0;

		while(!queue.isEmpty()) {
			TreeNode tmp = queue.pollLast();
			int curLevel = level.pollLast();
			curSum = curSum + tmp.val;

			// remove list elements
			while(curList.size() >= curLevel) {
				curSum = curSum - curList.get(curList.size()-1);
				curList.remove(curList.size() - 1);
			}
			curList.add(tmp.val);	//need to remove one node before add to the curList

			if(tmp.left == null && tmp.right == null && curSum == sum) {
				res.add(new LinkedList<Integer>(curList));
			}
			if(tmp.right != null) {
				queue.offer(tmp.right);
				level.offer(curLevel+1);
			}
			if(tmp.left != null) {
				queue.offer(tmp.left);
				level.offer(curLevel+1);
			}
		}
		return res;
	}

	//DFS Iteration
	//LC145 post-order approach
	public List<List<Integer>> pathSum3(TreeNode root, int sum) {
		List<List<Integer>> allPaths = new ArrayList<List<Integer>>();
		List<Integer> currentPath = new ArrayList<Integer>();
		
		Stack<TreeNode> stack = new Stack<TreeNode>();

		//TreeNode cur = root;
		int curSum = 0;
		TreeNode last = null;

		while(root != null || !stack.isEmpty()) {
			if(root != null) {
				stack.push(root);
				curSum = curSum + root.val;
				currentPath.add(root.val);
				root = root.left;
			} else {
				TreeNode tmpNode = stack.peek();
				if(tmpNode.left == null && tmpNode.right == null && curSum == sum) {
					allPaths.add(new ArrayList<Integer>(currentPath));
				}

				if(tmpNode.right != null && tmpNode.right != last) {
					root = tmpNode.right;
				} else {
					last = tmpNode;
					curSum = curSum - stack.pop().val; 
					currentPath.remove(currentPath.size()-1);
				}
			}
		}
		
		return allPaths;
	}

	public static void main(String[] args) {
		n113_Path_Sum_II obj = new n113_Path_Sum_II();
		TreeNode p1 = obj.new TreeNode(5);
		TreeNode p2 = obj.new TreeNode(4);
		TreeNode p3 = obj.new TreeNode(8);
		TreeNode p4 = obj.new TreeNode(11);
		TreeNode p5 = obj.new TreeNode(13);
		TreeNode p6 = obj.new TreeNode(4);
		TreeNode p7 = obj.new TreeNode(7);
		TreeNode p8 = obj.new TreeNode(2);
		TreeNode p9 = obj.new TreeNode(5);
		TreeNode p10 = obj.new TreeNode(1);
		p1.left = p2;
		p1.right = p3;
		p2.left = p4;
		p3.left = p5;
		p3.right = p6;
		p4.left = p7;
		p4.right = p8;
		p6.left = p9;
		p6.right = p10;

		System.out.println(obj.pathSum(p1, 22));
		System.out.println(obj.pathSum2(p1, 22));
		System.out.println(obj.pathSum3(p1, 22));
	}
}
