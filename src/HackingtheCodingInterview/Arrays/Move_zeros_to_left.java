package HackingtheCodingInterview.Arrays;

import java.util.Arrays;

public class Move_zeros_to_left {
	static void move_zeros_to_left_in_array(int[] A) {
		int read = A.length-1;
		int write = A.length-1;
		
		while(read >= 0) {
			if(A[read] != 0) {
				A[write] = A[read];
				write--;
			}
			read--;
		}
		while(write >= 0) {
			A[write] = 0;
			write--;
		}
	}
	public static void main(String[] args) {
		int[] v = new int[]{1, 10, -1, 11, 5, 0, -7, 0, 25, -35};
		System.out.println("Original Array: "+Arrays.toString(v));
		move_zeros_to_left_in_array(v);
		for(int i = 0 ; i < v.length; i++) {
			System.out.print(v[i] + ", ");
		}
		
		int[] v1 = new int[]{1, 10, 20, 0, 59, 63, 0, 88, 0};
		System.out.println("\n"+"Original Array: "+Arrays.toString(v1));
		move_zeros_to_left_in_array(v1);
		for(int i = 0 ; i < v1.length; i++) {
			System.out.print(v1[i] + ", ");
		}
	}  
}
