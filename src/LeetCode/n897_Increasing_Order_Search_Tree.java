package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is 
now the root of the tree, and every node has no left child and only 1 right child.
Example 1:
Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]
       5
      / \
    3    6
   / \    \
  2   4    8
 /        / \ 
1        7   9
Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
            \
             7
              \
               8
                \
                 9  

Note:
The number of nodes in the given tree will be between 1 and 100.
Each node will have a unique integer value from 0 to 1000.
 */
public class n897_Increasing_Order_Search_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	//inorder approach
	public TreeNode increasingBST(TreeNode root) {
		List<Integer> values = new ArrayList<Integer>();
		inorder(root, values);
		
		TreeNode ans = new TreeNode(0);
		TreeNode cur = ans;
		
		for(int v : values) {
			cur.right = new TreeNode(v);
			cur = cur.right;
		}
		return ans.right;
	}
	private void inorder(TreeNode node, List<Integer> values) {
		if(node == null) {
			return;
		}
		inorder(node.left, values);
		values.add(node.val);
		inorder(node.right, values);
	}
	
	//inorder approach with Relinking
	TreeNode cur;							//global veriable
	public TreeNode increasingBST2(TreeNode root) {
		TreeNode ans = new TreeNode(0);
		cur = ans;
		inorder2(root);
		return ans.right;
	}
	private void inorder2(TreeNode node) {
		if(node == null) {
			return;
		}
		inorder2(node.left);
		node.left = null;
		cur.right = node;
		cur = cur.right;				// cur = node;
		inorder2(node.right);
	}
	
	public static void main(String[] args) {
		n897_Increasing_Order_Search_Tree obj = new n897_Increasing_Order_Search_Tree();
		TreeNode p1 = obj.new TreeNode(1);
		TreeNode p2 = obj.new TreeNode(2);
		TreeNode p3 = obj.new TreeNode(3);
		TreeNode p4 = obj.new TreeNode(4);
		TreeNode p5 = obj.new TreeNode(5);
		p1.left = p2;
		p1.right = p3;
		p2.right = p5;
		p3.right = p4;
		System.out.println(obj.increasingBST(p1));
		System.out.println(obj.increasingBST2(p1));
	}
}
