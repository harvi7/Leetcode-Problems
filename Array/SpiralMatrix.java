// https://www.youtube.com/watch?v=3joo9yAZVh8
// https://leetcode.com/problems/spiral-matrix/solution/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
//         List<Integer> res = new ArrayList();
//         if (matrix.length == 0) return res;
        
//         int rowBegin = 0;
//         int rowEnd = matrix.length - 1;
//         int columnBegin = 0;
//         int columnEnd = matrix[0].length - 1;
        
//         while (rowBegin <= rowEnd && columnBegin <= columnEnd) {
//             for (int i = columnBegin; i <= columnEnd; i++) {
//                 res.add(matrix[rowBegin][i]);
//             }
            
//             rowBegin++;
//             for (int i = rowBegin; i <= rowEnd; i++) {
//                 res.add(matrix[i][columnEnd]);
//             }
            
//             columnEnd--;
//             if (rowBegin <= rowEnd) {
//                 for (int i = columnEnd; i >= columnBegin; i--) {
//                     res.add(matrix[rowEnd][i]);
//                 }
//             }
            
//             rowEnd--;
//             if (columnBegin <= columnEnd) {
//                 for (int i = rowEnd; i >= rowBegin; i--) {
//                     res.add(matrix[i][columnBegin]);
//                 }
//             }
//             columnBegin++;
//         }
//         return res;
        List ans = new ArrayList();
        if (matrix.length == 0)
            return ans;
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) ans.add(matrix[r1][c]);
            for (int r = r1 + 1; r <= r2; r++) ans.add(matrix[r][c2]);
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) ans.add(matrix[r2][c]);
                for (int r = r2; r > r1; r--) ans.add(matrix[r][c1]);
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ans;
    }
}