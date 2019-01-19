package LeetCode;

import LeetCode.n617_Merge_Two_Binary_Trees.TreeNode;

/*
You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
The null node needs to be represented by empty parenthesis pair "()". 
And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

Example 1:
Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /    
  4     
Output: "1(2(4))(3)"

Explanation: Originallay it needs to be "1(2(4)())(3()())", 
but you need to omit all the unnecessary empty parenthesis pairs. 
And it will be "1(2(4))(3)".

Example 2:
Input: Binary tree: [1,2,3,null,4]
       1
     /   \
    2     3
     \  
      4 
Output: "1(2()(4))(3)"

Explanation: Almost the same as the first example, 
except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
 */
public class n606_Construct_String_from_Binary_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	public String tree2str(TreeNode t) {
		StringBuilder sb = new StringBuilder();
		helper(sb, t);
		return sb.toString();
	}
	private void helper(StringBuilder sb, TreeNode t) {
		if(t != null) {
			sb.append(t.val);
			if(t.left != null || t.right != null) {		 
				sb.append("(");
				helper(sb, t.left);
				sb.append(")");
				if(t.right != null) {
					sb.append("(");
					helper(sb, t.right);
					sb.append(")");
				}
			}
		}
	}
	public static void main(String[] args) {
		n606_Construct_String_from_Binary_Tree obj = new n606_Construct_String_from_Binary_Tree();
		TreeNode p1 = obj.new TreeNode(1);
		TreeNode p2 = obj.new TreeNode(2);
		TreeNode p3 = obj.new TreeNode(3);
		TreeNode p4 = obj.new TreeNode(4);
		p1.left = p2;
		p1.right = p3;
		p2.left = p4;
		System.out.println(obj.tree2str(p1));
	}
}
