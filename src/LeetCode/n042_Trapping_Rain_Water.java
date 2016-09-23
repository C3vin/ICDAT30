package LeetCode;

public class n042_Trapping_Rain_Water {
	 public int trap(int[] height) {
		    if(height==null || height.length==0)  
		        return 0;  
		    int max = 0;  
		    int res = 0;  
		    int[] container = new int[height.length];  
		    for(int i=0;i<height.length;i++)  
		    {  
		        container[i]=max;  
		        max = Math.max(max,height[i]);  
		    }  
		    max = 0;  
		    for(int i=height.length-1;i>=0;i--)  
		    {  
		        container[i] = Math.min(max,container[i]);  
		        max = Math.max(max,height[i]);  
		        res += container[i]-height[i]>0? container[i]-height[i] : 0;  
		    }      
		    return res;  
	 }
	 
	 public static void main(String[] artgs) {
		 n042_Trapping_Rain_Water obj = new n042_Trapping_Rain_Water();
		 int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(obj.trap(height));
	 }
}
