// https://leetcode.com/problems/get-maximum-in-generated-array/solution/

class Solution {
    public int getMaximumGenerated(int n) {
        if (n == 0) return 0;
        int[] nums = new int[n + 1];
        int maximumValue = 1;
        nums[1] = 1;
        for (int i = 1; i <= n / 2; i++) {
            nums[i * 2] = nums[i];
            if (i * 2 + 1 <= n) {
                nums[i * 2 + 1] = nums[i] + nums[i + 1];
                maximumValue = Math.max(maximumValue, nums[i * 2 + 1]);
            }
        }
        return maximumValue;
    }
}