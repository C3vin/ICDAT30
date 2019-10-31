package LeetCode;

/*
Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
Note: You can only put the bomb at an empty cell.

Example:

Input: [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
Output: 3 
Explanation: For the given grid,

0 E 0 0 
E 0 W E 
0 E 0 0

Placing a bomb at (1,1) kills 3 enemies.
 */
public class n361_Bomb_Enemy {
	public int maxKilledEnemies(char[][] grid) {
		int max = 0;
		int m = grid.length;
        if(m == 0) {
            return 0;
        }
		int n = grid[0].length;
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(grid[i][j] == '0') {		//need '0'
					max = Math.max(recur(grid, i, j, 0), max);
				}
			}
		}
		return max;
	}
	public int recur(char[][] grid, int x, int y, int count) {
		for(int i=x-1, j=y; i>=0; i--) {		//need i,j both
			if(grid[i][j] == 'W') {
				break;
			}
			if(grid[i][j] == 'E') {
				count++;
			}
		}
		for(int i=x+1, j=y; i<grid.length; i++) {
			if(grid[i][j] == 'W') {
				break;
			}
			if(grid[i][j] == 'E') {
				count++;
			}
		}
		for(int i=x, j=y-1; j>=0; j--) {
			if(grid[i][j] == 'W') {
				break;
			}
			if(grid[i][j] == 'E') {
				count++;
			}
		}
		for(int i=x, j=y+1; j<grid[0].length; j++) {
			if(grid[i][j] == 'W') {
				break;
			}
			if(grid[i][j] == 'E') {
				count++;
			}
		}
		
		return count;
	}
	
	public int maxKilledEnemies2(char[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int result = 0;
		int m = grid.length;
		int n = grid[0].length;
		System.out.println(m + " : " + n);
		int rows = 0;
		int[] cols = new int[n]; 

		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(j == 0 || grid[i][j] == 'W') {
					rows = 0;
					for(int k=j; k<n && grid[i][k] != 'W'; k++) {
						if(grid[i][k] == 'E') {
							rows = rows + 1;
						}
					}
				}
				if(i == 0 || grid[i-1][j] == 'W') {
					System.out.println("i: " + i + " j: " + j);
					cols[j] = 0;
					for(int k=i; k<m && grid[k][j] != 'W'; k++) {
						if(grid[k][j] == 'E') {
							cols[j] = cols[j] + 1;
						}
					}
				}
				if(grid[i][j] == '0' && rows + cols[j] > result) {
					result = rows + cols[j];
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		n361_Bomb_Enemy obj = new n361_Bomb_Enemy();
		/*
		0 E 0 0 
		E 0 W E 
		0 E 0 0
		 */
		char[][] grid = {{'0','E','0','0'}, {'E','0','W','E'}, {'0','E','0','0'}};
		char[][] grid1 = {{'E','E','E'}};
		System.out.println(obj.maxKilledEnemies(grid1));
		//System.out.println(obj.maxKilledEnemies2(grid));
	}
}
