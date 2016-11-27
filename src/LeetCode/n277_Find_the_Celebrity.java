package LeetCode;

/* The knows API is defined in the parent class Relation. 
boolean knows(int a, int b); */  
public class n277_Find_the_Celebrity {
	public int findCelebrity(int n) {
		int[] pku = new int[n];		//people know you

		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i==j)
					continue;
				if(pku[j] >= 0) {
					if(knows(i,j)) {
						pku[i]=-1;
						pku[j]++;
					} else
						pku[j]=-1;

				}
			}
		}

		for(int i=0; i<n; i++) {
			if(pku[i] == n-1) {
				for(int j=0; j<n; j++) {
					if(i==j)
						continue;
					if(knows(i,j)) {
						return -1;			//F: return -1
					}
				}
				return i;		//F: need to in pku[i], and out of for loop
			}
		}
		return -1;
	}

	private boolean knows(int i, int j) {
		// TODO Auto-generated method stub
		return false;
	}
}
