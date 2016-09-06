package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class n133_Clone_Graph {
	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) { 
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>(); 
		}
	}
	//BFS
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {  
		if(node==null) return null;
		
		LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();  
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();  
		UndirectedGraphNode copy = new UndirectedGraphNode(node.label);  
		map.put(node,copy);  
		queue.offer(node);  
		
		while(!queue.isEmpty()) {  
			UndirectedGraphNode cur = queue.poll();  
			for(int i=0;i<cur.neighbors.size();i++) {  		//check each neighbor 
				if(!map.containsKey(cur.neighbors.get(i))) { //if not visited, then add to queue
					copy = new UndirectedGraphNode(cur.neighbors.get(i).label);  
					map.put(cur.neighbors.get(i),copy);  
					queue.offer(cur.neighbors.get(i));  
				}  
				map.get(cur).neighbors.add(map.get(cur.neighbors.get(i)));  
			}  
		}  
		return map.get(node);  
	}
	//ref:http://blog.csdn.net/fightforyourdream/article/details/17497883
	public static void main(String[] args) {
		n133_Clone_Graph obj = new n133_Clone_Graph();
		
	}
}
