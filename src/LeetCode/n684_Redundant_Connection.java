package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
In this problem, a tree is an undirected graph that is connected and has no cycles.

The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), 
with one additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, 
that represents an undirected edge connecting nodes u and v.

Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, 
return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.

Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given undirected graph will be like this:
  1
 / \
2 - 3

Example 2:
Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
Output: [1,4]
Explanation: The given undirected graph will be like this:
5 - 1 - 2
    |   |
    4 - 3

Note:
The size of the input 2D-array will be between 3 and 1000.
Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
 */
public class n684_Redundant_Connection {
	public int[] findRedundantConnection(int[][] edges) {
		//https://github.com/awangdev/LintCode/blob/master/Java/Redundant%20Connection.java
		//https://zxi.mytechroad.com/blog/tree/leetcode-684-redundant-connection/
		//HashMap<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
		HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
		Set<Integer> visited = new HashSet<>();

		//for each edge{u, v} use DFS to check whether u,v are already connected 
		for(int[] edge : edges) {

			/*if(graph.containsKey(edge[0]) && helper(edge[0], edge[1], graph, visited)) {
				System.out.println(edge[0] + " : " + edge[1]);
				return edge;
			}*/
			graph.put(edge[0], new ArrayList<Integer>());
			graph.put(edge[1], new ArrayList<Integer>());
			if(dfs(graph, edge[0], edge[1], visited)) {
				return edge;
			}

			if(graph.containsKey(edge[1])) {					//prerequisite[1] not prerequisite only
				graph.get(edge[1]).add(edge[0]);		//not need put again just need add it
			} else {
				ArrayList<Integer> x = new ArrayList<Integer>();
				x.add(edge[0]);
				graph.put(edge[1], x);
			}

			/*			if(graph.get(edge[0]) == null) {
				graph.put(edge[0], new HashSet<Integer>());
			}
			if(graph.get(edge[1]) == null) {
				graph.put(edge[1], new HashSet<Integer>());
			}*/
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		return null;
	}
	private boolean dfs(HashMap<Integer, ArrayList<Integer>> graph, int source, int target, Set<Integer> visited) {
		// no loop here. We find the loop before the loop appeared.
		if (visited.contains(source)) return false;
		visited.add(source);
		if (source == target) return true;
		for (int child : graph.get(source)) {
			if (dfs(graph, child, target, visited)) return true;
		}
		return false;
	}
	
	 public int[] findRedundantConnection2(int[][] edges) {
	        int N = edges.length;
	        ArrayList<Integer>[] graph = new ArrayList[N];
	        Set<Integer> visited = new HashSet<>();
	        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();
	        for (int[] edge : edges) {
	            int a = edge[0] - 1, b = edge[1] - 1;
	            visited.clear();
	            if (dfs(graph, a, b, visited)) {
	            	System.out.println(edge[0]+":"+edge[1]);
	            	return edge;
	            }
	            graph[a].add(b);
	            graph[b].add(a);
	        }
	        return null;
	    }
	    private boolean dfs(ArrayList<Integer>[] graph, int source, int target, Set<Integer> visited) {
	        // no loop here. We find the loop before the loop appeared.
	        if (visited.contains(source)) return false;
	        visited.add(source);
	        if (source == target) return true;
	        for (int child : graph[source]) {
	            if (dfs(graph, child, target, visited)) return true;
	        }
	        return false;
	    }
	    
	
	public int[] findRedundantConnection3(int[][] edges) {
		HashMap<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
		Set<Integer> visited = new HashSet<>();

		for (int[] edge : edges) {
			if(graph.get(edge[0]) == null) {
				graph.put(edge[0], new HashSet<Integer>());
			}
			if(graph.get(edge[1]) == null) {
				graph.put(edge[1], new HashSet<Integer>());
			}

			int a = edge[0], b = edge[1];
			
			if (dfs3(graph, a, b, visited)) {
				System.out.println(edge[0]+":"+edge[1]);
				return edge;
			}
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}
		return null;
	}
	private boolean dfs3(HashMap<Integer, Set<Integer>> graph, int source, int target, Set<Integer> visited) {
		// no loop here. We find the loop before the loop appeared.
		if (visited.contains(source)) {
			return false;
		}
		visited.add(source);
		
		if (source == target) {
			return true;
		}
		
		if(graph.get(source) != null) {
			for (int child : graph.get(source)) {
				if (dfs3(graph, child, target, visited)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		n684_Redundant_Connection obj = new n684_Redundant_Connection();
		//System.out.println(obj.findRedundantConnection(new int[][] {{1,2}, {1,3}, {2,3}}));
		//ystem.out.println(obj.findRedundantConnection3(new int[][] {{1,2}, {1,3}, {2,3}}));
		
		System.out.println(obj.findRedundantConnection2(new int[][] {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}}));
		System.out.println(obj.findRedundantConnection3(new int[][] {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}}));
	}
}
