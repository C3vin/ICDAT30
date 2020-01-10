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
		HashMap<Integer, HashSet<Integer>> graph = new HashMap<Integer, HashSet<Integer>>();
		
		for(int[] edge : edges) {
			if(graph.get(edge[0]) == null) {
				graph.put(edge[0], new HashSet<Integer>());
			}
			if(graph.get(edge[1]) == null) {
				graph.put(edge[1], new HashSet<Integer>());
			}
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}
		
		return new int[] {-1, -1};
	}
	
	public int[] findRedundantConnection2(int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            if (graph.containsKey(x) && hasCycle(graph, x, y, -1)) {
            	
            	return edge;
            }
            /*graph.putIfAbsent(x, new HashSet<>());
            graph.putIfAbsent(y, new HashSet<>());*/
            if(graph.get(edge[0]) == null) {
				graph.put(edge[0], new HashSet<Integer>());
			}
			if(graph.get(edge[1]) == null) {
				graph.put(edge[1], new HashSet<Integer>());
			}
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        
        int x = 0;
        System.out.println(x);
        
        return new int[] {-1, -1};
    }
    
    private boolean hasCycle(Map<Integer, Set<Integer>> graph, int curr, int target, int pre) {
        if (graph.get(curr).contains(target)) return true;
        for (int num : graph.get(curr)) {
            if (num == pre) continue;
            if (hasCycle(graph, num, target, curr)) return true;
        }
        return false;
    }  
    
    public int[] findRedundantConnection3(int[][] edges) {
        if (edges == null || edges.length == 0)
            return new int[2];
        int n = edges.length;
        ArrayList<Integer> G[] = new ArrayList[n+1];  
        for(int i = 1; i <= n; i++)
            G[i] = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            G[from].add(to);
            G[to].add(from);
            boolean[] vis = new boolean[n+1];
        }
        return new int[2];
    }
	public static void main(String[] args) {
		n684_Redundant_Connection obj = new n684_Redundant_Connection();
		System.out.println(obj.findRedundantConnection(new int[][] {{1,2}, {1,3}, {2,3}}));
		System.out.println(obj.findRedundantConnection2(new int[][] {{1,2}, {1,3}, {2,3}}));
		System.out.println(obj.findRedundantConnection3(new int[][] {{1,2}, {1,3}, {2,3}}));
	}
}
