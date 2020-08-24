// https://leetcode.com/problems/01-matrix/solution/
// https://leetcode.com/problems/01-matrix/discuss/801697/5ms-DP-java

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0)
            return matrix;
        int cols = matrix[0].length;
        
        for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				if (matrix[i][j] != 0)
					matrix[i][j] = Integer.MAX_VALUE;

		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				if (matrix[i][j] != 0) {
					if (i > 0 && matrix[i - 1][j] != Integer.MAX_VALUE)
						matrix[i][j] = Math.min(matrix[i][j], matrix[i - 1][j] + 1);
					if (j > 0 && matrix[i][j - 1] != Integer.MAX_VALUE)
						matrix[i][j] = Math.min(matrix[i][j], matrix[i][j - 1] + 1);
				}


		for (int i = rows - 1; i >= 0; i--) 
			for (int j = cols - 1; j >= 0; j--)
				if (matrix[i][j] != 0) {
					if (i < matrix.length - 1 && matrix[i + 1][j] != Integer.MAX_VALUE)
						matrix[i][j] = Math.min(matrix[i][j], matrix[i + 1][j] + 1);
					if (j < matrix[0].length - 1 && matrix[i][j + 1] != Integer.MAX_VALUE)
						matrix[i][j] = Math.min(matrix[i][j], matrix[i][j + 1] + 1);
				}
        
		return matrix;
    }
}