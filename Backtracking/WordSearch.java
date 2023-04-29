class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(board, word, 0, i , j))
                    return true;
            }
        }
        return false;
    }
    
    private boolean search(char[][] board, String word, int index, int i, int j) {
        if (index == word.length()) return true;
        int m = board.length, n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || word.charAt(index) != board[i][j]) return false;
        char c = board[i][j];
        board[i][j] = '#';
        boolean res = search(board, word, index + 1, i - 1, j) ||
                      search(board, word, index + 1, i + 1, j) ||
                      search(board, word, index + 1, i, j - 1) ||
                      search(board, word, index + 1, i, j + 1);
        board[i][j] = c;
        return res;
    }
}