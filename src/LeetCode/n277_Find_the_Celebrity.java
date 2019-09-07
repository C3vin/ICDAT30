package LeetCode;

/*
Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. 
The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.
Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do 
is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the 
celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n). 
There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a celebrity in the party. 
If there is no celebrity, return -1.

Example 1:
Input: graph = [
  [1,1,0],
  [0,1,0],
  [1,1,1]
]
Output: 1
Explanation: There are three persons labeled with 0, 1 and 2. graph[i][j] = 1 means person i knows person j, 
otherwise graph[i][j] = 0 means person i does not know person j. The celebrity is the person labeled as 1 because 
both 0 and 2 know him but 1 does not know anybody.

Example 2:
Input: graph = [
  [1,0,1],
  [1,1,0],
  [0,1,1]
]
Output: -1
Explanation: There is no celebrity.
*/

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
	
	//cs
	//time:O(n) space:O(1)
	public int findCelebrity2(int n) {
		if(n < 2) {
			return -1;
		}
		int possible = 0;
		for(int i=1; i<n; i++) {
			if(knows2(possible, i)) {
				possible = i;
			}
		}
		for(int i=0; i<n; i++) {
			if(possible != i && (knows2(possible, i) || !knows2(i, possible))) {
				return -1;
			}
		}
		return possible;
	}
	
	public boolean knows2(int a, int b) {
		return true;
	}
}
