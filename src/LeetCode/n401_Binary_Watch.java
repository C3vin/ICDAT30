package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class n401_Binary_Watch {
	public List<String> readBinaryWatch(int num) {
		List<String> res = new ArrayList<String>();

		for(int i=0; i<12; i++) {
			for(int j=0; j<60; j++) {
				int total = countDigits(i)+countDigits(j);
				
				if(total==num) {
					//System.out.println(i+ ": "+j+" : "+ countDigits(i) +" : "+countDigits(j));
					String s="";
					s = s + i+":";

					if(j<10) {
						s = s + "0"+j;
					}else {
						s = s + j;
					}
					res.add(s);
				}
			}
		}
		return res;
	}
	public int countDigits(int num){
		int result=0;

		while(num>0){			//cuz num>>=1
			if((num&1)==1){
				result++;
			}
			num>>=1;
		}
		return result;
	}
	public static void main(String[] args) {
		n401_Binary_Watch obj = new n401_Binary_Watch();
		System.out.println(obj.readBinaryWatch(0));
	}
}
