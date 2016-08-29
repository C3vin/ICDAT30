package LeetCode;

public class n038_Count_and_Say {
	public String countAndSay(int n) {
				if (n <= 0)
			return null;

		String result = "1";
		int i = 1;
		while (i < n) {
			StringBuilder sb = new StringBuilder();
			int count = 1;
			for (int j=1; j<result.length(); j++) {
				if (result.charAt(j) == result.charAt(j - 1)) {
					count++;
				} else {
					sb.append(count);
					sb.append(result.charAt(j - 1));
					count = 1;
				}
			}
			sb.append(count);
			sb.append(result.charAt(result.length() - 1));
			result = sb.toString();
			i++;
		}
		return result;
	}

	public static void main(String[] args) {
		n038_Count_and_Say obj = new n038_Count_and_Say();
		System.out.println(obj.countAndSay(1));
		System.out.println(obj.countAndSay(2));
		System.out.println(obj.countAndSay(3));
		System.out.println(obj.countAndSay(4));
	}
}
