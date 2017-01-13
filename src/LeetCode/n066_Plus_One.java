package LeetCode;

//Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
//You may assume the integer do not contain any leading zero, except the number 0 itself.
//The digits are stored such that the most significant digit is at the head of the list.
public class n066_Plus_One {
	public int[] plusOne(int[] digits) {
		for(int i = digits.length-1; i>=0; i--){
			if(digits[i]<9){
				digits[i]++;
				break;
			}else{
				digits[i]=0;
			}
		}
		int[] newdigits;
		if(digits[0] == 0) {
			newdigits = new int[digits.length+1];
			newdigits[0] = 1; //update
			for(int i=1; i<newdigits.length; i++) {
				newdigits[i] = digits[i-1];
			}
		} else {
			newdigits = new int[digits.length];
			for(int i=0; i<digits.length; i++) {
				newdigits[i] = digits[i];
			}
		}

		return newdigits;
	}
	public int[] plusOne2(int[] digits) {
		for(int i=digits.length-1; i>=0; i--) {
			digits[i] = digits[i]+1;
			if(digits[i] == 10) {
				digits[i] = 0;
			} else 
				return digits;
		}
		int[] newdigits = new int[digits.length+1];
		newdigits[0] = 1;
		for(int i=1; i<digits.length; i++) {
			newdigits[i] = digits[i-1];
		}
		return newdigits;
	}
	public static void main(String[] args) {
		n066_Plus_One obj = new n066_Plus_One();
		int[] digits = {9,9};
		//System.out.println(obj.plusOne(digits));
		System.out.println(obj.plusOne2(digits));
	}
}
