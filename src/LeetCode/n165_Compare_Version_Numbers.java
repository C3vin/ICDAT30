package LeetCode;

@Alg(type="String", com="A,M$", level="easy", num=165)
public class n165_Compare_Version_Numbers {
	public int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\.");		//F: need "\\."
		String[] v2 = version2.split("\\.");
		int length1 = v1.length;
		int length2 = v2.length;
		int maxLen = Math.max(length1, length2);
		for(int i=0; i<maxLen; i++) {
			int tmp1 = 0;
			int tmp2 = 0;
			if(i<length1)		//need this in case i> v1.length 
				tmp1 = Integer.parseInt(v1[i]);
			if(i<length2)
				tmp2 = Integer.parseInt(v2[i]);
			
			if(tmp1 > tmp2) 
				return 1;
			else if(tmp1 < tmp2)
				return -1;
		}
		return 0;
	}
	public static void main(String[] args) {
		n165_Compare_Version_Numbers obj = new n165_Compare_Version_Numbers();
		String version1 = "1";
		String version2 = "1.3711";
		System.out.println(obj.compareVersion(version1, version2));
	}
}
