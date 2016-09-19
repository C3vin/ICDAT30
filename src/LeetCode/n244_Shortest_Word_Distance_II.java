package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class n244_Shortest_Word_Distance_II {
	
	HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
	
	public n244_Shortest_Word_Distance_II(String[] words) {
		for(int i = 0; i < words.length; i++){
			List<Integer> cnt = map.get(words[i]);
			if(cnt == null){
				cnt = new ArrayList<Integer>();		//?
			}
			cnt.add(i);
			map.put(words[i], cnt);		//{makes=[1, 4], practice=[0], perfect=[2], coding=[3]}
		}
	}

	public int shortest(String word1, String word2) {
		List<Integer> idx1 = map.get(word1);
		List<Integer> idx2 = map.get(word2);
		System.out.println("@: "+idx1.size() + " : " +idx2.size());
		int distance = Integer.MAX_VALUE;
		int i = 0, j = 0;
		while(i < idx1.size() && j < idx2.size()){
			distance = Math.min(Math.abs(idx1.get(i) - idx2.get(j)), distance);
			if(idx1.get(i) < idx2.get(j)){
				i++;
			} else {
				j++;
			}
		}
		return distance;
	}

	public static void main(String[] args) {
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		n244_Shortest_Word_Distance_II obj = new n244_Shortest_Word_Distance_II(words);
		System.out.println(obj.map.toString());
		System.out.println(obj.shortest("coding", "practice"));
		System.out.println(obj.shortest("makes", "coding"));
	}
}
