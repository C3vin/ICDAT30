package LeetCode;

/*
Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
Note that elements beyond the length of the original array are not written.
Do the above modifications to the input array in place, do not return anything from your function.

Example 1:
Input: [1,0,2,3,0,4,5,0]
Output: null
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
Example 2:
Input: [1,2,3]
Output: null
Explanation: After calling your function, the input array is modified to: [1,2,3]

Note:

1 <= arr.length <= 10000
0 <= arr[i] <= 9
Accepted
 */
public class n1089_Duplicate_Zeros {
	//Need to in-place
	//slow, O(n^2), but understandable 
	public void duplicateZeros(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==0) {
				for(int j=arr.length-1; j>i; j--) {
					arr[j]=arr[j-1];
				}
				i++;
			}
		}
		
		for(int a : arr) {
			System.out.println(a);
		}
	}
	
	public static void main(String[] args) {
		n1089_Duplicate_Zeros obj = new n1089_Duplicate_Zeros();
		obj.duplicateZeros(new int[] {1,0,2,3,0,4,5,0});
	}
}
