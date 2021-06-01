package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.

Example 1:
Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,4,7,5,3,6,8,9]

Example 2:
Input: mat = [[1,2],[3,4]]
Output: [1,2,3,4]
 */
public class n498_Diagonal_Traverse {
	//https://leetcode.com/problems/diagonal-traverse/discuss/691181/3-Easy-to-understand-Java-solutions
	 
	public int[] findDiagonalOrder(int[][] matrix) {
		if(matrix == null || matrix.length == 0) {
			return new int[0];
		}

		int[] res = new int[matrix.length * matrix[0].length];

		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				if(!map.containsKey(i+j)) {
					map.put(i+j, new ArrayList<Integer>());
				}  
				map.get(i+j).add(matrix[i][j]);

			}
		}

		//System.out.println(map);		//{0=[1], 1=[2, 4], 2=[3, 5, 7], 3=[6, 8], 4=[9]}
		
		int idx = 0;
		for(int i=0; i<map.size(); i++) {
			List<Integer> list = map.get(i);
			
			if(i % 2 == 0) {
				Collections.reverse(list);
			}
			
			for(int n : list) {
				res[idx] = n;
				idx++;
			}
		}

//		for(int r : res) {
//			System.out.print(r);
//		}
		
		return res;
	}

	public static void main(String[] args) {
		n498_Diagonal_Traverse obj = new n498_Diagonal_Traverse();
		System.out.println(obj.findDiagonalOrder(new int[][] {{1,2,3}, {4,5,6}, {7,8,9}}));
	}
}
