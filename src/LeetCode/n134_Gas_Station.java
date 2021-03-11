package LeetCode;

/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). 
You begin the journey with an empty tank at one of the gas stations.
Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
Note:
If there exists a solution, it is guaranteed to be unique.
Both input arrays are non-empty and have the same length.
Each element in the input arrays is a non-negative integer.

Example 1:
Input: 
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]
Output: 3
Explanation:
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.

Example 2:
Input: 
gas  = [2,3,4]
cost = [3,4,3]
Output: -1
Explanation:
You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 0. Your tank = 4 - 3 + 2 = 3
Travel to station 1. Your tank = 3 - 3 + 3 = 3
You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
Therefore, you can't travel around the circuit once no matter where you start.
 */
public class n134_Gas_Station {
	//Greedy
//	Keep a starting candidate
//  Keep total gaining from the gas stations.
//	Keep a current gaining from starting candidate to the current station
//	If current gaining < 0 it means that our current candidate is not the one. Make the candidate the next element
//	Iterate the arrays and if totalGaining >= 0, return the candidate, otherwise return -1
	public int canCompleteCircuit(int[] gas, int[] cost) {	
		if(gas == null || cost == null || gas.length == 0 || cost.length == 0 || gas.length != cost.length) {
            return -1;
        }
        
        int currentGaining = 0;
        int totalGaining = 0;
        int index = 0;
        
        for(int i=0; i<gas.length; i++) {
            currentGaining = currentGaining + gas[i] - cost[i];
            totalGaining = totalGaining + gas[i] - cost[i];
            
            if(currentGaining < 0) {
                index = i+1; 
                currentGaining = 0;
            }
        }

        if(totalGaining < 0) {
            return -1;
        } 
        
        return index;
	}
	
	//cs
	//time: O(n) space: O(1)
	public int canCompleteCircuit2(int[] gas, int[] cost) {			//? need to listen
		int start = 0;
		int remain = 0;
		int debt = 0;
		
		for(int i=0; i<gas.length; i++) {
			remain = remain + gas[i] - cost[i];
			if(debt < 0) {
				debt = gas[i] - cost[i];
				start = i;
			} else {
				debt = debt + gas[i] - cost[i];
			}
		}
		return remain < 0 ? -1 : start;
	}
	
	public static void main(String[] args) {
		n134_Gas_Station obj = new n134_Gas_Station();
		System.out.println(obj.canCompleteCircuit(new int[] {1,2,3,4,5}, new int[] {3,4,5,1,2}));
		System.out.println(obj.canCompleteCircuit(new int[] {2,3,4}, new int[] {3,4,3}));
		
		System.out.println(obj.canCompleteCircuit2(new int[] {1,2,3,4,5}, new int[] {3,4,5,1,2}));
		System.out.println(obj.canCompleteCircuit2(new int[] {2,3,4}, new int[] {3,4,3}));
	}
}
