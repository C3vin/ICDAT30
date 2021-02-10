package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Given a n-ary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).



Example 1:



Input: root = [1,null,3,2,4,null,5,6]
Output: 3
Example 2:



Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: 5
 */
public class n559_Maximum_Depth_of_N_ary_Tree {
	class Node {
        public int val;
        public List<Node> children = new ArrayList<Node>();		//need to add this to avoid NullPointerException

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
	};
	//[LC104 - LC111 template]
	//DFS
	public int maxDepth(Node root) {
		if(root == null) {
			return 0;
		}
		
		int depth = 1;
		
		for(Node node : root.children) {
			depth = Math.max(depth, maxDepth(node)+1);
		}
		
		return depth;
	}
	//[LC104 - LC111 template]
	//BFS 
	public int maxDepth2(Node root) {
		if(root == null) {
			return 0;
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		
		int depth = 0;
		
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			
			depth++;
			
			for(int i=0; i<levelSize; i++) {
				Node current = queue.poll();
				
				for(Node node : current.children) {
					queue.offer(node);
				}
			}
		}
		
		return depth;
	}
	
	public static void main(String[] args) {
		n559_Maximum_Depth_of_N_ary_Tree obj = new n559_Maximum_Depth_of_N_ary_Tree();

		Node root = obj.new Node(1);
        root.children.add(obj.new Node(2));
        root.children.add(obj.new Node(3));
        root.children.add(obj.new Node(4));
        root.children.get(0).children.add(obj.new Node(5));
        root.children.get(0).children.add(obj.new Node(6));
        root.children.get(0).children.add(obj.new Node(7));
        root.children.get(1).children.add(obj.new Node(8));
        root.children.get(2).children.add(obj.new Node(9));
        root.children.get(2).children.add(obj.new Node(10));
        root.children.get(2).children.add(obj.new Node(11));

		System.out.println(obj.maxDepth(root));
		System.out.println(obj.maxDepth2(root));
	}
}
