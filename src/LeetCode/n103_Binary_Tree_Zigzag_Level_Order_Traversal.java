package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. 
(ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */
public class n103_Binary_Tree_Zigzag_Level_Order_Traversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		String v;
		TreeNode(int x) { val = x; }
		TreeNode(String v) { v = null; }
	}

	//BFS
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root == null) {
			return res;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
        boolean flag = true;
        
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> node = new ArrayList<Integer>();

			for(int i=0; i<levelSize; i++) {
				TreeNode tmp = queue.poll();
				if(tmp != null) {
					if(flag) {
						node.add(tmp.val);
					} else {
						node.add(0, tmp.val);
					}
				}
				if(tmp.left != null) {
					queue.offer(tmp.left);
				}
				if(tmp.right != null) {
					queue.offer(tmp.right);
				}

			}

			flag = flag ? false : true;				//F: do the zigzag
			res.add(node);
		}

		return res;
	}
	
	//DFS
	public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		dfs(root, 0, res);
		
		return res;
	}
	
	private void dfs(TreeNode root, int level, List<List<Integer>> res) {
		if(root == null) {
			return;
		}
		
		if(level >= res.size()) {				//F: 'next' level >= current res size
			System.out.println(level+ " : "+res.size());
			res.add(new ArrayList<Integer>());
		}
		
		if((level % 2)  == 0) {
			res.get(level).add(root.val);
		} else {
			res.get(level).add(0, root.val);
		}
		
		dfs(root.left, level+1, res);
		dfs(root.right, level+1, res);
	}
	
	public static void main(String[] args) {
		n103_Binary_Tree_Zigzag_Level_Order_Traversal obj = new n103_Binary_Tree_Zigzag_Level_Order_Traversal();
		TreeNode p1 = obj.new TreeNode(3);
		TreeNode p2 = obj.new TreeNode(9);
		TreeNode p3 = obj.new TreeNode(20);
		TreeNode p4 = obj.new TreeNode(null);
		TreeNode p5 = obj.new TreeNode(null);
		TreeNode p6 = obj.new TreeNode(15);
		TreeNode p7 = obj.new TreeNode(7);
		p1.left = p2;
		p1.right = p3;
		p1.left = p2;
		p2.right = p5;
		p2.left = p4;
		p3.right = p7;
		p3.left = p6;

		System.out.println(p1.val + " " + p1.left.val + " " + p1.right.val + " "+ p2.left.v + " " + p2.right.v + " " + p3.left.val + " " +p3.right.val);
		System.out.println(obj.zigzagLevelOrder(p1));
		System.out.println(obj.zigzagLevelOrder2(p1));
	}
}
