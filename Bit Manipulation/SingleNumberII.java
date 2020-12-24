// https://www.youtube.com/watch?v=cOFAmaMBVps
// https://leetcode.com/problems/single-number-ii/solution/

class Solution {
    public int singleNumber(int[] nums) {
        int seenOnce = 0, seenTwice = 0;

        for (int num : nums) {
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }

        return seenOnce;
    }
}