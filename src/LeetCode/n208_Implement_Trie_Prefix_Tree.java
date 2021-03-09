package LeetCode;

/*
Trie (we pronounce "try") or prefix tree is a tree data structure used to retrieve a key in a strings dataset. There are various applications of this very efficient data structure, such as autocomplete and spellchecker.
Implement the Trie class:
Trie() initializes the trie object.
void insert(String word) inserts the string word to the trie.
boolean search(String word) returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.

Example 1:
Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True

Constraints:
1 <= word.length, prefix.length <= 2000
word and prefix consist of lowercase English letters.
At most 3 * 104 calls will be made to insert, search, and startsWith.
 */
public class n208_Implement_Trie_Prefix_Tree {
	class TrieNode {
	    public char val;
	    public boolean isWord; 
	    public TrieNode[] children = new TrieNode[26];
	    public TrieNode() {}
	    TrieNode(char c){
	        TrieNode node = new TrieNode();
	        node.val = c;
	    }
	}
	
	/** Initialize your data structure here. */
	
	private TrieNode root;
	
    public n208_Implement_Trie_Prefix_Tree() {
        root = new TrieNode();
        root.val = ' ';
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode ws = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null){
                ws.children[c - 'a'] = new TrieNode(c);
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode ws = root; 
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a'];
        }
        return ws.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode ws = root; 
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a'];
        }
        return true;
    }
    
    public static void main(String[] args) {
    	n208_Implement_Trie_Prefix_Tree obj = new n208_Implement_Trie_Prefix_Tree();
    	
    	obj.insert("apple");
    	System.out.println(obj.search("apple"));
    	System.out.println(obj.search("app"));
    	System.out.println(obj.startsWith("app"));
    	obj.insert("app");
    	System.out.println(obj.search("app"));
    }
}
