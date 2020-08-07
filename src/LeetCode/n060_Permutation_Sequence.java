package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
The set [1,2,3,...,n] contains a total of n! unique permutations.
By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:
Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.

Example 1:
Input: n = 3, k = 3
Output: "213"

Example 2:
Input: n = 4, k = 9
Output: "2314"
 */
public class n060_Permutation_Sequence {
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for(int i=0; i<n; i++) {
        	nums[i] = i+1;
        }
        
        List<String> res = new ArrayList<String>();	//change LC46 sol
        boolean[] used = new boolean[nums.length];
        StringBuilder sb = new StringBuilder();		//sb no need to convert
        
        dfs(nums, k, res, used, sb);

        return res.get(k-1);
    }
    
    //LC46 sol change little
    private void dfs(int[] nums, int k, List<String> res, boolean[] used, StringBuilder sb) {
    	if(res.size() == k) {				//need added this cuz TLE  !!!
    		return;
    	}
    	if(sb.length() == nums.length) {
    		res.add(sb.toString());
    		
    		return;
    	}
    	
    	for(int i=0; i<nums.length; i++) {
    		if(used[i]) {
    			continue;
    		}
    		
    		sb.append(nums[i]);					//same as LC46, but used StringBuilder
    		used[i] = true;
    		
    		dfs(nums, k, res, used, sb);
    		
    		sb.deleteCharAt(sb.length()-1);
    		used[i] = false;
    	}
    }
    
    public static void main(String[] args) {
    	n060_Permutation_Sequence obj = new n060_Permutation_Sequence();
    	System.out.println(obj.getPermutation(3, 3));
    	System.out.println(obj.getPermutation(4, 9));
    }
}
