// https://leetcode.com/problems/moving-average-from-data-stream/solution/

class MovingAverage {
    int size, head = 0, windowSum = 0, count = 0;
    int[] queue;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        queue = new int[size];
    }
    
    public double next(int val) {
        ++count;
        int tail = (head + 1) % size;
        windowSum = windowSum - queue[tail] + val;
        head = (head + 1) % size;
        queue[head] = val;
        return windowSum * 1.0 / Math.min(size, count);
    }
}