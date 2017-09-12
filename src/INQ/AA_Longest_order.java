package INQ;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AA_Longest_order {
	public List<String> findLongestOrder(String[] orders){
		int n = orders.length;
		HashSet<String> set = new HashSet<String>();
		int i = 0;
		int j = 0;
		ArrayList<String> res = new ArrayList<String>();
		int maxRange = 0;
		while(i < n && j < n) {
			if(!set.contains(orders[j])) {
				set.add(orders[j]);
				j++;
				if(maxRange < j - i) {
					maxRange = j - i;
					//System.out.println("maxRange: "+maxRange + " i: "+i + " j: "+j);
					res = new ArrayList<String>();
					for(int k = i; k<i+maxRange; k++) {
						System.out.println("i: "+i + " j:" + j);
						res.add(orders[k]);
					}
				}
			} else {
				set.remove(orders[i]);
				i++;
			}
		}
		System.out.println("maxRange: "+maxRange);
		return res;
	}

	public static void main(String[] args) {
		AA_Longest_order obj = new AA_Longest_order();
		String[] orders = {"Water", "Banana", "OJ", "Fish", "OJ", "Water", "Cookie", "Apple", "Water", "OJ", "Banana", "Fish", "Cookie", "Fish"};
		//String[] orders = {"Water", "OJ", "Banana", "Fish", "Cookie", "Apple","Water", "Banana", "OJ", "Fish", "OJ", "Water", "Cookie", "Apple"};
		System.out.print(obj.findLongestOrder(orders));
	}
}
