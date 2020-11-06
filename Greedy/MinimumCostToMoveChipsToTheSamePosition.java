// https://www.youtube.com/watch?v=BLYLGcYhcn8

class Solution {
    public int minCostToMoveChips(int[] position) {
        int even = 0, odd = 0;
        for (int i: position) {
            if (i % 2 == 1) ++odd;
            else ++even;
        }
        return Math.min(odd, even);
    }
}