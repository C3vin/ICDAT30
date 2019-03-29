package LeetCode;

/*
The set [1,2,3,...,n] contains a total of n! unique permutations.
By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:
Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.

Example 1:
Input: n = 3, k = 3
Output: "213"

Example 2:
Input: n = 4, k = 9
Output: "2314"
 */
public class n60_Permutation_Sequence {
	public String getPermutation(int n, int k) {
		
	}
	public static void main(String[] args) {
		n60_Permutation_Sequence obj = new n60_Permutation_Sequence();
		System.out.println(obj.getPermutation(3, 3));
		System.out.println(obj.getPermutation(4, 9));
	}
}
