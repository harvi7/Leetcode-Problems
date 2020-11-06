// https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/discuss/754726/JavaC%2B%2BPython-1-Lines
// https://www.youtube.com/watch?v=TkT-6WsmqY0

class Solution {
    public int countOdds(int low, int high) {
        return (high + 1) / 2 - low / 2;
    }
}