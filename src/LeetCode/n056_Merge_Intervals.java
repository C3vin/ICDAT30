package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
public class n056_Merge_Intervals {
	/*	public class Interval {
		int start;
		int end;
		Interval() { 
			start = 0; 
			end = 0; 
		}
		Interval(int s, int e) { 
			start = s; 
			end = e; 
		}
		public String toString() {
			return "[" + start + ", " + end + "]";
		}
	}*/

	class Interval {
		int start;
		int end;

		public Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public int[][] merge(int[][] intervals) {
		LinkedList<int[]> merged = new LinkedList<int[]>();		//need 'LinkedList' cuz getLast() and toArray (convert Linkedlist to Array!)

		Arrays.sort(intervals, (int[] a, int[] b) -> {			//Arrays for int array
			return a[0] - b[0];
		});

		for(int[] interval : intervals) {
			if(merged.isEmpty() || merged.getLast()[1] < interval[0]) {			//compare with interval[0] not 1
				merged.add(interval);
			} else {
				merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
			}
		}


/*		int[][] res = new int[merged.size()][];
		for(int i=0; i<merged.size(); i++) {
			res[i] = merged.get(i);
		}*/
		
		return merged.toArray(new int[merged.size()][]);						//LinkedList convert to Array!
	}
	
	public static void main(String[] args) {
		n056_Merge_Intervals obj = new n056_Merge_Intervals();
		int[][] intervals = 
			       {{8,10},
					{1,3},
					{2,6},
					{15,18}};
		System.out.println(obj.merge(intervals));
	}
}
