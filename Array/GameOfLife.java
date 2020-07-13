// https://www.youtube.com/watch?v=sUqYZvfZ9UE

class Solution {
    // mark die -> live, -1
    // mark live -> die, 2
    // updat() -1 -> 1, 2 => 0
    final static int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int rows = board.length, cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 0){
                    int lives = count(board, i, j);
                    if (lives == 3) {
                        board[i][j] = -1;
                    }
                }
                if (board[i][j] == 1) {
                    int lives = count(board, i ,j);
                    if (lives < 2 || lives > 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }
        update(board);
    }
    
    private void update(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == -1)
                    board[i][j] = 1;
                if (board[i][j] == 2) 
                    board[i][j] = 0;
            }
        }
    }
    
    private int count(int[][] board, int row, int col) {
        int res = 0;
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            
            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length
               && (board[newRow][newCol] == 1 || board[newRow][newCol] == 2))
                res++;
        }
        return res;
    }
}