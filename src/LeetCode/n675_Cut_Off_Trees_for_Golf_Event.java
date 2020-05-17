package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative 2D map, in this map:

0 represents the obstacle can't be reached.
1 represents the ground can be walked through.
The place with number bigger than 1 represents a tree can be walked through, and this positive number represents the tree's height.
In one step you can walk in any of the four directions top, bottom, left and right also when standing in a point which is a tree you can decide 
whether or not to cut off the tree.
You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree with lowest height first. And after 
cutting, the original place has the tree will become a grass (value 1).
You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees. If you can't cut off all 
the trees, output -1 in that situation.
You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.

Example 1:
Input: 
[
 [1,2,3],
 [0,0,4],
 [7,6,5]
]
Output: 6
 

Example 2:
Input: 
[
 [1,2,3],
 [0,0,0],
 [7,6,5]
]
Output: -1
 

Example 3:
Input: 
[
 [2,3,4],
 [0,0,5],
 [8,7,6]
]
Output: 6
Explanation: You started from the point (0,0) and you can cut off the tree in (0,0) directly without walking.
 
Constraints:
1 <= forest.length <= 50
1 <= forest[i].length <= 50
0 <= forest[i][j] <= 10^9
 */
public class n675_Cut_Off_Trees_for_Golf_Event {
	public int cutOffTree(List<List<Integer>> forest) {
		List<ArrayList<Integer>> tree3 = new ArrayList<ArrayList<Integer>>();			
		for(int i=0; i<forest.size(); i++) {
			for(int j=0; j<forest.get(0).size(); j++) {
				int height = forest.get(i).get(j);
				if(height > 1) {
					tree3.add(new ArrayList<Integer>(Arrays.asList(i, j, height)));		//Initialization using asList()
				}
				
			}
		}
		
		//sort all the trees based on their height
		Collections.sort(tree3, (a,b) -> a.get(2) - b.get(2));
		
		//run bfs
		int res = 0;
		int x = 0;
		int y = 0;
		int[][] direction = new int[][] {{-1,0}, {1,0}, {0, -1}, {0,1}};	//LC200 BFS
		
		for(ArrayList<Integer> t : tree3) {
			int dist = bfs(forest, x, y, t.get(0), t.get(1), direction);
			if(dist < 0) {
				return -1;
			} else {
				res = res + dist;
				x = t.get(0);			//must update the x, y by tree 
				y = t.get(1);
			}
		}
		
		return res;
	}

	private int bfs(List<List<Integer>> forest, int x, int y, int tx, int ty, int[][] direction ) {
		int dist = 0;
		
		boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
		Queue<int[]> queue = new LinkedList<int[]>();
		
		visited[x][y] = true;
		queue.offer(new int[] {x, y});
		
		while(!queue.isEmpty()) {
			int leveliSize = queue.size();
			for(int i=0; i<leveliSize; i++) {
				int[] cur = queue.poll();
				
				if(cur[0] == tx && cur[1] == ty) {
					return dist;
				}
				
				for(int[] dir : direction) {
					int nx = cur[0] + dir[0];
					int ny = cur[1] + dir[1];
					
					if(nx >= 0 && nx < forest.size() && ny >= 0 && ny < forest.get(0).size() && !visited[nx][ny] && forest.get(nx).get(ny) >= 1) {
						visited[nx][ny] = true;
						queue.offer(new int[] {nx,ny});
					}
				}
			}
			dist++;
		}
		return -1;				//F: -1 not dist
	}
	
	public static void main(String[] args) {
		n675_Cut_Off_Trees_for_Golf_Event obj = new n675_Cut_Off_Trees_for_Golf_Event();
		List<List<Integer>> forest = new ArrayList<List<Integer>>();
		forest.add(Arrays.asList(2,3,4));
		forest.add(Arrays.asList(0,0,5));
		forest.add(Arrays.asList(8,7,6));
		System.out.println(forest);
		System.out.println(obj.cutOffTree(forest));
		
		List<List<Integer>> forest1 = new ArrayList<List<Integer>>();
		forest1.add(Arrays.asList(1,2,3));
		forest1.add(Arrays.asList(0,0,0));
		forest1.add(Arrays.asList(7,6,5));
		System.out.println(forest1);
		System.out.println(obj.cutOffTree(forest1));
		
	}
}
