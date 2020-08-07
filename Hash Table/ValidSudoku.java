// https://www.youtube.com/watch?v=Pl7mMcBm2b8

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char currentVal = board[i][j];
                if (currentVal != '.')
                    if (!seen.add(currentVal + " in row " + i) ||
                        !seen.add(currentVal + " in column " + j) ||
                        !seen.add(currentVal + " in block " + i/3 + "-" + j/3))
                        return false;
            }
        }
        return true;
    }
}