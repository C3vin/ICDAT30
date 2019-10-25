package HackingtheCodingInterview.Arrays;

public class Binary_Search {
	//Recursive time:O(logn) space:O(logn)
	//Recursive solution has O(logn) memory complexity as it will consume memory on the stack.
	static int binarySearchRec(int[] a, int key, int low, int high) {
		if(low > high) {
			return -1;
		}

		int mid = (high - low)/2 + low;				//high - low not +
		if(a[mid] == key) {
			return mid;
		} else if(key < a[mid]) {
			return binarySearchRec(a, key, low, mid-1);
		} else {
			return binarySearchRec(a, key, mid+1, high);
		}
	}
	static int binSearch(int[] a, int key) {
		return binarySearchRec(a, key, 0, a.length - 1);
	}

	//Iterative time:O(logn) space:O(1)
	static int binSearch2(int[] A, int key) {
		int low = 0;
		int high = A.length-1;
		
		while(low <= high) {
			int mid = (high - low)/2 + low;
			
			if(A[mid] == key) {
				return mid;
			}
			
			if(key < A[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
	public static void main(String []args){
		int[] arr1 = {1,2,4,7,8,12,15,19,24,50,69,80,100};
		System.out.println("Key(12) found at: "+binSearch(arr1,12));
		System.out.println("Key(44) found at: "+binSearch(arr1,44));
		System.out.println("Key(80) found at: "+binSearch(arr1,80));
		System.out.println("Key(12) found at: "+binSearch2(arr1,12));
		System.out.println("Key(44) found at: "+binSearch2(arr1,44));
		System.out.println("Key(80) found at: "+binSearch2(arr1,80));
	}  
}
