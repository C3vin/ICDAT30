package LeetCode;

import java.util.Arrays;

public class n204_Count_Primes {
	public int countPrimes(int n) {
		//an integer to be prime it must be greater than 1
		boolean[] prime = new boolean[n];
		Arrays.fill(prime, true);

		for(int i=2; i<n; i++) {
			if(prime[i]) {
				for(int j=i*2; j<n; j=j+i) {			//F: j= j + i
					prime[j] = false;
				}
			}
		}
		int count = 0;
		for(int c=2; c<n; c++) {
			if(prime[c]) 
				count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		n204_Count_Primes obj = new n204_Count_Primes();
		System.out.println(obj.countPrimes(100));
	}
}
