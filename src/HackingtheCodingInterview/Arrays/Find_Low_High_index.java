package HackingtheCodingInterview.Arrays;

import java.util.Arrays;
import java.util.List;

public class Find_Low_High_index {
	static int find_low_index(List<Integer> arr, int key) {
		int low = 0;
		int high = arr.size()-1;
		int mid = (high-low)/2+low;		

		while(low <= high) {
			int mid_element = arr.get(mid);
			if(mid_element < key) {
				low = mid+1;
			} else {
				high = mid-1;
			}
			mid = (high-low)/2+low;
		}

		if(low < arr.size() && arr.get(low) == key) {
			return low;
		}
		return -1;
	}
	static int find_high_index(List<Integer> arr, int key) {
		int low = 0;
		int high = arr.size()-1;
		int mid = (high-low)/2+low;		

		while(low <= high) {
			int mid_element = arr.get(mid);
			if(mid_element <= key) {
				low = mid+1;
			} else {
				high = mid-1;
			}
			mid = (high-low)/2+low;
		}

		//must have to handle Out of Bounds
/*		if(high == -1){
			return high;
		}*/
		//if can't find the key, high = -1, low = 0
		if(high == -1 || high < arr.size() && arr.get(high) == key) {
			return high;
		}
		return -1;
	}

	public static void main(String []args){
		List<Integer> array = Arrays.asList(1,1,1,2,2,2,2,2,3,3,3,4,4,4,4,5,5,5,6,6,6,6,6,6);
		int key = 5;
		int low = find_low_index(array, key);
		int high = find_high_index(array, key);
/*		System.out.println("LowIndex of " + key + " : "+low);
		System.out.println("HighIndex of " + key + " : "+high);*/

		key = -2;
		low = find_low_index(array, key);
		high = find_high_index(array, key);
		System.out.println("LowIndex of " + key + " : "+low);
		System.out.println("HighIndex of " + key + " : "+high);
	}
}
