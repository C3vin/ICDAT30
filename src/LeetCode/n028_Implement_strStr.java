package LeetCode;

//Implement strStr().
//Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
public class n028_Implement_strStr {
	//Brute Force
	public int strStr(String haystack, String needle) {
		if(haystack == null || needle == null)
			return 0;
		/*if(haystack.length() < needle.length())
			return 0;*/
		if(needle.length() == 0)
			return 0;
		for(int i=0; i <= haystack.length()-needle.length(); i++) {		//need =, e.g. 6-4=2 but 0~2 will return -1, need 0~3. so need <= 
			for(int j=0; j < needle.length(); j++) {
				if(haystack.charAt(i+j) != needle.charAt(j)) {			//use != much easy than == in this case
					break;
				}
				if(j == needle.length()-1)		//F: need to needle.length() - 1
					return i;
			}
		}
		return -1;

		/*if(haystack == null || needle == null) return -1;
		if(needle.length() > haystack.length()) return -1;
		//if(needle.equals(haystack)) return 0;

		for(int i=0; i<=haystack.length() - needle.length(); i++) {
			int j=0;
			while(j < needle.length() && haystack.charAt(i+j) == needle.charAt(j)) {
				j++;
				System.out.println("j: " +j);
			}
			System.out.println("#i: " +i);
			if(j == needle.length()) 
				return i;
		}
		return -1;*/
	}

	//BM (Boyer-Moore)
	public int strStrBM(String haystack, String needle) {
		int hlen = haystack.length();
		int nlen = needle.length();
		int[] jump = new int[256];  // hashmap char-> index, assume ASCII
		for(int i=0; i<jump.length; i++) {
			jump[i]=-1;
		}
		for(int i=0; i<nlen; i++) {
			jump[needle.charAt(i)] = i; // index of last occurrence
		}
		int skip=0;
		for(int i=0; i<hlen-nlen+1; i+=skip) { // !!! not i<hlen 
			skip=0;
			for(int j=nlen-1; j>=0; j--) {
				if(haystack.charAt(i+j)!=needle.charAt(j)) {
					skip =Math.max( 1, j-jump[haystack.charAt(i+j)] );    // max is j+1, min is 1 (do not allow <0);
					break;
				}
			}
			if(skip==0) return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		n028_Implement_strStr obj = new n028_Implement_strStr();
		System.out.println(obj.strStr("111234", "1234"));
		System.out.println(obj.strStrBM("111234", "1234"));
	}
}
