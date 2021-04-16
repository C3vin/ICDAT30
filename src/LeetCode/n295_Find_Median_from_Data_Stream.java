package LeetCode;

import java.util.PriorityQueue;

/*
The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 

Example 1:

Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0
 */
public class n295_Find_Median_from_Data_Stream {
	PriorityQueue<Integer> maxHeap;     //lower half，save smaller number
    PriorityQueue<Integer> minHeap;     //higher half, save bigger number
    
    /** initialize your data structure here. */
    public n295_Find_Median_from_Data_Stream() {
        maxHeap = new PriorityQueue<Integer>((a, b) ->{
            return b - a;
        });
        minHeap = new PriorityQueue<Integer>((a, b) -> {
            return a - b;
        });
    }
    
    // 1. 新来的元素先加到maxHeap，再把maxHeap里最大元素加到minHeap
    // 2. 如果maxHeap的size小于minHeap的size，把minHeap的最小的元素加到maxHeap
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());          // min heap中放入的是来自max heap中最大的元素
        
        if(maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    // always get first number from both heap
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}
