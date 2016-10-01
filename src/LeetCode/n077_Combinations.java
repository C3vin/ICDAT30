package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class n077_Combinations {
	  public List<List<Integer>> combine(int n, int k) {
		  List<List<Integer>> res = new ArrayList<List<Integer>>();  
			List<Integer> tmp = new ArrayList<Integer>();  
		       //res.add(tmp);  
		       dfs(res,tmp,k,n,1);  
		       return res;  
	  }
	  public void dfs(List<List<Integer>> res, List<Integer> tmp, int k, int n, int pos){  
	        for(int i=pos; i<=n; i++){  
	            tmp.add(pos); 
	            if(tmp.size() == k)
	            	res.add(new ArrayList<Integer>(tmp));  
	            dfs(res,tmp,k,n,i+1);  
	            tmp.remove(tmp.size()-1);  
	        }  
	    } 
	  public static void main(String[] args) {
		  n077_Combinations obj = new n077_Combinations();
		  System.out.println(obj.combine(3, 2));
	  }
}
