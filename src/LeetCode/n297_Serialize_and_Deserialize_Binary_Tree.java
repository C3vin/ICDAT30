package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//Ref:http://www.cnblogs.com/yrbbest/p/5047035.html
public class n297_Serialize_and_Deserialize_Binary_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	private final String delimiter = ",";
	private final String emptyNode = "#";

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		serialize(root, sb);
		return sb.toString();
	}
	private void serialize(TreeNode root, StringBuilder sb) {
		if(root == null) {
			sb.append(emptyNode).append(delimiter);
		} else {
			sb.append(root.val).append(delimiter);	//pre-order traversal
			serialize(root.left, sb);
			serialize(root.right, sb);
		}
	}
	
	//pre-order traversal
	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		Queue<String> nodes = new LinkedList<String>();	//deque change to queue
		//nodes.addAll(Arrays.asList(data.split(",")));
		String[] s = data.split(",");
		for(String ss : s) {
			nodes.add(ss);
		}
		return deserialize(nodes);
	}

	private TreeNode deserialize(Queue<String> nodes) {	//change to queue
		String nodeVal = nodes.poll();					//change to poll
		if(nodeVal.equals("null")) {
			return null;
		} else{
			TreeNode node = new TreeNode(Integer.parseInt(nodeVal));
			node.left = deserialize(nodes);
			node.right = deserialize(nodes);
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
