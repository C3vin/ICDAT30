package INQ.WL;

public class MaximumSum {
	public int FindMaxSum(int arr[]) {
		int len = arr.length;
		if(len < 1) return 0;
		
		int pprev = 0;
		int prev = arr[0];
		int cur = prev;
		
		for(int i=1; i<len; i++) {
			cur = Math.max(prev, pprev+arr[i]);		//update cur
			pprev = prev;
			prev = cur;
		}
		
		return cur;
	}
	
	public static void main(String[] args) {
		MaximumSum obj = new MaximumSum();
		int arr[] = new int[]{5, 3, 10, 100, 12, 6};
		System.out.println(obj.FindMaxSum(arr));
	}
}
