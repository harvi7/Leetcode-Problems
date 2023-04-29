// https://www.youtube.com/watch?v=73r3KWiEvyk
// https://leetcode.com/problems/house-robber/solution/
// https://www.youtube.com/watch?v=ZwDDLAeeBM0

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