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
	//DP sol 
	public int numTrees(int n) {
		int[] c = new int[n+1];
		c[0] = 1; 
		c[1] = 1;
		for(int i=2; i<n+1; i++) {
			for(int j=0; j<i; j++) {
				c[i] = c[i] + c[j]*c[i-j-1];
			}
		}
		return c[n];
	}
	
	//good DP sol: https://medium.com/@bill800227/leetcode-96-unique-binary-search-trees-abce6e62a7a0
	
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
