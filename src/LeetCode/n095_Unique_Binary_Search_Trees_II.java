package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class n095_Unique_Binary_Search_Trees_II {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		public String toString() {
			return String.valueOf(val);
		}
	}
	public List<TreeNode> generateTrees(int n) {
		if(n == 0) {
			return new ArrayList<>();
		}

		return helper(1,n);		//form 1 to n
	}
	private List<TreeNode> helper(int start, int end) {
		List<TreeNode> res = new ArrayList<TreeNode>();	//why need to res in here, cuz we only have partial res

		if(start > end) {
			res.add(null);

			return res;
		}

		for(int i=start; i<=end; i++) {
			//if i is root, left subtree: [start, i-1], right subtree: [i+1, end]
			List<TreeNode> lefts = helper(start, i-1);		
			List<TreeNode> rights = helper(i+1, end);
			
			for(TreeNode left : lefts) {
				for(TreeNode right : rights) {
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					
					res.add(root);
				}
			}
			/*for(int j=0; j<lefts.size(); j++) {
				for(int k=0; k<rights.size(); k++)  {
					TreeNode root = new TreeNode(i);
					root.left = lefts.get(j);
					root.right = rights.get(k);

					res.add(root);	//create tree
				}
			}*/
		}
		
		return res;
	}

	public static void main(String[] args) {
		n095_Unique_Binary_Search_Trees_II obj = new n095_Unique_Binary_Search_Trees_II();
		System.out.println(obj.generateTrees(3));
	}
}
