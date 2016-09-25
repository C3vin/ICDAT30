package LeetCode;

public class n042_Trapping_Rain_Water {
	 public int trap(int[] height) {
	        if (height == null || height.length == 0)  
	            return 0;  
	          
	        int i, max, total = 0;
	        int left[] = new int[height.length];
	        int right[] = new int[height.length];  
	  
	        // from left to right
	        left[0] = height[0];
	        max = height[0];
	        for (i=1; i<height.length; i++) {  				//i = 1
	            left[i] = Math.max(max, height[i]);
	            max = Math.max(max, height[i]);
	        }  
	  
	        // from right to left
	        right[height.length-1] = height[height.length-1];
	        max = height[height.length-1];
	        for (i=height.length-2; i>=0; i--) {  			//why height.length - 2?
	        	System.out.println(i);
	            right[i] = Math.max(max, height[i]);
	            max = Math.max(max, height[i]);
	        }  
	  
	        // trapped water (when i==0, it cannot trapped any water)
	        for (i=1; i<height.length-1; i++) {  
	            int bit = Math.min(left[i], right[i]) - height[i];  
	            if (bit > 0)  
	                total += bit;  
	        }  
	        
	        return total;  
	        /***
	         *      index: 0  1  2  3  4  5  6  7  8  9  10 11
    		  	 A[index]: 0  1  0  2  1  0  1  3  2  1  2  1
  		      left[index]: 0  1  1  2  2  2  2  3  3  3  3  3
			 right[index]: 3  3  3  3  3  3  3  3  2  2  2  1
        	  	   min[i]: 0  1  1  2  2  2  2  3  2  2  2  1
          		   bit[i]: -  0  1  0  1  2  1  0  0  1  0  0 
	         */
	 }
	 
	 public static void main(String[] artgs) {
		 n042_Trapping_Rain_Water obj = new n042_Trapping_Rain_Water();
		 int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(obj.trap(height));
	 }
}
