package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class n103_Binary_Tree_Zigzag_Level_Order_Traversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		String v;
		TreeNode(int x) { val = x; }
		TreeNode(String v) { v = null; }
	}
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root == null) return res;
		
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.push(root);
		int lastlevel = 1;
		int curlevel = 0;
		List<Integer> tmp = new ArrayList<Integer>();
		boolean flag = false;
		
		while(!stack.isEmpty()) {
			TreeNode cur = stack.pollLast();
			tmp.add(cur.val);
			lastlevel--;
			
			if(cur.left != null) {
				stack.push(cur.left);
				curlevel++;
			}
			if(cur.right != null) {
				stack.push(cur.right);
				curlevel++;
			}
			if(lastlevel == 0) {
				lastlevel = curlevel;
				curlevel = 0;
				if(flag) {
					Collections.reverse(tmp);
					flag = false;
				}
				else
					flag = true;
				
				res.add(tmp);
				tmp = new ArrayList<Integer>();
			}
			
		}
		
		return res;
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
	}
}
