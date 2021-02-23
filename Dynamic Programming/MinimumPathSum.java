// https://leetcode.com/problems/minimum-path-sum/discuss/352726/Java-DP-inplace-with-O(1)-Space-complexity
// 

class Solution {
    public int minPathSum(int[][] grid) {
//         if (grid == null || grid.length == 0) return 0;
//         int[][] dp = new int[grid.length][grid[0].length];
        
//         for (int i = 0; i < dp.length; i++) {
//             for (int j = 0; j < dp[i].length; j++) {
//                 dp[i][j] += grid[i][j];
//                 if (i > 0 && j > 0) dp[i][j] += Math.min(dp[i -1][j], dp[i][j - 1]);
//                 else if (i > 0) {
//                     dp[i][j] += dp[i - 1][j];
//                 } else if (j > 0) {
//                     dp[i][j] += dp[i][j - 1]; 
//                 }
//             } 
//         }
        
//         return dp[dp.length - 1][dp[0].length - 1];
        int m = grid.length, n = grid[0].length;
        if (grid == null || m == 0 || grid[0] == null || n == 0) return Integer.MIN_VALUE;
        for (int i = 1; i < m; i++) {
            grid[i][0] = grid[i][0] + grid[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            grid[0][j] = grid[0][j] + grid[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++){
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }
}