package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class n366_Find_Leaves_of_Binary_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();		// L<L<Integer>> res = new AL<L<Integer>>();
		helper(root, res);
		return res;
	}
	
	private int helper(TreeNode root, List<List<Integer>> res) {
		if(root == null) return -1;

		int left = helper(root.left, res);			
		int right = helper(root.right, res);
		int index = Math.max(left, right)+1;		//4 max(-1,-1)+1=0,5,3 index: 0 | 2 index: 1 | 1 index: 2
		
		if(res.size() == index) {			
			List<Integer> tmp = new ArrayList<Integer>();		//create space
			res.add(tmp);
		}
		res.get(index).add(root.val);
		return index;
	}

	public static void main(String[] args) {
		n366_Find_Leaves_of_Binary_Tree obj = new n366_Find_Leaves_of_Binary_Tree();
		TreeNode p1 = obj.new TreeNode(1);
		TreeNode p2 = obj.new TreeNode(2);
		TreeNode p3 = obj.new TreeNode(3);
		TreeNode p4 = obj.new TreeNode(4);
		TreeNode p5 = obj.new TreeNode(5);
		p1.left = p2;
		p1.right = p3;
		p2.right = p5;
		p2.left = p4;
		System.out.println(obj.findLeaves(p1));
	}
}
