package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Example 1:

Input: 2, [[1,0]] 
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
             course 0. So the correct course order is [0,1] .
Example 2:

Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
 */
public class n210_Course_Schedule_II {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] res = new int[numCourses];
		HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
		
		for(int[] prerequisite : prerequisites) {
			if(graph.containsKey(prerequisite[1])) {					//prerequisite[1] not prerequisite only
				graph.get(prerequisite[1]).add(prerequisite[0]);		//not need put again just need add it
			} else {
				ArrayList<Integer> x = new ArrayList<Integer>();
				x.add(prerequisite[0]);
				graph.put(prerequisite[1], x);
			}
		}
		
		//0: unvisited; 1: visiting 2: visited
		int[] visited = new int[numCourses];
		List<Integer> tmpRes = new ArrayList<Integer>();
		for(int i=0; i<numCourses; i++) {
			if(!dfs(graph, i, visited, tmpRes)) {
				return new int[0];
			}
		}
		
		for(int i=0; i<numCourses; i++) {
			res[i] = tmpRes.get(i);
		}
		
		return res;
	}
	//LC207 template
	private boolean dfs(HashMap<Integer, ArrayList<Integer>> graph, int currentCourse, int[] visited, List<Integer> tmpRes) {
	    if (visited[currentCourse] == 1) {
	        return false;
	    }
	    if (visited[currentCourse] == 2) {
	        return true;
	    }
		
		visited[currentCourse] = 1;				//must setup
		
		if(graph.containsKey(currentCourse)) {
			for(int preCourse: graph.get(currentCourse)) {
				if(!dfs(graph, preCourse, visited, tmpRes)) {
					return false;
				}
			}
		}
		
		visited[currentCourse] = 2;
		tmpRes.add(0, currentCourse);			//need to add in the front !!!
		
		return true;
	}
	
	public static void main(String[] args) {
		n210_Course_Schedule_II obj = new n210_Course_Schedule_II();
		System.out.println(obj.findOrder(4, new int[][] {{1,0}, {2,0}, {3,1}, {3,2}}));
	}
}
