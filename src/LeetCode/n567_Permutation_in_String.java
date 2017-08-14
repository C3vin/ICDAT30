package LeetCode;

/*Input:s1 = "ab" s2 = "eidbaooo"
  Output:True
  Explanation: s2 contains one permutation of s1 ("ba").*/

public class n567_Permutation_in_String {
	 public boolean checkInclusion(String s1, String s2) {
		 int[] target = new int[256];
		 
		 for(int i=0; i<s1.length(); i++) {
			 target[s1.charAt(i)]++;
		 }
		 
		 int left = 0;
		 int right = 0;
		 int count = s1.length();
		 while(right < s2.length()) {
			 if(target[s2.charAt(right)] >= 1)
				 count--;
			 target[s2.charAt(right)]--;
			 right++;
			 
			 if(count == 0)
				 return true;
			 
			 if(right - left == s1.length()) {
				 if(target[s2.charAt(left)] >= 0)		//>=0, not <=0. Because before at least 1
					 count++;
				 
				 target[s2.charAt(left)]++;
				 left++;
			 }
		 }
		 return false;
	 }
	 public static void main(String[] args) {
		 n567_Permutation_in_String obj = new n567_Permutation_in_String();
		 String s1 = "ab";
		 String s2 = "eidbaooo";
		 System.out.println(obj.checkInclusion(s1, s2));
	 }
}
