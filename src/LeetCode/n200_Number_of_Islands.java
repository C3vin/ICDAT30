package LeetCode;

public class n200_Number_of_Islands {
	 public int numIslands(char[][] grid) {
		 if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		 
		 int count = 0;
		 for(int i=0; i<grid.length; i++) {
			 for(int j=0; j<grid[0].length; j++) {
				 if(grid[i][j] == '1') {
					 count++;
					 search(grid, i, j);
				 }
			 }
		 }
		 return count;
	 }

	public void search(char[][] grid, int i, int j) {
		if(i<0 || j<0 || j >= grid.length || i >= grid[0].length || grid[i][j] != '1') 
			return;
		
		grid[i][j] = 'X';//F: need to change
		
		//up
		search(grid, i-1, j);
		//down
		search(grid, i+1, j);
		//left
		search(grid, i, j-1);
		//right
		search(grid, i, j+1);
	}
	public static void main(String[] args) {
		n200_Number_of_Islands obj = new n200_Number_of_Islands();
		char[][] grid = 
			{{'1','1','0','0'},
			 {'1','1','0','0'},
			 {'0','0','0','1'},
			 {'0','1','0','1'}};
		System.out.print(obj.numIslands(grid));
	}
}

