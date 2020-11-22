// https://www.youtube.com/watch?v=jLv-5coG-qQ&list=PL1w8k37X_6L8xh476yG6UNfXBCT1tq2vM&index=26

class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 1; i < m + 1; i++)
            for (int j = 1; j < n + 1; j++)
                dp[i][j] = A[i - 1] == B[j - 1] ? 1 + dp[i - 1][j - 1]
                    : Math.max(dp[i][j - 1], dp[i - 1][j]);
        
        return dp[m][n];
    }
}