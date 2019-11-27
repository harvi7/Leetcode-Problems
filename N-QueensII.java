class Solution {
    int solutions = 0;
    public int totalNQueens(int n) {
        solveNQueens(0, n, new ArrayList<Integer>());
        return solutions;
    }
    
    private void solveNQueens(int row, int n, List<Integer> colPlacements) {
        if (row == n) {
            solutions++;
            return;
        }
        for (int col = 0; col < n; col++) {
            colPlacements.add(col);
            if (isValid(colPlacements)) 
                solveNQueens(row + 1, n, colPlacements);
            colPlacements.remove(colPlacements.size() - 1);
        }
    }

    private static boolean isValid(List<Integer> colPlacements) {

        int rowWeAreValidatingOn = colPlacements.size() - 1;
            for (int ithQueenRow = 0; ithQueenRow < rowWeAreValidatingOn; ithQueenRow++) {
                int absoluteColumnDistance = Math.abs(colPlacements.get(ithQueenRow) - colPlacements.get(rowWeAreValidatingOn));
                int rowDistance = rowWeAreValidatingOn - ithQueenRow;
                if (absoluteColumnDistance == 0 || absoluteColumnDistance == rowDistance) {
                  return false;
            }
        }
        return true;
    }
    
}

