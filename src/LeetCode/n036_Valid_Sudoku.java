package LeetCode;

public class n036_Valid_Sudoku {
	public boolean isValidSudoku(char[][] board) {
		if (board == null || board.length != 9 || board[0].length != 9)
			return false;

		//check column
		for(int i=0; i<9; i++) {
			boolean[] m = new boolean[9];
			for(int j=0; j<9; j++) {
				if(board[i][j] != '.') {
					if(m[(int)(board[i][j]-'1')])
						return false;
					m[(int)(board[i][j]-'1')] = true;
				}
			}
		}

		//check row
		for(int j=0; j<9; j++) {
			boolean[] m = new boolean[9];
			for(int i=0; i<9; i++) {
				if(board[i][j] != '.') {
					if(m[(int)(board[i][j]-'1')])
						return false;
					m[(int)(board[i][j]-'1')] = true;
				}
			}
		}

		//check sub
		for(int block=0; block<9; block++) {
			boolean[] m = new boolean[9];
			for(int i=block/3*3; i<block/3*3+3; i++) {
				for(int j=block%3*3; j<block%3*3+3; j++) {
					if(board[i][j] != '.') {
						if(m[(int)(board[i][j]-'1')])
							return false;
						m[(int)(board[i][j]-'1')] = true;
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		n036_Valid_Sudoku obj = new n036_Valid_Sudoku();

		char[][] board = 
				   {{'5','3','.','.','7','.','.','.','.'},
					{'6','.','.','1','9','5','.','.','.'},
					{'.','9','8','.','.','.','.','6','.'},
					{'8','.','.','.','6','.','.','.','3'},
					{'4','.','.','8','.','3','.','.','1'},
					{'7','.','.','.','2','.','.','.','6'},
					{'.','6','.','.','.','.','2','8','.'},
					{'.','.','.','4','1','9','.','.','5'},
					{'.','.','.','.','8','.','.','7','9'}};

		System.out.println(obj.isValidSudoku(board));
	}
}

