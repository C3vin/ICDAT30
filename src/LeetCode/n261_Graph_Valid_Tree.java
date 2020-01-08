package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
		//https://github.com/awangdev/LintCode/blob/master/Java/Graph%20Valid%20Tree.java
		HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
		
		for(int[] edge : edges) {
			if(graph.get(edge[0]) == null) {
				graph.put(edge[0], new ArrayList<Integer>());
			}
			if(graph.get(edge[1]) == null) {
				graph.put(edge[1], new ArrayList<Integer>());
			}
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}


		//0: unvisited; 1: visiting 2: visited
		int[] visited = new int[n];
		for(int i=0; i<n; i++) {
			if(!dfs(graph, i, visited, -1)) {
				return false;
			}
		}
		
		for(int x : visited) {
			System.out.println(x);
		}
		
		return true;
	}
	private boolean dfs(HashMap<Integer,ArrayList<Integer>> graph, int node, int[] visited, int parent) {
		if(visited[node] == 1) {
			return false;
		}
		if(visited[node] == 2) {
			return true;
		}

		visited[node] = 1;				//must setup

		if(graph.containsKey(node)) {
			for(int child : graph.get(node)) {
				if(child == parent) {
					continue;
				}
				if(!dfs(graph, child, visited, node)) {
					return false;
				}
			}
		}

		visited[node] = 2;

		return true;
	}

	//
	public boolean validTree2(int n, int[][] edges) {
		if (n == 0) return false;

		Map<Integer, Set<Integer>> graph = buildGraph(n, edges);
		Set<Integer> visited = new HashSet<>();

		// dfs(graph, visited, i, -1) and validate cycle
		if (!helper(graph, visited, 0, -1)) return false;

		// validate if all edge connected: # of visited node should match graph size        
		return visited.size() == graph.size();
	}
	// build graph in form of adjacent list
	private Map<Integer, Set<Integer>> buildGraph(int n, int[][] edges) {
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		for (int i = 0; i < n; i++) {
			graph.putIfAbsent(i, new HashSet<Integer>());
		}
		for (int[] edge: edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}
		return graph;
	}
	private boolean helper(Map<Integer, Set<Integer>> graph, Set<Integer> visited, int curr, int pre) {
		if (visited.contains(curr)) return false;
		visited.add(curr);
		for (int child : graph.get(curr)) {
			if (child == pre) continue;
			if (!helper(graph, visited, child, curr)) return false;
		}
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
		//System.out.println(obj.validTree(5, new int[][] {{0,1}, {0,2}, {0,3}, {1,4}}));
		//System.out.println(obj.validTree(5, new int[][] {{0,1}, {1,2}, {2,3}, {1,3}, {1,4}}));
		System.out.println(obj.validTree(4, new int[][] {{0,1}, {2,3}}));
		
		//System.out.println(obj.validTree2(5, new int[][] {{0,1}, {0,2}, {0,3}, {1,4}}));
		//System.out.println(obj.validTree2(5, new int[][] {{0,1}, {1,2}, {2,3}, {1,3}, {1,4}}));
		System.out.println(obj.validTree2(4, new int[][] {{0,1}, {2,3}}));
	}
}
