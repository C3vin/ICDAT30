package LeetCode;
/*
Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
Note:

Note that in some languages, such as Java, there is no unsigned integer type. In this case, the input will be given as a signed integer type. It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3, the input represents the signed integer. -3.
Example 1:
Input: n = 00000000000000000000000000001011
Output: 3
Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
Example 2:

Input: n = 00000000000000000000000010000000
Output: 1
Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
Example 3:

Input: n = 11111111111111111111111111111101
Output: 31
Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.

Constraints:
The input must be a binary string of length 32.

Follow up: If this function is called many times, how would you optimize it?
 */
public class n191_Number_of_1_Bits {
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		/* https://leetcode.wang/leetcode-191-Number-of-1-Bits.html
		有一个方法，可以把最右边的 1 置为 0，举个具体的例子。
		比如十进制的 10，二进制形式是 1010，然后我们只需要把它和 9 进行按位与操作，也就是 10 & 9 = (1010) & (1001) = 1000，也就是把 1010 最右边的 1 置为 0。
		规律就是对于任意一个数 n，然后 n & (n-1) 的结果就是把 n 的最右边的 1 置为 0 
		*/
		int count = 0;
		
		while(n != 0) {
			n = n & (n-1);
			count++;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		n191_Number_of_1_Bits obj = new n191_Number_of_1_Bits();
		System.out.println(obj.hammingWeight(00000000000000000000000000001011));
	}
}
