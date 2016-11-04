package LeetCode;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Leetcode {
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		Enumeration<URL> resources = classLoader.getResources("LeetCode/");
		int count = 0;
		Map<Integer,String> questions = new HashMap<Integer, String>();
		while (resources.hasMoreElements()) {
			URL resource = resources.nextElement();
			System.out.println(resource);
			File dir = new File(resource.getFile());
			for(File file: dir.listFiles()) {
				if(!file.getName().endsWith(".class")) continue;
				Class<?> klazz = Class.forName("LeetCode." + file.getName().substring(0, file.getName().length() - 6));

				Alg lc = klazz.getAnnotation(Alg.class);
				if(lc != null) {
					System.out.println(lc.num());
					questions.put(lc.num(), String.format("#%s - %s - %s- %20s", lc.com(), lc.type(), lc.level(), klazz.getName()));

					count++;
				}
			}
		}
		System.out.println("Total @LeetCode = " + count);
		Set<Integer> keys = new TreeSet<Integer>(questions.keySet());
		for(Integer key: keys) {
			System.out.println(keys);
			System.out.println(questions.get(key));
		}
	}
}
