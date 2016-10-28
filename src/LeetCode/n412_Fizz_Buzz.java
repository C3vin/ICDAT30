package LeetCode;

import java.util.ArrayList;
import java.util.List;
// need to check i%3 && i%5 first
public class n412_Fizz_Buzz {
	  public List<String> fizzBuzz(int n) {
		  List<String> res = new ArrayList<String>();
		  for(int i=1; i<=n; i++) {
			  if(i%3 == 0 && i%5 == 0) {
				  res.add("FizzBuzz");
			  }
			  else if(i%5 == 0) {
				  res.add("Buzz");
			  } else if(i%3 == 0) {
				  res.add("Fizz");
			  } else
				  res.add(String.valueOf(i));
		  }
		  return res;
	  }
	  
	  public static void main(String[] args) {
		  n412_Fizz_Buzz obj = new n412_Fizz_Buzz();
		  System.out.println(obj.fizzBuzz(15));
	  }
}
