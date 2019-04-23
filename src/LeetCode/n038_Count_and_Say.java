package LeetCode;

/*
The count-and-say sequence is the sequence of integers with the first five terms as following:
1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
 */
public class n038_Count_and_Say {
	public String countAndSay(int n) {
		if (n <= 0) {
			return null;
		}

		String result = "1";
		int round = 1;
		while (round < n) {
			StringBuilder sb = new StringBuilder();
			int count = 1;			
			for (int i=1; i<result.length(); i++) {
				//same value
				if (result.charAt(i) == result.charAt(i - 1)) {
					count++;
				} else {
					//new value
					sb.append(count);
					sb.append(result.charAt(i - 1));			//need i - 1 
					count = 1;		//reset
				}
			}
			sb.append(count);
			sb.append(result.charAt(result.length() - 1));
			result = sb.toString();
			round++;				 
		}
		return result;
	}
	
	public static void main(String[] args) {
		n038_Count_and_Say obj = new n038_Count_and_Say();
		System.out.println(obj.countAndSay(1));
		System.out.println(obj.countAndSay(2));
		System.out.println(obj.countAndSay(3));
		System.out.println(obj.countAndSay(4));
		System.out.println(obj.countAndSay(5));
	}
}
