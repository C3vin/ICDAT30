package LeetCode;

/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Example 1:
Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? 
How would you optimize the kthSmallest routine?
 */
public class n230_Kth_Smallest_Element_in_a_BST {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	//global 
	int res = 0;
	int rank = 0;
	public int kthSmallest(TreeNode root, int k) {
		helper(root, k);
		return res;
	}
	
	private void helper(TreeNode root, int k) {
		if(root == null) {
			return;
		}
		
		helper(root.left, k);		//when BST, think about 'in-order'
		
		rank++;
		
		if(rank == k) {
			res = root.val;
			return;
		}
		
		helper(root.right, k);
	}
	
	public static void main(String[] args) {
		n230_Kth_Smallest_Element_in_a_BST obj = new n230_Kth_Smallest_Element_in_a_BST();
		TreeNode p1 = new TreeNode(3);
		TreeNode p2 = new TreeNode(1);
		TreeNode p3 = new TreeNode(4);
		TreeNode p4 = new TreeNode();
		TreeNode p5 = new TreeNode(2);
		p1.left = p2;
		p1.right = p3;
		//p2.left = p4;
		p2.right = p5;
		
		System.out.println(obj.kthSmallest(p1, 1));
	}
}
