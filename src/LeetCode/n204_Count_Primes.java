package LeetCode;

import java.util.Arrays;

public class n204_Count_Primes {
	public int countPrimes2(int n) {
		if(n <= 2) {
			return 0;
		}
		
		//https://www.youtube.com/watch?v=KMzyTDQ7_Ek&t=83s
		boolean[] prime = new boolean[n];
		Arrays.fill(prime, true);
		
		int res = n - 2;	//not count 1 and n itself
		
		for(int i=2; i*i<n; i++) {
			if(!prime[i*i]) {
				continue;
			}
			
			for(int j=i; j*i<n; j++) {
				if(prime[j*i]) {
					prime[j*i] = false;
					res--;
				}
			}
		}
		
		return res;
	}
	
	
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
		
		System.out.println(obj.countPrimes2(10));
		System.out.println(obj.countPrimes2(100));
	}
}
