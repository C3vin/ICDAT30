package LeetCode;

import java.util.ArrayList;
import java.util.List;

@Alg(type="DP,Tree", com="NA", level="med", num=95)
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
		return helper(1,n);		//form 1 to n
	}
	private List<TreeNode> helper(int left, int right) {
		List<TreeNode> res = new ArrayList<TreeNode>();	//why need to res in here, cuz we only have partial res
		if(left > right) {
			res.add(null);
			return res;
		}
		for(int i=left; i<right+1; i++) {
			List<TreeNode> lefts = helper(left, i-1);
			List<TreeNode> rights = helper(i+1, right);
			
			for(int j=0; j<lefts.size(); j++) {
				for(int k=0; k<rights.size(); k++)  {
					TreeNode root = new TreeNode(i);
					root.left = lefts.get(j);
					root.right = rights.get(k);
					res.add(root);	//create tree
				}
			}
		}
		//System.out.println(res);
		return res;
	}
	public static void main(String[] args) {
		n095_Unique_Binary_Search_Trees_II obj = new n095_Unique_Binary_Search_Trees_II();
		System.out.println(obj.generateTrees(3));
	}
}
