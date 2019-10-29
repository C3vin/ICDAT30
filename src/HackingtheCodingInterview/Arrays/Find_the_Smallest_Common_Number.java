package HackingtheCodingInterview.Arrays;

public class Find_the_Smallest_Common_Number {
	static Integer find_least_common_number(int[] arr1, int[] arr2, int[] arr3) {
		int i=0, j=0, k=0;

		while(i < arr1.length && j < arr2.length && k < arr3.length) {
			// Finding the smallest common number
			if(arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
				return arr1[i];
			}

			// Let's increment the iterator
			// for the smallest value.
			if(arr1[i] <= arr2[j] && arr1[i] <= arr3[k]) {
				i++;
			} else if(arr2[j] <= arr1[i] && arr2[j] <= arr3[k]) {
				j++;
			} else if(arr3[k] <= arr1[i] && arr3[k] <= arr2[j]) {
				k++;
			}
		}
		return null;
	}
	public static void main(String []args){
		int[] v1 = new int[]{1, 6, 10, 14, 50};
		int[] v2 = new int[]{-1, 6, 7, 8, 50};
		int[] v3 = new int[]{0, 6, 7, 10, 25, 30, 40};
		System.out.println("Least Common Number: " + find_least_common_number(v1, v2, v3));
	}
}
