// https://www.youtube.com/watch?v=1CxyVdA_654
// https://www.youtube.com/watch?v=EIm2n8iPA4I
//https://leetcode.com/problems/find-median-from-data-stream/discuss/658026/Two-Heap-Solution

class MedianFinder {
    PriorityQueue<Integer> minQ; 
    PriorityQueue<Integer> maxQ; 
    /** initialize your data structure here. */
    public MedianFinder() {
        minQ = new PriorityQueue<>((a, b) -> b - a);
		  maxQ = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
      if (isEmpty() || minQ.size() <= maxQ.size()) minQ.add(num);
      else maxQ.add(num);
      if (maxQ.size() == 0 || minQ.size() == 0) return;
          if (minQ.peek() > maxQ.peek()) {
        int temp = minQ.poll();
        minQ.add(maxQ.poll());
        maxQ.add(temp);
      }
    }
    
    public double findMedian() {
        if (minQ.size() > maxQ.size()) return minQ.peek();
      else if (minQ.size() < maxQ.size()) return maxQ.peek();
      else return (double) (minQ.peek() + maxQ.peek()) / 2;
    }
    
    public boolean isEmpty() {
		  return minQ.isEmpty() && maxQ.isEmpty();
	  }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

 