package LeetCode;

import java.util.ArrayList;

/*
An undirected, connected tree with N nodes labelled 0...N-1 and N-1 edges are given.

The ith edge connects nodes edges[i][0] and edges[i][1] together.

Return a list ans, where ans[i] is the sum of the distances between node i and all other nodes.

Example 1:

Input: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
Output: [8,12,6,10,10,10]
Explanation: 
Here is a diagram of the given tree:
  0
 / \
1   2
   /|\
  3 4 5
We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
equals 1 + 1 + 2 + 2 + 2 = 8.  Hence, answer[0] = 8, and so on.
Note: 1 <= N <= 10000
 */
public class n834_Sum_of_Distances_in_Tree {

	int[] res; 			//res[i] counts sum of distance in subtree i.
	int[] count; 		//total # n of each subtree
	//ArrayList<HashSet<Integer>> tree;
	ArrayList<ArrayList<Integer>> tree;
	public int[] sumOfDistancesInTree(int N, int[][] edges) {
		//tree = new ArrayList<HashSet<Integer>>();
		res = new int[N];
		count = new int[N];
		tree = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<N; i++) {
			//tree.add(new HashSet<Integer>());
			tree.add(new ArrayList<Integer>());
		}
		for(int[] e : edges) {					//cuz this is undirected graph
			//tree.get(e[0]).add(e[1]);
			//tree.get(e[1]).add(e[0]);
			tree.get(e[0]).add(e[1]);
			tree.get(e[1]).add(e[0]);
		}
		System.out.println(tree);
		
		dfs(0, -1);								//fill the count[] and the sum distance for the root of each subtree  
		
		dfs2(0, -1);							//fill all the the res[]. not just res[root]

		for(int r:res) 
			System.out.println(r);
		
		return res;
	}
	public void dfs(int cur, int parent) {
		for (int child : tree.get(cur)) {
			if (child == parent) {
				continue;
			}
			
			dfs(child, cur);
			
			count[cur] = count[cur] + count[child];				//count for itself + children
			res[cur] = res[cur] + res[child] + count[child];
		}
		count[cur]++;		//count itself
	}


	public void dfs2(int cur, int parent) {
		for (int child : tree.get(cur)) {
			if (child == parent) {
				continue;
			}

			res[child] = res[cur] + (count.length - count[child]) - count[child];
			
			dfs2(child, cur);
		}
	}

	public static void main(String[] args) {
		n834_Sum_of_Distances_in_Tree obj = new n834_Sum_of_Distances_in_Tree();
		int[][] edge = 
			{		{0,1},
					{0,2},
					{2,3},
					{2,4},
					{2,5}};
		System.out.println(obj.sumOfDistancesInTree(6, edge));
	}
}
