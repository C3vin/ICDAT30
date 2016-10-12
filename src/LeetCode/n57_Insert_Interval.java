package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class n57_Insert_Interval {
	public class Interval {
		int start;
		int end;
		Interval() { 
			start = 0; 
			end = 0; 
		}
		Interval(int s, int e) { 
			start = s; 
			end = e; 
		}
		public String toString() {
			return "[" + start + ", " + end + "]";
		}
	}
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> res = new ArrayList<Interval>();
		
		for(Interval inter : intervals) {
			if(inter.end < newInterval.start)
				res.add(inter);
			else if(inter.start > newInterval.end) {
				res.add(newInterval);
				newInterval = inter;	//?
			} else {
				int nStart = Math.min(inter.start, newInterval.start);
				int nEnd = Math.max(inter.end, newInterval.end);
				newInterval = new Interval(nStart, nEnd);
			}
		}
		res.add(newInterval);
		return res;
	}
	
	public static void main(String[] args) {
		n57_Insert_Interval obj = new n57_Insert_Interval();
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(obj.new Interval(1, 2));
		intervals.add(obj.new Interval(3, 5));
		intervals.add(obj.new Interval(6, 7));
		intervals.add(obj.new Interval(8, 10));
		intervals.add(obj.new Interval(12, 16));
		Interval newInterval = obj.new Interval(4, 9);
		
		/*for(Interval ii: obj.insert(intervals, obj.new Interval(4, 9))) {
			System.ou
		} */
		System.out.println(obj.insert(intervals, newInterval));
	}
}
