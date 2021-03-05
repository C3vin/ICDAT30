package LeetCode;

import java.util.Arrays;

/*
Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

Example 1:
Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2

Example 2:
Input: intervals = [[7,10],[2,4]]
Output: 1

Constraints:
1 <= intervals.length <= 104
0 <= starti < endi <= 106
 */
public class n253_Meeting_Rooms_II {
	public int minMeetingRooms(int[][] intervals) {
		if(intervals == null || intervals.length == 0) {
			return 0;
		}
		
		//get start & end
		int[] start = new int[intervals.length];
		int[] end = new int[intervals.length];
		
		for(int i=0; i<intervals.length; i++) {
			start[i] = intervals[i][0];
			end[i] =  intervals[i][1];
		}
		
		Arrays.sort(start); //[0, 5, 15]
		Arrays.sort(end);	//[10, 20, 30]
		
		int room = 0;
		
		int sidx = 0;
		int eidx = 0;

		while(sidx < intervals.length) {
			if(start[sidx] < end[eidx]) {
				room++;
				sidx++;
			} else {
				eidx++;
				sidx++;
			}
		}
		
		return room;
	}
	
	public static void main(String[] args) {
		n253_Meeting_Rooms_II obj = new n253_Meeting_Rooms_II();
		System.out.println(obj.minMeetingRooms(new int[][] {{0,30}, {5,10}, {15,20}}));
		System.out.println(obj.minMeetingRooms(new int[][] {{7,10}, {2,4}}));
	}
}
