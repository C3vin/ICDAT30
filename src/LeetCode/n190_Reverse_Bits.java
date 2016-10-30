package LeetCode;

public class n190_Reverse_Bits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++, n >>= 1){
            res = res << 1 | (n & 1);
            //System.out.println("n: " + n +" i:"+ i + " res: " + res);
        }
        return res;  
    }
    
    public static void main(String[] args) {
    	n190_Reverse_Bits obj = new n190_Reverse_Bits();
    	System.out.println(obj.reverseBits(43261596));
    }
}
