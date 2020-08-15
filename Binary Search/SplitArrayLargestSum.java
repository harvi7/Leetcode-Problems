// youtube.com/watch?v=8_FivWxrSK0

class Solution {
    public int splitArray(int[] nums, int m) {
        int max = 0;
        int sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        int lo = max;
        int hi = sum;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int numOfSubarrays = split(nums, mid);
            if (numOfSubarrays > m) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }
    
    private int split(int[] nums, int validMaxSum) {
        int sum = 0;
        int count = 1;
        for (int num : nums) {
            if (sum + num > validMaxSum) {
                sum = num;
                count++;
            } else {
                sum += num;
            }
        }

        return count;
    }
    
//     // DP
//     public int splitArray(int[] nums, int m) {
//         int n = nums.length;
//         int[] preSum = new int[n + 1];
//         for (int i = 1; i <= n; i++) {
//             preSum[i] = preSum[i - 1] + nums[i - 1];
//         }

//         int[][] dp = new int[n + 1][m + 1];
//         for (int i = 0; i <= n; i++) {
//             Arrays.fill(dp[i], Integer.MAX_VALUE);
//         }

//         dp[0][0] = 0;

//         for (int i = 1; i <= n; i++) {
//             for (int j = 1; j <= m; j++) {
//                 for (int k = 0; k < i; k++) {
//                     dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], preSum[i] - preSum[k]));
//                 }
//             }
//         }

//         return dp[n][m];
//    }
}