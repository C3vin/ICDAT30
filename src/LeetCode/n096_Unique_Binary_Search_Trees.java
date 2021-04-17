package LeetCode;

import java.util.HashMap;

/*
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:
Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
 *  Count[3] = Count[0]*Count[2]  (1 is root) left 0 node, right 2 node
               + Count[1]*Count[1]  (2 is root) left 1 node, right 1 node
               + Count[2]*Count[0]  (3 is root) left 2 node, right 0 node
 */
public class n096_Unique_Binary_Search_Trees {
	//DP sol  https://leetcode.com/problems/unique-binary-search-trees/discuss/31807/AC-clean-Java-DP-solution
	//F(i, n) = G(i-1) * G(n-i)	1 <= i <= n 
	public int numTrees(int n) {
		if(n == 0) {
			return 0;
		}
		
		int[] c = new int[n+1];
		c[0] = 1; 
		c[1] = 1;

		for(int i=2; i<n+1; i++) {		//why + 1, for c[0]
			// use j as root
			for(int j=1; j<=i; j++) {	//now F(j, i) = G(j-1) * G(i-j) also why j=1, cuz need j-1 
				c[i] = c[i] + c[j-1] * c[i-j];		
			}
		}
		
//		for(int i=2; i<n+1; i++) {
//			for(int j=0; j<i; j++) {
//				c[i] = c[i] + c[j]*c[i-j-1];
//			}
//		}
		
		return c[n];
	}
	/*good DP sol: https://medium.com/@bill800227/leetcode-96-unique-binary-search-trees-abce6e62a7a0
但在仔細想想Binary Search Tree (BST)最重要的特性：以k為根所形成的BST，其左子樹所有的node必定小於k，同理，右子樹所有的node必定大於k。
有了這個特性以後，我們就可以嘗試用DP來解題了！我們先定義一個DP[i]擁有i個node(1…i)的BST總共有幾種排法。
很明顯地，DP[0] = 1(空樹)且DP[1] = 1(只有一個node)，而當DP[2]的狀況，我們就可以分成以2與1為根的狀況，自然DP[2]=2。
這樣或許還看不出每個sub-problems之間的關係，但我們可以用DP[3]來找到其關聯性。
在DP[3]的case，依照DP[2]的經驗，因為我們有1,2和3三個node，我們分別用它們三個來當root。
首先，我們先用3來當root，而依照剛剛的特性，我們使用3當root，其左子樹所有node必定小於3，其實也就是使用1與2兩個node來形成BST，那不就是DP[2]了呢？
而右子樹因為沒有大於3的node，就是DP[0] (空樹)了，所以在3為root的狀況排列組合就是DP[2] * DP[0] = 2。
我們再來看另一個1為root的狀況，同理，其左子樹為空樹，而其右子樹就可以等化成用2,3來形成BST，
但因為右子樹的BST並沒有額外的限制，因此用1,2或者2,3基本上都是一樣的意思因此在1為root的排列組合就是DP[0]*DP[2] = 2。
而一樣的道理，在2為root的情況就是DP[1] * DP[1] = 1了，三者加總的結果就是題目範例的結果5
	 */	
	
	//better to understand!
	//https://leetcode.com/problems/unique-binary-search-trees/discuss/493155/Simple-recursion-with-Memoization-in-Java-with-comments
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	public int numTrees2(int n) {
		int res = 0;
		
		//Empty tree
		if(n == 0) {
			return 1;
		}
		
		//One tree with root as 1
		if(n == 1) {
			return 1;
		}
		
		//Two trees 
		if(n == 2) {
			return 2;
		}
		
		if(map.containsKey(n)) {
			return map.get(n);
		}
		
		for(int i=1; i<=n; i++) {		//not <, need <=, cuz n=3, root=1, right: 3-1 = 2
			int left = numTrees2(i-1);	//when i is root then we can have as many as i-1 as nodes on the left
			int right = numTrees2(n-i); //as many as n-i as right subtree nodes
										//F(i,n) = G(i - 1) x G(n - i)
			res = res + left*right;		//take the Cartesian product or all the combinations for every left and right subtree
		}
		map.put(n, res);
		
		return res;
	}
	
	public static void main(String[] args) {
		n096_Unique_Binary_Search_Trees obj = new n096_Unique_Binary_Search_Trees();
		System.out.println(obj.numTrees(3));
		System.out.println(obj.numTrees2(3));
	}
}
