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
		int startIndex = 0;
		while(i < n && j < n) {
			if(!set.contains(orders[j])) {
				set.add(orders[j]);
				j++;
				if(maxRange < j - i) {
					maxRange = j - i;						//update maxRange & startIndex
					startIndex = i;						 
					/*res = new ArrayList<String>();		//each time create a new ArrayList
					for(int k = i; k<i+maxRange; k++) {		//No need to add in here, just get the startIndex
						res.add(orders[k]);
					}*/
				}
			} else {
				set.remove(orders[i]);
				i++;
			}
		}
		//System.out.println("maxRange: "+maxRange + " startIndex: "+startIndex);
		for(int k = startIndex; k < startIndex+maxRange; k++) 
			res.add(orders[k]);
		
		return res;
	}

	public static void main(String[] args) {
		AA_Longest_order obj = new AA_Longest_order();
		String[] orders = {"Water", "Banana", "OJ", "Fish", "OJ", "Water", "Cookie", "Apple", "Water", "OJ", "Banana", "Fish", "Cookie", "Fish"};
		System.out.print(obj.findLongestOrder(orders));
	}
}
