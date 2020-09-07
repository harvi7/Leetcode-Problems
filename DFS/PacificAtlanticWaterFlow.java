// https://www.youtube.com/watch?v=DvQf2swmei8

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) return res;
        int n = matrix[0].length;
        
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        // the top and bottom
        for (int col = 0; col < n; col++) {
            dfs(matrix, 0, col, pacific, matrix[0][col]);
            dfs(matrix, m - 1, col, atlantic, matrix[m - 1][col]);
        }
        
        // the left and right
        for (int row = 0; row < m; row++) {
            dfs(matrix, row, 0, pacific, matrix[row][0]);
            dfs(matrix, row, n - 1, atlantic, matrix[row][n - 1]);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List cur = new ArrayList();
                    cur.add(i);
                    cur.add(j);
                    res.add(cur);
                }
            }
        }
        
        return res;
    }
    
    private void dfs(int[][] matrix, int r, int c, boolean[][] ocean, int preHeight) {
        if (r > matrix.length - 1 || r < 0 || 
           c > matrix[0].length - 1 || c < 0 || 
           matrix[r][c] < preHeight || ocean[r][c]) return;
        
        ocean[r][c] = true;
        dfs(matrix, r, c + 1, ocean, matrix[r][c]);
        dfs(matrix, r, c - 1, ocean, matrix[r][c]);
        dfs(matrix, r - 1, c, ocean, matrix[r][c]);
        dfs(matrix, r + 1, c, ocean, matrix[r][c]);
    }
}