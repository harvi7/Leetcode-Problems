// https://leetcode.com/problems/stone-game/solution/

class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int [][]dp = new int[n + 1][n + 1];
 
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < n; j++) 
                dp[i][j] = -1;
        
        return solve(piles, dp, 0, n - 1) > 0;
    }
    
    public int solve(int []piles, int [][]dp, int i, int j) {
        if (i > j) return 0;
        
        if (dp[i][j] != -1) return dp[i][j];
        
        dp[i][j] = Math.max(piles[i] - solve(piles, dp, i + 1, j), piles[j] - solve(piles, dp, i, j - 1));
        return dp[i][j];
    }
}