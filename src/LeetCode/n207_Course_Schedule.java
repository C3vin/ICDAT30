package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
There are a total of n courses you have to take, labeled from 0 to n-1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:
Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.

Example 2:
Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
 */
public class n207_Course_Schedule {
	//https://leetcode.flowerplayer.com/2019/06/13/leetcode-207-course-schedule%E8%A7%A3%E9%A2%98%E6%80%9D%E8%B7%AF%E5%88%86%E6%9E%90/
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<Integer> graph = new ArrayList<Integer>();
		//		for(int i=0; i<numCourses; i++) {
		//			graph[i] = new ArrayList<Integer>();
		//		}
		for(int i=0; i<prerequisites.length; i++) {
			graph.add(prerequisites[i][0]);
			graph.add(prerequisites[i][1]);
		}
		int[] visited = new int[numCourses];
		for(int i = 0; i < numCourses; i++) {
			if (!dfs(graph, i, visited)) {
				return false;
			}
		}

		return true;
	}
	private boolean dfs(List<Integer> graph, int currentCourse, int[] visited) {
	    if (visited[currentCourse] == 1) {
	        return false;
	    }
	    if (visited[currentCourse] == 2) {
	        return true;
	    }
	    visited[currentCourse] = 1;
	    for (int preCourse : graph[currentCourse]) {
	        if (!dfs(graph, preCourse, visited)) {
	            return false;
	        }
	    }
	    visited[currentCourse] = 2;
	    return true;
	}
	
	public static void main(String[] args) {
		n207_Course_Schedule obj = new n207_Course_Schedule();
		System.out.println(obj.canFinish(2, new int[][] {{1,0}}));
	}
}
