package LeetCode;


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
	public static void main(String[] args) {
		n111_Minimum_Depth_of_Binary_Tree obj = new n111_Minimum_Depth_of_Binary_Tree();
		TreeNode p1 = obj.new TreeNode(3);
		TreeNode p2 = obj.new TreeNode(9);
		TreeNode p3 = obj.new TreeNode(20);
		TreeNode p4 = obj.new TreeNode(1);
		TreeNode p5 = obj.new TreeNode(3);
		p1.left = p2;
		//p1.right = p3;
		//p2.right = p5;
		//p2.left = p4;
		System.out.println(obj.minDepth(p1));
	}
}
