package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class n133_Clone_Graph {
	//BFS
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) { 
		if(node == null) return null;  

		LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();       
		// Hashtable<node, clonedNode>   
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();   
		
		UndirectedGraphNode nodeClone = new UndirectedGraphNode(node.label); //cp root
		map.put(node, nodeClone);     //put root and root clone into ht
		queue.add(node);        //add to queue

		while(!queue.isEmpty()){  
			UndirectedGraphNode cur = queue.remove();   //cur node 
			UndirectedGraphNode curClone = map.get(cur); //cur node will be in ht, because it added from neighbors
			List<UndirectedGraphNode> neighbors = cur.neighbors; //get all the cur's neighbor  
			
			for(int i=0; i<neighbors.size(); i++){       //check all the neighbor
				UndirectedGraphNode neighbor = neighbors.get(i);  
				if(map.containsKey(neighbor)){       //cp already  
					UndirectedGraphNode neighborClone = map.get(neighbor);   //get neighborClone from ht 
					curClone.neighbors.add(neighborClone);      // add cp neighbor to curClone  
				} else {  // neighbor didn't cp before, add new neighborClone  
					UndirectedGraphNode neighborClone = new UndirectedGraphNode(neighbor.label);  
					curClone.neighbors.add(neighborClone);  
					map.put(neighbor, neighborClone);         
					queue.add(neighbor);         
				}  
			}  
		}  
		return nodeClone; 
	}
	
	//DFS
	public UndirectedGraphNode cloneGraphDFS(UndirectedGraphNode node) { 
		if(node == null) return null;  
		
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		UndirectedGraphNode nodeClone = new UndirectedGraphNode(node.label);
		map.put(node, nodeClone);
		DFS(node, map);
		return nodeClone;
	}
	
	private void DFS(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
		for(int i=0; i<node.neighbors.size(); i++) {
			UndirectedGraphNode cur = node.neighbors.get(i);
			if(!map.containsKey(cur)) {
				UndirectedGraphNode neighborClone = new UndirectedGraphNode(cur.label);
				map.put(cur, neighborClone);
				DFS(cur, map);
			}
			map.get(node).neighbors.add(map.get(cur));
		}
	}

	//ref:http://blog.csdn.net/fightforyourdream/article/details/17497883
	public static void main(String[] args) {
		n133_Clone_Graph obj = new n133_Clone_Graph();
		UndirectedGraphNode n1 = UndirectedGraphNode.deserialize("1,3,2#3,1,2,3#2,1,3,4#4,2,3");

		System.out.println(UndirectedGraphNode.serialize(n1));
		System.out.println(UndirectedGraphNode.serialize(obj.cloneGraph(n1)));
		System.out.println(UndirectedGraphNode.serialize(obj.cloneGraphDFS(n1)));
	}
}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }

	public void addNeighbors(UndirectedGraphNode... args) {
		for(UndirectedGraphNode x: args) {
			neighbors.add(x);
		}
	}

	public String toString() {
		return String.valueOf(label);
	}

	public static UndirectedGraphNode deserialize(String str) {
		UndirectedGraphNode start = null;
		Map<Integer, UndirectedGraphNode> mapping = new HashMap<Integer, UndirectedGraphNode>();
		String[] nodeStrs = str.split("#");
		for(String nodeString: nodeStrs) {
			String[] ss = nodeString.split(",");
			int label = Integer.parseInt(ss[0]);

			UndirectedGraphNode x = new UndirectedGraphNode(label);
			mapping.put(label, x);

			if(start == null) start = x;
		}

		for(String nodeString: nodeStrs) {
			String[] ss = nodeString.split(",");

			UndirectedGraphNode node = mapping.get(Integer.parseInt(ss[0]));
			for(int i=1; i<ss.length; i++) {
				int label = Integer.parseInt(ss[i]);
				node.addNeighbors(mapping.get(label));
			}
		}

		return start;
	}

	public static String serialize(UndirectedGraphNode start) {
		if(start == null) return "";

		Set<Integer> set = new HashSet<Integer>();
		Queue<UndirectedGraphNode> q = new ArrayDeque<UndirectedGraphNode>();
		StringBuffer sbf = new StringBuffer();

		q.add(start);

		while(!q.isEmpty()) {
			UndirectedGraphNode n = q.poll();
			if(set.contains(n.label)) continue;
			sbf.append(n.label);
			set.add(n.label);

			for(UndirectedGraphNode p: n.neighbors) {
				sbf.append(",").append(p.label);
				q.add(p);
			}
			sbf.append("#");
		}
		sbf.deleteCharAt(sbf.length()-1); 
		return sbf.toString();
	}
};
