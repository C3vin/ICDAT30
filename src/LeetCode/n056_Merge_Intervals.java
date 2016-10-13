package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class n056_Merge_Intervals {
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
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<Interval>();

		Collections.sort(intervals, new Comparator<Interval>(){     //??
			public int compare(Interval i1, Interval i2){
				if(i1.start!=i2.start)
					return i1.start-i2.start;
				else
					return i1.end-i2.end;
			}
		});
		Interval pre = intervals.get(0);
		for(int i=0; i<intervals.size(); i++) {			//need i=0 ?
			Interval curr = intervals.get(i);
			if(curr.start > pre.end) {
				res.add(pre);
				pre = curr;
			} else {
				System.out.println(pre + " : " + curr);
				Interval merge = new Interval(pre.start,Math.max(pre.end, curr.end));		//F: need Mach.max
				pre = merge;
			}
		}
		res.add(pre);
		return res;
	}
	public static void main(String[] args) {
		n056_Merge_Intervals obj = new n056_Merge_Intervals();
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(obj.new Interval(1, 3));
		intervals.add(obj.new Interval(2, 6));
		intervals.add(obj.new Interval(8, 10));
		intervals.add(obj.new Interval(15, 18));
		System.out.println(intervals);
		System.out.println(obj.merge(intervals));
	}
}
