// https://www.youtube.com/watch?v=54nJhM2AZv4&ab_channel=Pepcoding
// https://leetcode.com/problems/knight-probability-in-chessboard/solution/

class Solution {
    public static boolean isValid(int ni, int nj, int n) {
        if (ni >= 0 && nj >= 0 && ni < n && nj < n)
            return true;
        else 
            return false;
    }
    public double knightProbability(int N, int K, int r, int c) {
        double[][] dp = new double[N][N];
        int[] dr = new int[]{2, 2, 1, 1, -1, -1, -2, -2};
        int[] dc = new int[]{1, -1, 2, -2, 2, -2, 1, -1};

        dp[r][c] = 1;
        for (; K > 0; K--) {
            double[][] dp2 = new double[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < 8; k++) {
                        int cr = i + dr[k];
                        int cc = j + dc[k];
                        if (isValid(cr, cc, N))
                            dp2[cr][cc] += dp[i][j] / 8.0;
                    }
                }
            }
            dp = dp2;
        }
        double ans = 0.0;
        for (double[] row: dp) {
            for (double x: row) ans += x;
        }
        return ans;
    }
}