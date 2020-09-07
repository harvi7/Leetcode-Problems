// https://www.youtube.com/watch?v=zfjBapE3Y6E

class Solution {
    private int shift_count(int[][] A, int[][] B){
        int n = A.length, count = 0;
        for(int x = 0; x < n; x++){
            for(int y = 0; y < n; y++){
                int currCount = 0;
                for(int i = y; i < n; i++){
                    for(int j = x; j < n; j++)
                        if(A[i][j] == 1 && B[i - y][j - x] == 1) currCount++;
                }
                count = Math.max(count, currCount);
            }
        }
        return count;
    }
    public int largestOverlap(int[][] A, int[][] B) {
        return Math.max(shift_count(A, B), shift_count(B, A));
    }
}