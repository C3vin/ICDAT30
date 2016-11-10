package LeetCode;

import java.util.ArrayList;
import java.util.List;

@Alg(type="Backtracking", com="AA", level="med", num=89)
/**
n = 0,[0]
n = 1,[0,1]
n = 2,[00,01,11,10]
n = 3,[000,001,011,010,110,111,101,100]  0+ first half | reverse + addNum
 *
 */
public class n089_Gray_Code {
	public List<Integer> grayCode(int n) {
		List<Integer> res;
		if(n==0) {
			res = new ArrayList<Integer>();
			res.add(0);
			return res;
		}
		res = grayCode(n-1);
		int addNum = 1<<(n-1);					//1<<1 = 10, 1<<2 = 100... 1<<(n-1)
		for(int i = res.size()-1; i>=0; i--) {
			res.add(addNum+res.get(i));
		}
		return res;
	}
	public static void main(String[] args) {
		n089_Gray_Code obj = new n089_Gray_Code();
		System.out.println(obj.grayCode(3));
	}
}
