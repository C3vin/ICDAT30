package INQ.A;

import java.util.HashMap;

public class changeCoins {
	public void dispenseChange(double coins){
		int totalCoins = (int)(coins * 100);

		int chnageQ = totalCoins / 25;
		int changeD = totalCoins / 10;
		int changeN = totalCoins / 5;
		int changeP = totalCoins;
		int min = Integer.MAX_VALUE;
		int minGlobal = Integer.MAX_VALUE;
		int count = 0;
		HashMap<Integer, int[]> map = new HashMap<Integer, int[]>();
		int[] num = new int[4];

		for(int q=0; q<= chnageQ; q++) {
			for(int d=0; d<= changeD; d++) {
				for(int n=0; n<= changeN; n++) {
					for(int p=0; p<=changeP; p++) {
						if(((q*25) + (d*10) + (n*5) + p ) == totalCoins) {
							count = q + d + n + p;
							min = Math.min(min, count);
							if(min <= count) {
								num[0] = q;
								num[1] = d;
								num[2] = n;
								num[3] = p;
							}
							map.put(min, num);
						}
					}
				}
			}
		}
		minGlobal = Math.min(min, minGlobal);
		System.out.println("Count: "+minGlobal);

		if(map.containsKey(minGlobal)) {
			System.out.println("Quarters: "+map.get(minGlobal)[0] + " Dimes: "+map.get(minGlobal)[1] + " Nickels: "+map.get(minGlobal)[2] + " Pennies: "+map.get(minGlobal)[3]);
		}
	}
	public static void main(String[] args) {
		changeCoins obj = new changeCoins();
		obj.dispenseChange(0.33);
		obj.dispenseChange(0.50);
	}
}
