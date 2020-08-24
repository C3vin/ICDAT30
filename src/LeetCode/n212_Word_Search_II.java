package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
Given a 2D board and a list of words from the dictionary, find all words in the board.
Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once in a word.

Example:

Input: 
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
 
Note:

All inputs are consist of lowercase letters a-z.
The values of words are distinct.
 */
public class n212_Word_Search_II {
	//the first sol is using same as LC79 
	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<String>();
		
		for(String word : words) {
			if(exist(board, word)) {		//LC79 sol
				res.add(word);
			}
		}
		
		return res;
	}
	
	private boolean exist(char[][] board, String word) {
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				if(dfs(board, word, i, j, 0)) {
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
			
			char ctmp = board[i][j];
			board[i][j] = '#';
			
			boolean res = dfs(board, word, i+1, j, start) || dfs(board, word, i-1, j, start) 
					|| dfs(board, word, i, j+1, start) || dfs(board, word, i, j-1, start);
			
			board[i][j] = ctmp;
			
			return res;
		}
		
		return false;
	}
	
	//another sol LC 208 not yet! 
	//TrieNode
	
	public static void main(String[] args) {
		n212_Word_Search_II obj = new n212_Word_Search_II();
		char[][] board = new char[][] {
			{'o','a','a','n'},
			{'e','t','a','e'},
			{'i','h','k','r'},
			{'i','f','l','v'}
		};
		String[] words = new String[] {"oath","pea","eat","rain"};
		System.out.println(obj.findWords(board, words ));
	}
}
