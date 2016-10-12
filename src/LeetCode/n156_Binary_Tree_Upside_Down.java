package LeetCode;

/*a                         b
 / \        ----->         / \
b   c                     c   a*/
public class n156_Binary_Tree_Upside_Down {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public TreeNode upsideDownBinaryTree(TreeNode root) {
/*		if(root == null || root.left == null) 
			return root;
		//e.g. root:1 -> root:2 -> root:4, root 4 has no left node, return root (back to root 2)
		TreeNode newRoot = upsideDownBinaryTree(root.left);	//will get the latest left node, so it will go deeper and deeper e.g. 
		TreeNode rightMostIterator = newRoot;
		
		while(rightMostIterator.right != null) {
			rightMostIterator = rightMostIterator.right;
		}
		rightMostIterator.left = root.right;
		rightMostIterator.right = new TreeNode(root.val);
		
		return newRoot;*/
		
		//iteration
	    TreeNode node = root, parent = null, right = null;  
	    while (node != null) {  
	        TreeNode left = node.left;  
	        node.left = right;  
	        right = node.right;  
	        node.right = parent;  
	        parent = node;  
	        node = left;  
	    }  
	    return parent; 
	}
	
	public static void main(String[] args) {
		n156_Binary_Tree_Upside_Down obj = new n156_Binary_Tree_Upside_Down();
		TreeNode p1 = obj.new TreeNode(1);
		TreeNode p2 = obj.new TreeNode(2);
		TreeNode p3 = obj.new TreeNode(3);
		TreeNode p4 = obj.new TreeNode(4);
		TreeNode p5 = obj.new TreeNode(5);
		TreeNode p6 = obj.new TreeNode(6);
		p1.left = p2;
		p1.right = p3;
		p2.left = p4;
		p2.right = p5;
		p3.left = p6;
		System.out.println(obj.upsideDownBinaryTree(p1));
	}
}
