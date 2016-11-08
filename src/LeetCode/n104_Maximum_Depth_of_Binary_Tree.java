package LeetCode;

import java.util.LinkedList;
@Alg(type="DFS,Tree", com="LL,A", level="easy", num=104)
public class n104_Maximum_Depth_of_Binary_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	//sol1: Recursive
	public int maxDepth(TreeNode root) {
		if(root == null) return 0;			
		int left = maxDepth(root.left); 
		int right = maxDepth(root.right);
		
		int res = Math.max(left, right)+1;	//depth+1(root)
		return res;
	}
	//sol2: Non-recursive
	public int maxDepth2(TreeNode root) {
		if(root == null)  return 0;
		
		int level = 0;  
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();  
		queue.add(root);  	//only add one node, size = 1 e.g. root
		int curNum = 1; 	//num of nodes left in current level  
		int nextNum = 0; 	//num of nodes in next level  
		
		while(!queue.isEmpty()) {  
			TreeNode n = queue.poll();  	//poll one node from queue
			curNum--;  						//curNum--
			if(n.left!=null) {  
				queue.add(n.left);  
				nextNum++;  
			}  
			if(n.right!=null) {  
				queue.add(n.right);  
				nextNum++;  
			}  
			if(curNum == 0) {  			//if no curNum, reset
				curNum = nextNum;  
				nextNum = 0;  
				level++;  
			}  
		}  
		return level;  
	}
	public static void main(String[] args) {
		n104_Maximum_Depth_of_Binary_Tree obj = new n104_Maximum_Depth_of_Binary_Tree();
		TreeNode p1 = obj.new TreeNode(3);
		TreeNode p2 = obj.new TreeNode(9);
		TreeNode p3 = obj.new TreeNode(20);
		TreeNode p4 = obj.new TreeNode(1);
		TreeNode p5 = obj.new TreeNode(3);
		TreeNode p6 = obj.new TreeNode(15);
		TreeNode p7 = obj.new TreeNode(7);
		p1.left = p2;
		p1.right = p3;
		p1.left = p2;
		p2.right = p5;
		p2.left = p4;
		p3.right = p7;
		p3.left = p6;
		System.out.println(p1.val + " " + p1.left.val + " " + p1.right.val + " "+ p2.left.val + " " + p2.right.val 
				+ " " + p3.left.val + " " +p3.right.val);
		System.out.println(obj.maxDepth(p1));
		System.out.println(obj.maxDepth2(p1));
	}
}
