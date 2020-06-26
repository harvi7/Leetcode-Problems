// https://www.youtube.com/watch?v=w6xk5Po-DX0
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75924/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems

class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1)
            return 0;
        if (len == 2 && prices[1] > prices[0])
            return prices[1] - prices[0];
        else if (len == 2 && prices[0] > prices[1])
            return 0;
        
        int[][] dp = new int[len][2];
        
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], dp[0][0] - prices[1]);
        
        for (int i = 2; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
}