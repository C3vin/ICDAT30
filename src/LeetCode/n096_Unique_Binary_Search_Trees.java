package LeetCode;

@Alg(type="DP,Tree", com="Snap", level="med", num=96)
/**
 * 
 1               1                   2                     3             3
  \               \                /   \                  /             / 
    3              2              1     3                2             1
   /                 \                                  /               \
 2                    3                                1                 2 
 *
 *  Count[3] = Count[0]*Count[2]  (1 is root) left 0 node, right 2 node
               + Count[1]*Count[1]  (2 is root) left 1 node, right 1 node
               + Count[2]*Count[0]  (3 is root) left 2 node, right 0 node
 */
public class n096_Unique_Binary_Search_Trees {
	//DP sol 
	public int numTrees(int n) {
		int[] c = new int[n+1];
		c[0] = 1; 
		c[1] = 1;
		for(int i=2; i<n+1; i++) {
			for(int j=0; j<i; j++) {
				c[i] = c[i] + c[j]*c[i-j-1];
			}
		}
		return c[n];
	}
	
	public static void main(String[] args) {
		n096_Unique_Binary_Search_Trees obj = new n096_Unique_Binary_Search_Trees();
		System.out.println(obj.numTrees(3));
	}
}
