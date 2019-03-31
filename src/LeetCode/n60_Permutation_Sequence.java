package LeetCode;

import java.util.ArrayList;
import java.util.List;

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
		List<Integer> tmp = new ArrayList<Integer>();
		for(int i=1; i<=n; i++) {				//must start from i=1
			tmp.add(i);
		}
		
		int[] factorial = new int[n];
		factorial[0] = 1;
		for(int i=1; i<n; i++) {		
			factorial[i] = i * factorial[i-1]; 	//4! = 4 * 3!
		}
		
		k = k-1;								//cuz k start from 1 !!!
		StringBuilder sb = new StringBuilder();
		for(int i=n; i>0; i--) {
			int index = k / factorial[i-1];		//why i-1, cuz i start from n
			k = k % factorial[i-1];
			sb.append(tmp.get(index));
			tmp.remove(index);
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		n60_Permutation_Sequence obj = new n60_Permutation_Sequence();
		System.out.println(obj.getPermutation(3, 3));
		System.out.println(obj.getPermutation(4, 9));
		System.out.println(obj.getPermutation(4, 18));
	}
}
