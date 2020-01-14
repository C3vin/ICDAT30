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
        //HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
		if(edges.length == 0) {
			return true;
		}
		HashMap<Integer, HashSet<Integer>> graph = new HashMap<Integer, HashSet<Integer>>();

		for(int i=0; i<edges.length; i++) {
        	graph.putIfAbsent(i, new HashSet<Integer>());
		}
		
        for(int[] edge : edges) {

			/*if(graph.get(edge[0]) == null) {
				graph.put(edge[0], new HashSet<Integer>());
			}
			if(graph.get(edge[1]) == null) {
				graph.put(edge[1], new HashSet<Integer>());
			}*/
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		//dfs(graph, visited, i, -1) and validate cycle
		Set<Integer> visited = new HashSet<>();
		if(!dfs(graph, visited, 0, -1)) {
			return false;
		}
		//validate if all edge connected: # of visited node should match graph size
		return visited.size() == graph.size();
	}
	private boolean dfs(HashMap<Integer, HashSet<Integer>> graph, Set<Integer> visited, int curr, int pre) {
		if(visited.contains(curr)) {
			return false;
		}
		visited.add(curr);

		if(graph.containsKey(curr)) {
			for(int child : graph.get(curr)) {
				if (child == pre) {
					continue;
				}
				if(!dfs(graph, visited, child, curr)) {
					return false;
				}
			}
		}
		return true;
	}
	public boolean validTree2(int n, int[][] edges) {
		if (n == 0) return false;

        Map<Integer, Set<Integer>> graph = buildGraph(n, edges);
        Set<Integer> visited = new HashSet<>();

        // dfs(graph, visited, i, -1) and validate cycle
        if (!dfs2(graph, visited, 0, -1)) return false;
        
        // validate if all edge connected: # of visited node should match graph size        
        return visited.size() == graph.size();
	}

	// build graph in form of adjacent list
	private Map<Integer, Set<Integer>> buildGraph(int n, int[][] edges) {
		Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
        	graph.putIfAbsent(i, new HashSet<Integer>());
            graph.putIfAbsent(Integer.valueOf(i), new HashSet<Integer>());
        }
        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
	}
	private boolean dfs2(Map<Integer, Set<Integer>> graph, Set<Integer> visited, int curr, int pre) {
		if (visited.contains(curr)) return false;
		visited.add(curr);

		if(graph.containsKey(curr)) {
			for (int child : graph.get(curr)) {
				if (child == pre) continue;
				if (!dfs2(graph, visited, child, curr)) return false;
			}
		}
		return true;
	}

	public boolean validTree3(int n, int[][] edges) {
        int length = edges.length;
        //if(n - 1 != length) return false;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < length; i++) {
            if(map.containsKey(edges[i][0])) {
                map.get(edges[i][0]).add(edges[i][1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(edges[i][1]);
                map.put(edges[i][0], list);
            }
            if(map.containsKey(edges[i][1])) {
                map.get(edges[i][1]).add(edges[i][0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(edges[i][0]);
                map.put(edges[i][1], list);
            }
        }
        boolean[] visited = new boolean[n];
        dfs3(0, map, visited);
        for(boolean b : visited) {
        if (!b) {
                return false;
            }
        }
        return true;
    }
    
    public void dfs3(int node, Map<Integer, List<Integer>> map, boolean[] visited) {
        if (visited[node]) return;
        visited[node] = true;
        if (map.containsKey(node)) {
            for (int i : map.get(node)) {
                dfs3(i, map, visited);
            }
        }
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
		/*System.out.println(obj.validTree(5, new int[][] {{0,1}, {1,2}, {2,3}, {1,3}, {1,4}}));
		System.out.println(obj.validTree(4, new int[][] {{0,1}, {2,3}}));
		System.out.println(obj.validTree(4, new int[][] {{1,0}, {2,0}, {3,1}, {3,2}}));*/
		//System.out.println(obj.validTree(4, new int[][] {{2,3}, {1,2}, {1,3}}));
		System.out.println(obj.validTree(2, new int[][] {{}}));
		//System.out.println(obj.validTree2(1, new int[][] {{}}));
		//System.out.println(obj.validTree3(1, new int[][] {{}}));

		//System.out.println(obj.validTree2(4, new int[][] {{2,3}, {1,2}, {1,3}}));
		//System.out.println(obj.validTree2(1, new int[][] {{}}));
	}
}
