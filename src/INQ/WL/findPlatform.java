package INQ.WL;

import java.util.Arrays;

public class findPlatform {
	public int platform(int arr[], int dep[], int len) {
		// Sort arrival and departure arrays
		Arrays.sort(arr);
		Arrays.sort(dep);
		
		int platNeed = 0;
		int res = 0;
		int i=0, j=0;
		
		// Similar to merge in merge sort to process all events in sorted order
		while(i<len && j<len) {
			// If next event in sorted order is arrival, increment count of platforms needed
			if(arr[i] < dep[j]) {
				platNeed++;
				i++;
				if(platNeed > res) {
					res = platNeed;
				}
			} else {
				platNeed--;
				j++;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		findPlatform obj = new findPlatform();
		
		int arr[] = {900, 940, 950, 1100, 1800, 1500};
	    int dep[] = {910, 1200, 1130, 1120, 1900, 2000};
	    int len = arr.length;
	    System.out.println(obj.platform(arr, dep, len));
	}
}

/**
arr[]  = {9:00,  9:40, 9:50,  11:00, 15:00, 18:00}
dep[]  = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}

All events sorted by time.
Total platforms at any time can be obtained by subtracting total 
departures from total arrivals by that time.
 Time     Event Type     Total Platforms Needed at this Time                               
 9:00       Arrival                  1
 9:10       Departure                0
 9:40       Arrival                  1
 9:50       Arrival                  2
 11:00      Arrival                  3 
 11:20      Departure                2
 11:30      Departure                1
 12:00      Departure                0
 15:00      Arrival                  1
 18:00      Arrival                  2 
 19:00      Departure                1
 20:00      Departure                0
*/