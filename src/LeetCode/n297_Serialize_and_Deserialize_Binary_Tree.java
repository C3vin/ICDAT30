package LeetCode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//Ref:http://www.cnblogs.com/yrbbest/p/5047035.html
public class n297_Serialize_and_Deserialize_Binary_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if(root == null) return null;
		StringBuilder sb = new StringBuilder();
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if(node == null) {
				sb.append("null,");
			}else {
				sb.append(node.val + ",");
				queue.add(node.left);			//node not root
				queue.add(node.right);
			}
		}
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		Deque<String> nodes = new LinkedList<String>();
		nodes.addAll(Arrays.asList(data.split(",")));
		return deserialize(nodes);
	}
	
	private TreeNode deserialize(Deque<String> nodes) {
		String nodeVal = nodes.poll();
		if(nodeVal.equals("null")) {
			return null;
		} else{
			TreeNode node = new TreeNode(Integer.parseInt(nodeVal));
			node.left = deserialize(nodes);
			node.right = deserialize(nodes);
			System.out.println(node);
			return node;
		}
	}

	public static void main(String[] args) {
		n297_Serialize_and_Deserialize_Binary_Tree obj = new n297_Serialize_and_Deserialize_Binary_Tree();
		TreeNode p1 = obj.new TreeNode(1);
		TreeNode p2 = obj.new TreeNode(2);
		TreeNode p3 = obj.new TreeNode(3);
		TreeNode p6 = obj.new TreeNode(4);
		TreeNode p7 = obj.new TreeNode(5);
		p1.left = p2;
		p1.right = p3;
		p3.left = p6;
		p3.right = p7;
		System.out.println(obj.serialize(p1));
		String data = "1,2,3,null,null,4,5,null,null,null,null,";
		System.out.println(obj.deserialize(data));
	}
}
