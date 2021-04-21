package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
Given a string s, sort it in decreasing order based on the frequency of characters, and return the sorted string.

Example 1:
Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Example 2:
Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.

Example 3:
Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 */
public class n451_Sort_Characters_By_Frequency {
	public String frequencySort(String str) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(char c : str.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		
		PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<Map.Entry<Character, Integer>>((a, b) -> {
			return b.getValue() - a.getValue();		//b - a so more frequency char will first poll()
		});
		
		pq.addAll(map.entrySet());
		
		StringBuilder sb = new StringBuilder();
		
		while(!pq.isEmpty()) {
			Map.Entry<Character, Integer> entry = pq.poll();
			
			for(int i=0; i<entry.getValue(); i++) {
				sb.append(entry.getKey());
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		n451_Sort_Characters_By_Frequency obj = new n451_Sort_Characters_By_Frequency();
		System.out.println(obj.frequencySort("tree"));
	}
}
