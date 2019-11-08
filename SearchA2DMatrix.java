class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        
        int rows = matrix.length;
        int columns = matrix[0].length;
        int left = 0, right = rows * columns - 1;
        
        while (left <= right) {
            int midpoint  = left + (right - left) / 2;
            int midElement = matrix[midpoint/columns][midpoint%columns];
            if (midElement == target) return true;
            else if (target < midElement) right = midpoint - 1;
            else left = midpoint + 1;
        }
        return false;
    }
}