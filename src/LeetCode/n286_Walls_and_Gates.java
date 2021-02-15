package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/*
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume 
that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. 
If it is impossible to reach a gate, it should be filled with INF.

Example: 
Given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
  
After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
 */
public class n286_Walls_and_Gates {
	//DFS
	public void wallsAndGates(int[][] rooms) {
		int val = 0; 
		
		for(int i=0; i<rooms.length; i++) {
			for(int j=0; j<rooms[0].length; j++) {
				if(rooms[i][j] == 0) {
					helper(rooms, i, j, val);					//val
				}
			}
		}
	}
	private void helper(int[][] rooms, int i, int j, int val) {
		//ArrayIndexOutOfBoundsException must >=
		if(i<0 || i>=rooms.length || j<0 || j>=rooms[0].length || rooms[i][j] < val) {	//why need check < val, cuz go to next neighbor, the val+1
			return;
		}
		
		rooms[i][j] = val;
		
		helper(rooms, i-1, j, val+1);
		helper(rooms, i+1, j, val+1);
		helper(rooms, i, j-1, val+1);
		helper(rooms, i, j+1, val+1);
	}
	
	//BFS
	public void wallsAndGates2(int[][] rooms) {
		if(rooms.length == 0 || rooms[0].length == 0 || rooms == null) {
			return;
		}
		
		Queue<int[]> queue = new LinkedList<int[]>();			//int[] not Integer
		
		for(int i=0; i<rooms.length; i++) {
			for(int j=0; j<rooms[0].length; j++) {
				if(rooms[i][j] == 0) {
					queue.offer(new int[] {i, j});
				}
			}
		}
		
		int INF = Integer.MAX_VALUE;			//this INF!
		
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			
			for(int i=0; i<levelSize; i++) {
				int[] cur = queue.poll();
				int row = cur[0];
				int col = cur[1];
				
				//up
				if(row-1 >= 0 && rooms[row-1][col] == INF) {
					rooms[row-1][col] = rooms[row][col] + 1;
					queue.add(new int[] {row-1, col});
				}
				//down
				if(row+1 < rooms.length && rooms[row+1][col] == INF) {
					rooms[row+1][col] = rooms[row][col] + 1;
					queue.add(new int[] {row+1, col});
				}
				//left
				if(col-1 >= 0 && rooms[row][col-1] == INF) {
					rooms[row][col-1] = rooms[row][col] + 1;
					queue.add(new int[] {row, col-1});
				}
				//right
				if(col+1 < rooms[0].length && rooms[row][col+1] == INF) {		//rooms[0] !
					rooms[row][col+1] = rooms[row][col] + 1;
					queue.add(new int[] {row, col+1});
				}
			}
		}
	}
	
	public static void main(String[] args) {
		n286_Walls_and_Gates obj = new n286_Walls_and_Gates();
		int INF = 2147483647;
		int[][] rooms = 
			   {{INF,-1 ,0  ,INF},
				{INF,INF,INF,-1},
				{INF,-1 ,INF,-1},
				{0  ,-1 ,INF,INF}};
		obj.wallsAndGates(rooms);
		
		int[][] rooms2 = 
			   {{INF,-1 ,0  ,INF},
				{INF,INF,INF,-1},
				{INF,-1 ,INF,-1},
				{0  ,-1 ,INF,INF}};
		obj.wallsAndGates2(rooms2);
	}
}
