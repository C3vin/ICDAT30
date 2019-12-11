package LeetCode;

/*
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
Note: A leaf is a node with no children.
Example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.
 */
import java.util.LinkedList;
public class n111_Minimum_Depth_of_Binary_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	//sol1: Recursive
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int minleft = minDepth(root.left);
        int minright = minDepth(root.right);
        
        if(minleft==0 || minright==0)			//!!! e.g. 4, 2
            return minleft >= minright ? minleft+1 : minright+1;
            
        return Math.min(minleft, minright)+1;
    }
    
    //sol2: Non-recursive
    public int minDepth2(TreeNode root) {
    	if(root == null) return 0;
    	
    	int level = 1;		//root, start depth at 1
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	int curNum = 1;		//num of nodes left in current level  
    	int nextNum = 0;	//num of nodes in next level  
    	
    	while(!queue.isEmpty()) {
    		TreeNode tmp = queue.poll();	//poll one node from queue
    		curNum--;						//curNum--
    		
    		if(tmp.left == null && tmp.right == null) {			//F: && e.g.3
    			return level;									
    		}
    		if(tmp.left != null) {
    			queue.add(tmp.left);
    			nextNum++;
    		}
    		if(tmp.right != null) {
    			queue.add(tmp.right);
    			nextNum++;
    		}
    		if(curNum == 0) {			//reset
    			curNum = nextNum;	
    			nextNum = 0;
    			level++;		//!!! if curNum didn't to 0, you won't do level++
    		}
    	}
    	return level;
    }
    
	public static void main(String[] args) {
		n111_Minimum_Depth_of_Binary_Tree obj = new n111_Minimum_Depth_of_Binary_Tree();
		TreeNode p1 = obj.new TreeNode(1);
		TreeNode p2 = obj.new TreeNode(2);
		TreeNode p3 = obj.new TreeNode(3);
		TreeNode p4 = obj.new TreeNode(4);
		p1.left = p2;
		p1.right = p3;
		p2.left = p4;
		System.out.println(obj.minDepth(p1));
		System.out.println(obj.minDepth2(p1));
	}
}
