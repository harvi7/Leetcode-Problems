// https://leetcode.com/problems/house-robber/solution/

class Solution {
    public int rob(int[] nums) {
        int prevMax = 0, currMax = 0;
        for (int x : nums) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }
}