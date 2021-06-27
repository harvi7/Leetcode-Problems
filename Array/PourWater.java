// https://leetcode.com/problems/pour-water/solution/

class Solution {
    public int[] pourWater(int[] heights, int V, int K) {
        while (V-- > 0) droplet: {
            for (int d = -1; d <= 1; d += 2) {
                int i = K, best = K;
                while (0 <= i + d && i + d < heights.length && heights[i + d] <= heights[i]) {
                    if (heights[i + d] < heights[i]) best = i + d;
                    i += d;
                }
                if (heights[best] < heights[K]) {
                    heights[best]++;
                    break droplet;
                }
            }
            heights[K]++;
        }
        return heights;
    }
}