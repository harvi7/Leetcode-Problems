// https://leetcode.com/problems/out-of-boundary-paths/solution/

class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        int M = 1000000000 + 7;
        int dp[][] = new int[m][n];
        dp[i][j] = 1;
        int count = 0;
        for (int moves = 1; moves <= N; moves++) {
          int[][] temp = new int[m][n];
          for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
              if (x == m - 1) 
                  count = (count + dp[x][y]) % M;
              if (y == n - 1) 
                  count = (count + dp[x][y]) % M;
              if (x == 0) 
                  count = (count + dp[x][y]) % M;
              if (y == 0) 
                  count = (count + dp[x][y]) % M;
              temp[x][y] = (
                  ((x > 0 ? dp[x - 1][y] : 0) + (x < m - 1 ? dp[x + 1][y] : 0)) % M +
                  ((y > 0 ? dp[x][y - 1] : 0) + (y < n - 1 ? dp[x][y + 1] : 0)) % M
              ) % M;
            }
          }
          dp = temp;
        }
        return count;
    }
}