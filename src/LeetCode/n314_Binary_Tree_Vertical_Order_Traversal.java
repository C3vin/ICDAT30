package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

/*
Given the root of a binary tree, return the vertical order traversal of its nodes' values. (i.e., from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.
Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Example 2:


Input: root = [3,9,8,4,0,1,7]
Output: [[4],[9],[3,0,1],[8],[7]]
Example 3:


Input: root = [3,9,8,4,0,1,7,null,null,null,2,5]
Output: [[4],[9,5],[3,0,1],[8,2],[7]]
Example 4:

Input: root = []
Output: []
 */
public class n314_Binary_Tree_Vertical_Order_Traversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val) {
			this.val = val;
		}
	}

	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		if(root == null) {
			return res;
		}

		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Queue<Integer> cols = new LinkedList<Integer>();

		queue.offer(root);
		cols.offer(0);

		int min = 0;
		int max = 0;

		while(!queue.isEmpty()) {
			//int levelSize = 0;

			//for(int i=0; i<levelSize; i++) {      //if use HashMap can't use this! TreeMap is fine.
			TreeNode currentNode = queue.poll();
			int col = cols.poll();

			if(!map.containsKey(col)) {
				map.put(col, new ArrayList<Integer>());
			}

			map.get(col).add(currentNode.val);

			if(currentNode.left != null) {
				queue.offer(currentNode.left);
				cols.offer(col - 1);
				min = Math.min(min, col-1);
			}

			if(currentNode.right != null) {
				queue.offer(currentNode.right);
				cols.offer(col + 1);
				max = Math.max(max, col+1);
			}
			// }
		}

		for(int i=min; i<=max; i++) {
			res.add(map.get(i));
		}

		return res;
	}

	//This use TreeMap slow than HashMap
	public List<List<Integer>> verticalOrder2(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		if(root == null) {
			return res;
		}

		TreeMap<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Queue<Integer> cols = new LinkedList<Integer>();

		queue.offer(root);
		cols.offer(0);

		while(!queue.isEmpty()) {
			int levelSize = queue.size();

			for(int i=0; i<levelSize; i++) {
				TreeNode currentNode = queue.poll();
				int col = cols.poll();

				if(!map.containsKey(col)) {
					map.put(col, new ArrayList<Integer>());
				}

				map.get(col).add(currentNode.val);

				if(currentNode.left != null) {
					queue.offer(currentNode.left);
					cols.offer(col - 1);
				}

				if(currentNode.right != null) {
					queue.offer(currentNode.right);
					cols.offer(col + 1);
				}

			}
		}

		res = new ArrayList<List<Integer>>(map.values());

		return res;
	}

}
