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

	public int numIslands2(char[][] grid) {
		if(grid == null || grid.length == 0  || grid[0].length == 0) {
			return 0;
		}

		int count = 0;
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(grid[i][j] == '1') {
					bfs(grid, i, j);
					count++;
				}
			}
		}
		return count;
	}

	private void bfs(char[][] grid, int x, int y) {
		grid[x][y] = 'X';//F: need to change

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(x * grid[0].length + y);			//??

		while(!queue.isEmpty()) {
			int id = queue.poll();
			int i = id / grid[0].length;	//row
			int j = id % grid[0].length;	//col

			if(i>0 && grid[i-1][j] == '1') {
				queue.offer((i-1) * grid[0].length + j);
				grid[i-1][j] = 'X';
			}
			if(i<grid.length-1 && grid[i+1][j] == '1') {
				queue.offer((i+1) * grid[0].length + j);
				grid[i+1][j] = 'X';
			}
			if(j>0 && grid[i][j-1] == '1') {
				queue.offer(i * grid[0].length + j-1);
				grid[i][j-1] = 'X';
			}
			if(j<grid[0].length-1 && grid[i][j+1] == '1') {
				queue.offer(i * grid[0].length + j+1);
				grid[i][j+1] = 'X';
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

