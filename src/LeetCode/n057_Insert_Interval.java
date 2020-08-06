package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature
 */
public class n057_Insert_Interval {
	//Good!
	public int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> list = new ArrayList<int[]>();
		
		int i=0;
		while(i<intervals.length && intervals[i][1] < newInterval[0]) {
			list.add(intervals[i]);
			i++;
		}
		
		while(i<intervals.length && intervals[i][0] <= newInterval[1]) {		//<= also need to check newInterval[1] not [0] !!!
			newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
			newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
			i++;
		}
		
		list.add(newInterval);
		
		while(i<intervals.length) {
			list.add(intervals[i]);
			i++;
		}
		
		return list.toArray(new int[list.size()][]);
	}
		
	//Good also
	//Use LC56 Sol, just add newInterval to the intervals and use LC56 
	public int[][] insert2(int[][] intervals, int[] newInterval) {
		int[][] intervalsList = new int[intervals.length+1][];
		for(int i=0; i<intervals.length; i++) {
			intervalsList[i] = intervals[i];						//can't just clone to new array, cuz array fixed the size after clone
		}
		
		intervalsList[intervalsList.length-1] = newInterval;
		
/*		Arrays.sort(intervalsList, (int[] a, int[] b) -> {			//no need to sort in here, do it later
			return a[0] - b[0];
		});*/
		
		return merge(intervalsList);
	}
	
	//LC 56 sol cp here
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
			
		return merged.toArray(new int[merged.size()][]);						//LinkedList convert to Array!
	}
	
	public static void main(String[] args) {
		n057_Insert_Interval obj = new n057_Insert_Interval();
		int[][] intervals = 
		       {{1,2},
				{3,5},
				{6,7},
				{8,10},
				{12,16}};
		System.out.println(obj.insert(intervals, new int[] {4,9}));
		
		int[][] intervals2 = 
		       {{1,2},
				{3,5},
				{6,7},
				{8,10},
				{12,16}};
		System.out.println(obj.insert2(intervals2, new int[] {4,9}));
	}
}
