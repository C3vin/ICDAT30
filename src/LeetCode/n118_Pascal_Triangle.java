import java.util.ArrayList;
import java.util.List;

public class n118_Pascal_Triangle {
	/*
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
	 */
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();	
		if(numRows <0) return res;
		
		ArrayList<Integer> pre = new ArrayList<Integer>();
		pre.add(1);
		res.add(pre);
		
		for(int i =2; i<numRows; i++) {
			ArrayList<Integer> cur = new ArrayList<Integer>();
			cur.add(1);
			for(int j=0; j<pre.size()-1; j++) {
				cur.add(pre.get(j)+pre.get(j+1));
			}
			cur.add(1);
			res.add(cur);
			pre=cur;		//reset
		}
		return res;
	}
	
	public static void main(String[] args) {
		n118_Pascal_Triangle obj = new n118_Pascal_Triangle();
		System.out.println(obj.generate(6));
	}
}

