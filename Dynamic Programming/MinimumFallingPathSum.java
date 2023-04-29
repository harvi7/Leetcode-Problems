// https://leetcode.com/problems/minimum-falling-path-sum/discuss/186666/C%2B%2BJava-4-lines-DP
// https://www.youtube.com/watch?v=Jg4u9S1n8Q8
// https://leetcode.com/problems/minimum-falling-path-sum/solution/

class Solution {
    public int minFallingPathSum(int[][] A) {
//        int N = A.length;
//         for (int r = N - 2; r >= 0; --r) {
//             for (int c = 0; c < N; ++c) {
//                 // best = min(A[r+1][c-1], A[r+1][c], A[r+1][c+1])
//                 int best = A[r + 1][c];
//                 if (c > 0)
//                     best = Math.min(best, A[r + 1][c - 1]);
//                 if (c + 1 < N)
//                     best = Math.min(best, A[r + 1][c + 1]);
//                 A[r][c] += best;
//             }
//         }

//         int ans = A[0][0];
//         for (int x: A[0])
//             ans = Math.min(ans, x);
//         return ans ;
        for (int i = 1; i < A.length; ++i)
        for (int j = 0; j < A.length; ++j)
            A[i][j] += Math.min(A[i - 1][j], Math.min(A[i - 1][Math.max(0, j - 1)], A[i - 1][Math.min(A.length - 1, j + 1)]));
        return Arrays.stream(A[A.length - 1]).min().getAsInt();
    }
}