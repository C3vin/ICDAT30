package LeetCode;

/*
Given a 2D board and a word, find if the word exists in the grid.
The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

Example:
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 
Constraints:
board and word consists only of lowercase and uppercase English letters.
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3
 */
public class n079_Word_Search {
	public boolean exist(char[][] board, String word) {
		int start = 0;
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				if(dfs(board, word, i, j, start)) {			//why can't return dfs(board, word, i, j, 0)...cuz need to go through all the values
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean dfs(char[][] board, String word, int i, int j, int start) {
		if(start >= word.length()) {
			return true;
		}
		if(i<0 || i>=board.length || j<0 || j>=board[0].length) {
			return false;
		}
		
		if(board[i][j] == word.charAt(start)) {
			start++;
			
			char ctmp = board[i][j];		//tmp store board[i][j] value
			board[i][j] = '#';				//update to '#'
			
			boolean res = dfs(board, word, i+1, j, start) || 
					      dfs(board, word, i-1, j, start) || 
					      dfs(board, word, i, j+1, start) || 
					      dfs(board, word, i, j-1, start);
			
			board[i][j] = ctmp;				//restore to original value
			
 			return res;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		n079_Word_Search obj = new n079_Word_Search();
		char[][] board = new char[][] {
			{'A','B','C','E'},
			{'S','F','C','S'},
			{'A','D','E','E'}
		};
		System.out.println(obj.exist(board , "ABCCED"));
		System.out.println(obj.exist(board , "SEE"));
		System.out.println(obj.exist(board , "ABCB"));
	}
}
