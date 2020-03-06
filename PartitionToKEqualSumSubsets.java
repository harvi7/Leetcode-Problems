// https://www.youtube.com/watch?v=qpgqhp_9d1s

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        if (k <= 0 || k > nums.length || totalSum % k != 0) {
            return false;
        }
        return canPartition(0, nums, new boolean[nums.length], k, 0, totalSum / k);
    }
    
    private boolean canPartition(int start, int[] nums, boolean[] used, int k, int currentSum, int targetSum) {
        if (k == 1) {
            return true;
        }
        if (currentSum == targetSum) {
            return canPartition(0, nums, used, k - 1, 0, targetSum);
        }
        for (int i = start; i < nums.length; i++) {
            if (!used[i] && currentSum + nums[i] <= targetSum) {
                used[i] = true;
                if (canPartition(i + 1, nums, used, k, currentSum + nums[i], targetSum)) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }
}