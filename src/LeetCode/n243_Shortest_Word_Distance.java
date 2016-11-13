package LeetCode;

@Alg(type="Array", com="L", level="easy", num=242)
public class n243_Shortest_Word_Distance {
	public int shortestDistance(String[] words, String word1, String word2) {
		int idx1=-1;	//default
		int idx2=-1;
		int distance = Integer.MAX_VALUE;
		for(int i=0; i<words.length; i++) {
			if(words[i].equals(word1)) {	//words[i]
				idx1 = i;
				if(idx2!=-1)		//need this idx2 != -1
					distance = Math.min(distance, idx1-idx2);
			}else if(words[i].equals(word2)) {
				idx2 = i;
				if(idx1!=-1)
					distance = Math.min(distance, idx2-idx1);
			}
		}
		return distance;
	}

	public static void main(String[] args) {
		n243_Shortest_Word_Distance obj = new n243_Shortest_Word_Distance();
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		System.out.println(obj.shortestDistance(words, "coding", "practice"));
		System.out.println(obj.shortestDistance(words, "makes", "coding"));
	}
}
