package LeetCode;

/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

Input: board = 
[["5","3",".",".","7",".",".",".","."],
["6",".",".","1","9","5",".",".","."],
[".","9","8",".",".",".",".","6","."],
["8",".",".",".","6",".",".",".","3"],
["4",".",".","8",".","3",".",".","1"],
["7",".",".",".","2",".",".",".","6"],
[".","6",".",".",".",".","2","8","."],
[".",".",".","4","1","9",".",".","5"],
[".",".",".",".","8",".",".","7","9"]]
Output: 
[["5","3","4","6","7","8","9","1","2"],
["6","7","2","1","9","5","3","4","8"],
["1","9","8","3","4","2","5","6","7"],
["8","5","9","7","6","1","4","2","3"],
["4","2","6","8","5","3","7","9","1"],
["7","1","3","9","2","4","8","5","6"],
["9","6","1","5","3","7","2","8","4"],
["2","8","7","4","1","9","6","3","5"],
["3","4","5","2","8","6","1","7","9"]]
 */
public class n037_Sudoku_Solver {
	public void solveSudoku(char[][] board) {
		helper(board, 0, 0);
	}

	private boolean helper(char[][] board, int r, int c) {
		int m = 9;
		int n = 9;

		if(c == n) {
			return helper(board, r+1, 0);		//need to move to next row
		}

		if(r == m) {							//last row without issue, true
			return true;
		}

		for(int i=r; i<m; i++) {
			for(int j=c; j<n; j++) {
				if(board[i][j] != '.') {
					return helper(board, i, j+1);		//if scan to default char, move to next one(j+1)
				}

				for(char ch='1'; ch<='9'; ch++) {
					if(!isValid(board, i, j, ch)) {
						continue;
					}

					board[i][j] = ch;

					if(helper(board, i, j+1)) {
						return true;
					}

					board[i][j] = '.';
				}
				
				return false;				//????
			}
		}
		
		return false;
	}

	private boolean isValid(char[][] board, int r, int c, char ch) {
		for(int i=0; i<9; i++) {
			if(board[r][i] == ch) {
				return false;
			}
			if(board[i][c] == ch) {
				return false;
			}
		}

		//check 3x3
		int rr = (r/3)*3;
		int cc = (c/3)*3;
		for(int i=rr; i<rr+3; i++) {
			for(int j=cc; j<cc+3; j++) {
				if(board[i][j] == ch) {
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		n037_Sudoku_Solver obj = new n037_Sudoku_Solver();
		char[][] board = 
			{{'5','3','.','.','7','.','.','.','.'},
					{'6','.','.','1','9','5','.','.','.'},
					{'.','9','8','.','.','.','.','6','.'},
					{'8','.','.','.','6','.','.','.','3'},
					{'4','.','.','8','.','3','.','.','1'},
					{'7','.','.','.','2','.','.','.','6'},
					{'.','6','.','.','.','.','2','8','.'},
					{'.','.','.','4','1','9','.','.','5'},
					{'.','.','.','.','8','.','.','7','9'}};;
					obj.solveSudoku(board);
					System.out.println(board);
	}
}
