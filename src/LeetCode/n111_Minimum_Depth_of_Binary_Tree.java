package LeetCode;

import java.util.LinkedList;

public class n111_Minimum_Depth_of_Binary_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	//sol1: Recursive
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        int minleft = minDepth(root.left);
        int minright = minDepth(root.right);
        
        if(minleft==0 || minright==0)			//!!!
            return minleft >= minright ? minleft+1 : minright+1;
            
        return Math.min(minleft, minright)+1;
    }
    
    //sol2: Non-recursive
    public int minDepth2(TreeNode root) {
    	if(root == null) return 0;
    	
    	int depth = 1;		//root, start depth at 1
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	int curNum = 1;
    	int nextNum = 0;
    	
    	while(!queue.isEmpty()) {
    		TreeNode tmp = queue.poll();
    		curNum--;
    		
    		if(tmp.left == null && tmp.right == null) {			//F: && 
    			return depth;
    		}
    		
    		if(tmp.left != null) {
    			queue.add(tmp.left);
    			nextNum++;
    		}
    		if(tmp.right != null) {
    			queue.add(tmp.right);
    			nextNum++;
    		}
    		if(curNum == 0) {
    			curNum = nextNum;
    			nextNum = 0;
    			depth++;		//!!! if curNum didn't 0, you won't do depth++
    		}
    	}
    	return depth;
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
