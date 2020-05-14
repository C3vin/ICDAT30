package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/*
An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the 
starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the 
color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.
Example 1:
Input: 
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: 
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.
Note:
The length of image and image[0] will be in the range [1, 50].
The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
 */
public class n733_Flood_Fill {
	//BFS
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		//int[][] res = new int[image.length][image[0].length]; 
		int[][] directions = new int[][] {{-1,0},{0,-1},{0,1},{1,0}};
		int oldColor = image[sr][sc];
		if(oldColor == newColor) {					//if starting pixel color is same as newColor, we don't need to change anything 
			return image;
		}
		
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {sr, sc});
		
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			for(int i=0; i<levelSize; i++) {
				int[] cur = queue.poll();
				image[cur[0]][cur[1]] = newColor;
				
				for(int[] dir : directions) {
					int nx = cur[0] + dir[0];
					int ny = cur[1] + dir[1];
					if(nx < 0 || ny < 0 || nx >= image.length || ny >= image[0].length || image[nx][ny] != oldColor) {
						continue;
					}
					queue.offer(new int[] {nx, ny});
				}
			}
		}
		
		return image;
	}
	
	//DFS
	//LC200
	public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
		int oldColor = image[sr][sc];
		if(oldColor == newColor) {
			return image;
		}
		
		helper(image, sr, sc, newColor, oldColor);
		
		return image;
	}
	private void helper(int[][] image, int sr, int sc, int newColor, int oldColor) {
		if(sr < 0 || sc < 0 || sr >= image.length || sr >= image[0].length || image[sr][sc] != oldColor) {
			return;
		}
		image[sr][sc] = newColor;
		
		helper(image, sr-1, sc, newColor, oldColor);
		helper(image, sr+1, sc, newColor, oldColor);
		helper(image, sr, sc-1, newColor, oldColor);
		helper(image, sc, sc+1, newColor, oldColor);
	} 
	
	public static void main(String[] args) {
		n733_Flood_Fill obj = new n733_Flood_Fill();
		System.out.println(obj.floodFill(new int[][] {{1,1,1},{1,1,0},{1,0,1}}, 1, 1, 2));
		System.out.println(obj.floodFill(new int[][] {{0,0,0},{0,1,1}}, 1, 1, 1));
		
		System.out.println(obj.floodFill2(new int[][] {{1,1,1},{1,1,0},{1,0,1}}, 1, 1, 2));
		System.out.println(obj.floodFill2(new int[][] {{0,0,0},{0,1,1}}, 1, 1, 1));
	}
}
