package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
Define a pair (u, v) which consists of one element from the first array and one element from the second array.
Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.

Example 1:
Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]]
Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

Example 2:
Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [[1,1],[1,1]]
Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

Example 3:
Input: nums1 = [1,2], nums2 = [3], k = 3
Output: [[1,3],[2,3]]
Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 */
public class n373_Find_K_Pairs_with_Smallest_Sums {
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {
			return (b[0]+b[1]) - (a[0]+a[1]);		//cuz we add n1, n2 into pq, e.g. (1,1) vs (1,2)  // ( b - a ) 
		});
		
		for(int n1 : nums1) {
			for(int n2 : nums2) {
				pq.add(new int[]{n1, n2});          //why? cuz pq only int[]
                
                if(pq.size() > k) {
                    pq.poll();
                }
			}
		}
		
        while(!pq.isEmpty()) {
            int[] pair = pq.poll();
            
            res.add(Arrays.asList(pair[0], pair[1]));
        }
		
		return res;
	}
		
	public static void main(String[] args) {
		n373_Find_K_Pairs_with_Smallest_Sums obj = new n373_Find_K_Pairs_with_Smallest_Sums();
		//System.out.println(obj.kSmallestPairs(new int[] {1,7,11}, new int[] {2,4,6}, 3));
		System.out.println(obj.kSmallestPairs(new int[] {1,1,2}, new int[] {1,2,3}, 2));
	}
}
