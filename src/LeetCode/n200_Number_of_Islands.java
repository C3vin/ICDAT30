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
					count++;								//!!!
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
		int count = 0;
		
		Queue<int[]> queue = new LinkedList<int[]>();
		
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(grid[i][j] == '1') {
					
					count++;								//don't forget to count++ !!!
					
					queue.offer(new int[] {i, j});
					
					while(!queue.isEmpty()) {
						int levelSize = queue.size();
						
						for(int k=0; k<levelSize; k++) {
							int[] cur = queue.poll();
							int row = cur[0];
							int col = cur[1];
							
							grid[row][col] = '2'; //visited
							
							//up
							if(row-1 >= 0 && grid[row-1][col] == '1') {
								grid[row-1][col] = '2';
								queue.offer(new int[] {row-1, col});
							}
							//down
							if(row+1 < grid.length && grid[row+1][col] == '1') {
								grid[row+1][col] = '2';
								queue.offer(new int[] {row+1, col});
							}
							//left
							if(col-1 >= 0 && grid[row][col-1] == '1') {
								grid[row][col-1] = '2';
								queue.offer(new int[] {row, col-1});
							}
							//right
							if(col+1 < grid[0].length && grid[row][col+1] == '1') {
								grid[row][col+1] = '2';
								queue.offer(new int[] {row, col+1});
							}
						}
					}
				}
			}
		}
		
		return count;
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

