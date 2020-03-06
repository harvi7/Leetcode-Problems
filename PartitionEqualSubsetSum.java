// DFS Solution - https://www.youtube.com/watch?v=PSJhM7Nm2DI
// DP Solution - https://leetcode.com/problems/partition-equal-subset-sum/discuss/437043/Java-DP-Solution-with-explanation

class Solution {
    // DFS
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 2 != 0) return false;
        sum /= 2;
        return helper(nums, 0, sum);
    }
    
    private boolean helper(int[] nums, int index, int target) {
        if (target == 0) return true;
        if (index == nums.length || target < 0) return false;
        if (helper(nums, index + 1, target - nums[index])) return true;
        int j = index + 1;
        while (j < nums.length && nums[index] == nums[j]) j++;
        return helper(nums, j, target);
            
    }

    // DP Solution
    // public boolean canPartition(int[] nums) {
    //     int sum = 0;
    //     for (int n : nums) sum += n;
    //     if (sum % 2 != 0) return false;
    //     int half = sum / 2;
    //     boolean[] dp = new boolean[half + 1];
    //     dp[half] = true;
    //     for (int i = 0; i < nums.length; i++) {
    //         if (nums[i] > half) return false;
    //         if (dp[nums[i]]) return true;
    //         for int j = 1; j <= half; j++){
    //             if (dp[j] && j - nums[i] > 0) dp[j - nums[i]] = true;
    //         }
    //     }
    //     return false;            
    // }
}