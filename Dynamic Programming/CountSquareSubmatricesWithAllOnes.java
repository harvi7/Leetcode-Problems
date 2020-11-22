// https://www.youtube.com/watch?v=9k3zx_Q45dg&list=PL1w8k37X_6L8xh476yG6UNfXBCT1tq2vM&index=22

class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[] counts = new int[m];
        int topleft = 0, result = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    int top = (i == 0) ? 0 : counts[j];
                    int left = (j == 0) ? 0 : counts[j - 1];
                    counts[j] = 1 + Math.min(Math.min(top, left), topleft);
                    result += counts[j];
                    
                    topleft = (j == m - 1) ? 0 : top;
                } else
                    counts[j] = 0;
            }
        }
        return result;
    }
}