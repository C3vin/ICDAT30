package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class n113_Path_Sum_II {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	/*public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		if(root == null)
			return res;
		Stack<TreeNode> queue = new Stack<TreeNode>();
		queue.push(root);
		Queue<Integer> value = new LinkedList<Integer>();
		value.offer(root.val);
		
		List<Integer> cur = new LinkedList<Integer>();
		int curSum = 0;
		
		while(!queue.isEmpty()) {
			TreeNode tmp = queue.pop();
			int sumValue = tmp.val;
			curSum = curSum + sumValue;
			
			System.out.println("curSum: "+curSum + " sumValue:  "+ sumValue);
			if(curSum > sum) {
				System.out.println("@");
				curSum = curSum - cur.get(cur.size()-1);
				cur.remove(cur.size() - 1);
				for(int i=0; i<cur.size(); i++)
					System.out.println(cur);
				System.out.println(curSum + " ::  "+ sumValue);
			}
			
			cur.add(tmp.val);
			
			if(tmp.left == null && tmp.right == null && sumValue == sum)
				res.add(cur);
			
			if(tmp.left != null) {
				queue.push(tmp.left);
				//value.offer(sumValue + tmp.left.val);
			}
			if(tmp.right != null) {
				queue.push(tmp.right);
				//value.offer(sumValue + tmp.right.val);
			}
		}
		return res;
	}*/
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		 List<List<Integer>> result = new ArrayList<List<Integer>>();
	        if (root == null) {
	            return result;
	        }
	         
	        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
	        Stack<Integer> levelStack = new Stack<Integer>();
	         
	        List<Integer> curList = new ArrayList<Integer>();
	         
	        nodeStack.push(root);
	        levelStack.push(1);
	         
	        int curSum = 0;
	         
	        while (!nodeStack.isEmpty()) {
	            TreeNode curNode = nodeStack.pop();
	            int curLevel = levelStack.pop();
	            curSum += curNode.val;
	            
	            System.out.println("@1: "+curList + " : " + curNode.val);
	            // remove list elements
	            while (curList.size() >= curLevel) {
	            	System.out.println("curLevel: " + curLevel);
	            	curSum -= curList.get(curList.size() - 1);
	                curList.remove(curList.size() - 1);
					//System.out.println(curList);
	            }
	             
	            curList.add(curNode.val);
	            System.out.println("@2: "+curList);
	            // if is a leaf node
	            if (curNode.left == null && curNode.right == null && curSum == sum) {
	                result.add(new ArrayList<Integer>(curList));
	            }
	             
	            if (curNode.right != null) {
	                nodeStack.push(curNode.right);
	                levelStack.push(curLevel + 1);
	            }
	             
	            if (curNode.left != null) {
	                nodeStack.push(curNode.left);
	                levelStack.push(curLevel + 1);
	            }
	        }
	        return result;
	}
	public static void main(String[] args) {
		n113_Path_Sum_II obj = new n113_Path_Sum_II();
		TreeNode p1 = obj.new TreeNode(5);
		TreeNode p2 = obj.new TreeNode(4);
		TreeNode p3 = obj.new TreeNode(8);
		TreeNode p4 = obj.new TreeNode(11);
		TreeNode p5 = obj.new TreeNode(13);
		TreeNode p6 = obj.new TreeNode(4);
		TreeNode p7 = obj.new TreeNode(7);
		TreeNode p8 = obj.new TreeNode(2);
		TreeNode p9 = obj.new TreeNode(5);
		TreeNode p10 = obj.new TreeNode(1);
		p1.left = p2;
		p1.right = p3;
		p2.left = p4;
		p3.left = p5;
		p3.right = p6;
		p4.left = p7;
		p4.right = p8;
		p6.left = p9;
		p6.right = p10;
		System.out.println(p1.val + " " + p1.left.val + " " + p1.right.val + " "+ p2.left.val + " " + p3.left.val 
				+ " " + p3.right.val + " " +p4.left.val + " " + p4.right.val + " " + p6.left.val + " " + p6.right.val);

		System.out.println(obj.pathSum(p1, 22));
		//System.out.println(obj.pathSum(p1, 22));
	}
}
