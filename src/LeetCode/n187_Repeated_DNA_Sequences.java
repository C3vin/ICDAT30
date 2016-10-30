package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class n187_Repeated_DNA_Sequences {
	//sol1: hash
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> res = new ArrayList<String>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for(int index=10; index<=s.length(); index++) {		//<=
			String sub = s.substring(index-10, index);
			if(map.containsKey(sub)) {
				if(map.get(sub)==1)
					res.add(sub);
				map.put(sub, 2);
			} else {
				map.put(sub, 1);
			}
		}
		return res;
	}

	//sol2: hash + bit opt
	public List<String> findRepeatedDnaSequences2(String s) {
		List<String> res = new ArrayList<String>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for(int index=10; index<=s.length(); index++) {
			String sub = s.substring(index-10, index);
			int code = encode(sub);
			if(map.containsKey(code)) {
				if(map.get(code) == 1)
					res.add(sub);
				map.put(code, 2);
			}else {
				map.put(code, 1);
			}
		}
		return res;
	}
	private int encode(String sub) {
		int code = 0;
		for(int i=0; i<sub.length(); i++){
			char c = sub.charAt(i);
			code<<=2;		//make sure every 2 bit present 1 word.
			switch(c) {
				case 'A': code = code + 0;
				break;
				case 'C': code = code + 1;
				break;
				case 'T': code = code + 2;
				break;
				case 'G': code = code + 3;
				break;
			}
		}
		return code;
	}

	public static void main(String[] args) {
		n187_Repeated_DNA_Sequences obj = new n187_Repeated_DNA_Sequences();
		System.out.println(obj.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
		System.out.println(obj.findRepeatedDnaSequences2("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
	}
}
