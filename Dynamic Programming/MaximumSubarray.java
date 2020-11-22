// https://www.youtube.com/watch?v=jnoVtCKECmQ

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length, maxSum = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i - 1] > 0) nums[i] += nums[i - 1];
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }
}

// class Solution {
//     public int maxSubArray(int[] nums) {
//         int n = nums.length, maxSum = nums[0];
//         int currSum = maxSum;
//         for (int i = 1; i < n; ++i) {
//             currSum = Math.max(nums[i] + currSum, nums[i]);
//             //if (nums[i - 1] > 0) nums[i] += nums[i - 1];
//             maxSum = Math.max(currSum, maxSum);
//         }
//         return maxSum;
//     }
// }
