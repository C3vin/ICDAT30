package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

/*
Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), 
write a function to check whether these edges make up a valid tree.

Example 1:
Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
Output: true

Example 2:
Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
Output: false
Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, 
[0,1] is the same as [1,0] and thus will not appear together in edges.
 */
public class n261_Graph_Valid_Tree {
	public boolean validTree(int n, int[][] edges) {
		HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();

		for(int[] edge : edges) {
			if(graph.containsKey(edge[1])) {
				graph.get(edge[1]).add(edge[0]);
			} else {
				ArrayList<Integer> x = new ArrayList<Integer>();
				x.add(edge[0]);
				graph.put(edge[1], x);
			}
		}
		
		//0: unvisited; 1: visiting 2: visited
		int[] visited = new int[n];
		for(int i = 0; i < n; i++) {
			if(!dfs(graph, i, visited)) {
				return false;
			}
		}

		return true;
	}
	private boolean dfs(HashMap<Integer,ArrayList<Integer>> graph, int node, int[] visited) {
		if(visited[node] == 1) {
			return false;
		}
		if(visited[node] == 2) {
			return true;
		}
		
		visited[node] = 1;				//must setup

		if(graph.containsKey(node)) {
			for(int preCourse : graph.get(node)) {
				if(!dfs(graph, preCourse, visited)) {
					return false;
				}
			}
		}
	
		visited[node] = 2;
		
		return true;
	}
	
	public static void main(String[] args) {
		/*
	 2 -- 0 -- 1 -- 4
          |
          3
          
          4
          |
     0 -- 1 -- 2
           \  /
            3
		 */
		n261_Graph_Valid_Tree obj = new n261_Graph_Valid_Tree();
		System.out.println(obj.validTree(5, new int[][] {{0,1}, {0,2}, {0,3}, {1,4}}));
		System.out.println(obj.validTree(5, new int[][] {{0,1}, {1,2}, {2,3}, {1,3}, {1,4}}));
	}
}
