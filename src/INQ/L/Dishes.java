package INQ.L;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dishes {
	public void category(String str) throws Exception {
		BufferedReader br = new BufferedReader(new StringReader(str));
		String line = null;

		Map<String,Set<String>> dish = new HashMap<String,Set<String>>();
		while((line = br.readLine()) != null) {
			String[] s1 = line.trim().split(":");

			Set<String> food = new HashSet<String>();
			for(String s: s1[1].split(",")) {
				food.add(s.trim());
			}
			//System.out.println(food);
			dish.put(s1[0].trim(), food);
		}
		br.close();

		String[] keys = new String[dish.size()];
		int k=0;
		//dish.keySet().toArray(keys);
		for(String j : dish.keySet()) {
			keys[k++] = j;
		}
		
		for(int i=0; i<keys.length; i++) {
			String k1 = keys[i];
			for(int j=i+1; j<keys.length; j++) {
				String k2 = keys[j];

				//if(Sets.intersection(dish.get(k1), dish.get(k2)).size() > 0)
				if(hasInt(dish.get(k1), dish.get(k2)))
					System.out.println("(" + k1 + ", " + k2 + ")");
			}
		}
	}
	private boolean hasInt(Set<String> s1, Set<String> s2) {
		for(String ss1: s1) {
			if(s2.contains(ss1)) return true;
		}
		return false;
	}
	public static void main(String[] args) throws Exception {
		Dishes obj = new Dishes();
		String dishes =
				"Pasta: Tomato Sauce, Onions, Garlic\n"+
				"Chicken Curry: Chicken, Curry Sauce\n"+
				"Fried Rice: Rice, Onions, Nuts\n"+
				"Salad: Spinach, Nuts\n"+
				"Sandwich: Cheese, Bread\n"+
				"Quesadilla: Chicken, Cheese";
		obj.category(dishes);
	}
}
