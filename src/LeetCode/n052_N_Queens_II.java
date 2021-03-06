package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
The n-queens puzzle is the problem of placing n queens on an n�n chessboard such that no two queens attack each other.
Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example:

Input: 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
 */
public class n052_N_Queens_II {
	 public int totalNQueens(int n) {
	        List<List<String>> res = new ArrayList<>();
	        char[][] board = new char[n][n];
	        for(int i=0; i<board.length; i++) {
	        	Arrays.fill(board[i], '.');					//init board
	        }
	        
	        helper(n, board, 0, res);
	        
	        return res.size();          //only changed here, [LC51-LC52] sol
	    }
	    
	    private void helper(int n, char[][] board, int row, List<List<String>> res) {
			if(row == n) {
				List<String> list = new ArrayList<String>();
				for(char[] b : board) {
					list.add(new String(b));			//just add it, not need to check 'Q' again
				}
				res.add(list);
				
				return;
			}
			
			for(int col=0; col<n; col++) {
				if(board[row][col] == '.' && isValid(n, board, row, col)) {
					board[row][col] = 'Q';
					
					helper(n, board, row+1, res);
					
					board[row][col] = '.';
				}
			}
		}
	  
		private boolean isValid(int n, char[][] board, int i, int j) {
			for(int row=0; row<n; row++) {
				if(board[row][j] == 'Q') {
					return false;
				}
			}
			
			for(int col=0; col<n; col++) {
				if(board[i][col] == 'Q') {
					return false;
				}
			}
			
			//check diagonal 
			//need while not for !!!
			int row = i;
			int col = j;
			
			while(row >= 0 && col >= 0) {
				if(board[row][col] == 'Q') {
					return false;
				}
				row--;
				col--;
			}
			
			row = i;	//reset
			col = j;
			while(row < n && col < n) {
				if(board[row][col] == 'Q') {
					return false;
				}
				row++;
				col++;
			}
			
			//check other diagonal
			//need while not for !!!
			row = i;	//reset
			col = j;
			while(row >= 0 && col < n) {
				if(board[row][col] == 'Q') {
					return false;
				}
				row--;
				col++;
			}
			
			row = i;
			col = j;
			while(row < n && col >= 0) {
				if(board[row][col] == 'Q') {
					return false;
				}
				row++;
				col--;
			}
			
			return true;
		}
		
		public static void main(String[] args) {
			n052_N_Queens_II obj = new n052_N_Queens_II();
			System.out.println(obj.totalNQueens(4));
		}
}
