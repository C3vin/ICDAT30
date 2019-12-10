package LeetCode;

/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:
X X X X
X X X X
X X X X
X O X X

Explanation:
Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. 
Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. 
Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
public class n130_Surrounded_Regions {
	//DFS
	public void solve(char[][] board) {
		if(board == null || board.length == 0 || board[0].length == 0) {
			return;
		}
		
		int m = board.length;
		int n = board[0].length;

		for(int i=0; i<m; i++) {
			if(board[i][0] == 'O') {
				helper(board, i, 0);
			}
			if(board[i][n-1] == 'O') {
				helper(board, i, n-1);		//n-1 not m-1
			}
		}
		for(int i=0; i<n; i++) {
			if(board[0][i] == 'O') {
				helper(board, 0, i);
			}
			if(board[m-1][i] == 'O') {
				helper(board, m-1, i);		//m-1 not n-1
			}
		}
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(board[i][j] == 'O') {		//1 step O -> X
					board[i][j] = 'X';
				} else if(board[i][j] == '1'){	//2 step 1 -> O
					board[i][j] = 'O';
				}
			}
		}
	}
	private void helper(char[][] board, int i, int j) {
		if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] != 'O') {
			return;
		}
		
		board[i][j] = '1';
		
        helper(board, i-1, j);
        helper(board, i+1, j);
        helper(board, i, j-1);
        helper(board, i, j+1);
	}
	
	public static void main(String[] args) {
		n130_Surrounded_Regions obj = new n130_Surrounded_Regions();
		char[][] board = 
		   {{'X','X','X','X'},
			{'X','O','O','X'},
			{'X','X','O','X'},
			{'X','O','X','X'}};
		obj.solve(board);
	}
}
