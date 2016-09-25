package LeetCode;

public class n135_Candy {
	  public int candy(int[] ratings) {
		  /**
		   * For 1   2   3   3   3
      			 1   2   3   1   1 , so sum = 8
			 For 1   2   3   2   3
      			 1   2   3   1   2 , so sum = 9
		   */
		  if(ratings == null || ratings.length == 0) return 0;
		  
		  int[] right = new int[ratings.length];
		  int[] left = new int[ratings.length];
		  
		  //left to right
		  left[0] = 1;					//F: Need to give first one!!!   F: And the value must 1, can't give ratings[0]!
		  for(int i=1; i<ratings.length; i++) {
			  if(ratings[i] > ratings[i-1]) {
				  left[i] = left[i-1]+1;
			  }
			  else
				  left[i] = 1;
		  }
		  
		  //right to left
		  right[ratings.length-1] = left[ratings.length-1];		//F:?? 
		  for(int i=ratings.length-2; i>=0; i--) {				//F: i--
			  if(ratings[i] > ratings[i+1]) {
				  right[i] = right[i+1] + 1;
			  }
			  else
				  right[i] = 1;
		  }

		  int res = 0;
		  for(int i=0; i<ratings.length; i++) {
			  res += Math.max(left[i], right[i]);
		  }
		  return res;
	  }
	  public static void main(String[] args) {
		  n135_Candy obj = new n135_Candy();
		  int[] ratings = {1,2,3,3,3};
		System.out.print(obj.candy(ratings));
	  }
}
