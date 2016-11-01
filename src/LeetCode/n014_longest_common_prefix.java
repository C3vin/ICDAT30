package LeetCode;

public class n014_longest_common_prefix {
	public String longestCommonPrefix(String[] strs) {
	    if(strs==null || strs.length==0)
	        return "";
	 
	    if(strs.length==1) 
	        return strs[0];
	 
	    int minLen = strs[0].length();
	    for(String str: strs){
	        if(minLen > str.length()){
	            minLen = str.length();
	        }
	    }
	    System.out.println(minLen);
	    
	    for(int i=0; i<minLen; i++){
	        for(int j=0; j<strs.length-1; j++){
	            String s1 = strs[j];
	            String s2 = strs[j+1];
	            if(s1.charAt(i)!=s2.charAt(i)){
	                return s1.substring(0, i);
	            }
	        }
	    }
	    return strs[0].substring(0, minLen);
	}
	
	public static void main(String[] args) {
		String strs[] = new String[]{"aaaaae", "aaaaabyrrrrrr", "aaaaaew"};
		n014_longest_common_prefix obj = new n014_longest_common_prefix();
		System.out.println(obj.longestCommonPrefix(strs));
		
	}
}
