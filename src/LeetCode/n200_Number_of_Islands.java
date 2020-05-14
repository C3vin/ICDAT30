package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input:
11110
11010
11000
00000
Output: 1

Example 2:
Input:
11000
11000
00100
00011
Output: 3
 */
public class n200_Number_of_Islands {
	//DFS
	public int numIslands(char[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int count = 0;
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(grid[i][j] == '1') {
					dfs(grid, i, j);
					count++;
				}
			}
		}
		return count;
	}

	private void dfs(char[][] grid, int i, int j) {
		//ArrayIndexOutOfBoundsException must >=
		if(i<0 || j<0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
			return;
		}

		grid[i][j] = 'X';   //F: Must change

		//up
		dfs(grid, i-1, j);
		//down
		dfs(grid, i+1, j);
		//left
		dfs(grid, i, j-1);
		//right
		dfs(grid, i, j+1);
	}

	//BFS 
	public int numIslands2(char[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int[][] direction = {{-1,0}, {1,0}, {0,-1}, {0,1}};

		int count = 0;
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(grid[i][j] == '1') {
					bfs(grid, i, j, direction);
					count++;
				}
			}
		}
		return count;
	}
	private void bfs(char[][] grid, int i, int j, int[][] direction) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {i,j});
		// bfs
		while(queue.size() > 0) {
			int levelSize = queue.size();
			for(int k=0; k<levelSize; k++) {
				int[] curr = queue.poll();

				for(int[] dir : direction) {
					int x = curr[0] + dir[0];		//search 4 direction 
					int y = curr[1] + dir[1];
					if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
						if (grid[x][y] == '1') {
							queue.offer(new int[] { x, y });
							grid[x][y] = '0';		//after add to queue, change to '0' -> visited
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		n200_Number_of_Islands obj = new n200_Number_of_Islands();
		char[][] grid = 
			{{'1','1','0','0'},
					{'1','1','0','0'},
					{'0','0','0','1'},
					{'0','1','0','1'}};
		System.out.println(obj.numIslands(grid));
		char[][] grid1 = 
			{{'1','1','0','0'},
					{'1','1','0','0'},
					{'0','0','0','1'},
					{'0','1','0','1'}};
		System.out.println(obj.numIslands2(grid1));
	}
}

