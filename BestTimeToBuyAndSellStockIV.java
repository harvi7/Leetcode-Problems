// I think; there are n elements in prices. and every transaction requires two days of stocks out of n days. so if k>=n/2, every day out of n would take part in k transactions. so that snippet will return the sum of all consecutive( consecutive because that is the only way in which all n days would take part in k transactions since k>=n/2 ) positive profits.
// https://www.youtube.com/watch?v=oDhu5uGq_ic


class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1)
        return 0;

        //if k >= n/2, then you can make maximum number of transactions.
        if (k >= n / 2) {
            int maxPro = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i-1])
                    maxPro += prices[i] - prices[i - 1];
            }
            return maxPro;
        }

        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int localMax = dp[i - 1][0] - prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1],  prices[j] + localMax);
                localMax = Math.max(localMax, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[k][n-1];
    }
}