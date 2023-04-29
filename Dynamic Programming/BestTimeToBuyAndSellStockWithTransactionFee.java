// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solution/
// https://www.youtube.com/watch?v=oVKaUeQsQJE

class Solution {
    public int maxProfit(int[] prices, int fee) {
        
        // if (prices == null || prices.length == 0) return 0;
        // int len = prices.length;
        // int[][] dp = new int[len][2];
        
        // dp[0][0] = 0;
        // dp[0][1] = -prices[0] - fee;
        
        // for (int i = 1; i < len; i++) {
        //     dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        //     dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        // }
        // return dp[len - 1][0];
        
        // 4 ms
        // if (prices == null || prices.length == 0) return 0;
        // int buy = -prices[0]-fee;
        // int sell = 0;
        // for (int i = 0; i < prices.length; i++){
        //     int prebuy = buy;
        //     buy = Math.max(buy,sell-fee-prices[i]);
        //     sell = Math.max(sell,prebuy + prices[i]);    
        // }
        // return sell;

        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}