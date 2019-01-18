package Java.KB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class collections {
	public static void main(String args[]){
		/*
		 * Iterator 
		 */
		ArrayList<String> animal = new ArrayList<String>();
		animal.add("Horse");
		animal.add("Lion");
		animal.add("Tiger");
		animal.addAll(Arrays.asList("Bird", "Frog"));
		
		Iterator animalItr = animal.iterator();

		while(animalItr.hasNext()) {
			System.out.println(animalItr.next());
		}
	}

}
