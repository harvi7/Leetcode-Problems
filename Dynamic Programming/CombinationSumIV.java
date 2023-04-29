// https://www.youtube.com/watch?v=GWqe_xfqxCA
// https://leetcode.com/problems/combination-sum-iv/solution/

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int combSum = 1; combSum < target + 1; ++combSum) {
            for (int num : nums) {
                if (combSum - num >= 0)
                    dp[combSum] += dp[combSum - num];
            }
        }
        return dp[target];
    }
}