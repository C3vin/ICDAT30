package LeetCode;

/*
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) 
connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:
[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.

Example 2:
[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.
Note: The length of each dimension in the given grid does not exceed 50.
 */
public class n695_Max_Area_of_Island {
	public int maxAreaOfIsland(int[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		
		int res = 0;
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(grid[i][j] == 1) {
					res = Math.max(res, dfs(grid, i, j));
				}
			}
		}
		return res;
	}
	private int dfs(int[][] grid, int i, int j) {
		int area = 0;
		if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] != 1) {
			return 0;
		}
		
		grid[i][j] = 0; 
		
		area = 1 + dfs(grid, i-1, j) + dfs(grid, i+1, j) + dfs(grid, i, j-1) + dfs(grid, i, j+1);
		
		return area;
	}
	
	//if use LC200 template 
	public int maxAreaOfIsland2(int[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int res = 0;   //new 
		int[] count = new int[1];	//need to use array instead of int (immutable)
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(grid[i][j] == 1) {
					count[0] = 0;
					dfs2(grid, i, j, count);
					res = Math.max(res, count[0]);
				}
			}
		}
		return res;
	}

	private void dfs2(int[][] grid, int i, int j, int[] count) {
		if(i<0 || j<0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
			return;
		}

		grid[i][j] = 0;		//F: need to change
		count[0]++;
		
		//up
		dfs2(grid, i-1, j, count);
		//down
		dfs2(grid, i+1, j, count);
		//left
		dfs2(grid, i, j-1, count);
		//right
		dfs2(grid, i, j+1, count);
	}
	
	public static void main(String[] args) {
		n695_Max_Area_of_Island obj = new n695_Max_Area_of_Island();
		int[][] grid = 
				   {{0,0,1,0,0,0,0,1,0,0,0,0,0},
					{0,0,0,0,0,0,0,1,1,1,0,0,0},
					{0,1,1,0,1,0,0,0,0,0,0,0,0},
					{0,1,0,0,1,1,0,0,1,0,1,0,0},
					{0,1,0,0,1,1,0,0,1,1,1,0,0},
					{0,0,0,0,0,0,0,0,0,0,1,0,0},
					{0,0,0,0,0,0,0,1,1,1,0,0,0},
					{0,0,0,0,0,0,0,1,1,0,0,0,0}};
		System.out.println(obj.maxAreaOfIsland(grid));
		System.out.println(obj.maxAreaOfIsland2(grid));
	}
}
