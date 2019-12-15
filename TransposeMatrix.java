class Solution {
    public int[][] transpose(int[][] A) {
        int rows = A.length, columns = A[0].length;
        
        int[][] res = new int[columns][rows];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++) 
               res[j][i]  = A[i][j];

        return res;
    }
}