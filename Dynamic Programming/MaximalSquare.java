// https://www.youtube.com/watch?v=_Lf1looyJMU&t=2s
// https://leetcode.com/problems/maximal-square/discuss/496199/DP-O(MN)-space-O(MN)-time-Easy-to-understand.-Can-optimize-to-O(1)-space-easily.
// https://leetcode.com/problems/maximal-square/solution/

class Solution {
    public int maximalSquare(char[][] matrix) {
//         if(matrix == null || matrix.length == 0) return 0;
//         int[][] result = new int[matrix.length + 1][matrix[0].length + 1];
        
//         int max = 0;
//         for(int i = 1; i < result.length; i++) {
//             for(int j = 1; j < result[0].length; j++) {
//                 result[i][j] = matrix[i-1][j-1] == '0' ? 0 : (min(result[i - 1][j - 1], 
//                                                                            result[i][j - 1], 
//                                                                            result[i - 1][j]) + 1);
//                 max = Math.max(result[i][j], max);
//             }
//         }
//         return max * max;
        
        // Optimised approach
        
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[] dp = new int[cols + 1];
        int maxsqlen = 0, prev = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxsqlen * maxsqlen;
    }
    
    // private int min(int a, int b, int c) {
    //     return a > b ? Math.min(b, c) : Math.min(a, c);
    // }
}