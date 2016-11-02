package LeetCode;

import java.util.HashMap;

public class n149_Max_Points_on_a_Line {
	static class Point {
		int x;
		int y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }
	}
	public int maxPoints(Point[] points) {
		if(points.length == 0) return 0;
		if(points.length == 1) return 1;
		
		int max = 1; //the final max val, at least one
		for(int i=0; i<points.length; i++) {
			HashMap<Float, Integer> map = new HashMap<Float, Integer>();
			int same=0;
			int localmax=1;  //the max val of current slope, at least one
			//int v = 1;
			for(int j=0; j<points.length; j++) {
				if(i == j) 			//same point
					continue;
				if(points[i].x == points[j].x && points[i].y == points[j].y) {
					same++;
					continue;
				}
				if(points[i].x - points[j].x == 0) {
					//v++;
					localmax++;
					continue;
				}
				
				float slope = (float)(points[i].y-points[j].y)/(points[i].x-points[j].x);
				
				if(map.containsKey(slope)) {
					map.put(slope, map.get(slope)+1);
				} else {
					map.put(slope, 2);
				}
			}
			for(int val : map.values()) {
				localmax = Math.max(localmax, val);
			}
			//localmax = Math.max(localmax, v);			
			localmax = localmax + same;
			
			max = Math.max(max, localmax);
		}
		return max;
	}
	
	public static void main(String[] args) {
		n149_Max_Points_on_a_Line obj = new n149_Max_Points_on_a_Line();
		Point[] p = new Point[]{new Point(0,1), new Point(0,0)};
		System.out.println(obj.maxPoints(p));
	}
}
