package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a binary tree, imagine yourself standing on the right side of it, 
return the values of the nodes you can see ordered from top to bottom.

Example:
Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:
   1            <---
 /   \
2     3         <---
 \     \
 */
public class n199_Binary_Tree_Right_Side_View {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	//bfs
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new LinkedList<Integer>();
		if(root == null)
			return res;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			TreeNode tmp = queue.poll();
			
			if(tmp != null) {
				if(queue.peek() == null)
					res.add(tmp.val);
				if(tmp.left != null) 					//must left first, because we need NULL 
					queue.offer(tmp.left);
				if(tmp.right != null)				
					queue.offer(tmp.right);
			} else {
				if(!queue.isEmpty())
					queue.offer(null);
			}
		}
		return res;
	}

	//cs O(n) O(n) 
	//dfs
	public List<Integer> rightSideView2(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root == null) {
			return res;
		
		}
		helper(root, res, 0);
		return res;
	}
	private void helper(TreeNode root, List<Integer> res, int level) {
		if(root == null) {
			return;
		}
		if(res.size() == level) {
			res.add(root.val);
		}
		helper(root.right, res, level+1);		//this time, we need to do right first
		helper(root.left, res, level+1);
	}
	
	public static void main(String[] args) {
		n199_Binary_Tree_Right_Side_View obj = new n199_Binary_Tree_Right_Side_View();
		TreeNode p1 = obj.new TreeNode(1);
		TreeNode p2 = obj.new TreeNode(2);
		TreeNode p3 = obj.new TreeNode(3);
		TreeNode p5 = obj.new TreeNode(4);
		p1.left = p2;
		p1.right = p3;
		p2.right = p5;
		System.out.println(obj.rightSideView(p1));
		System.out.println(obj.rightSideView2(p1));
	}
}
