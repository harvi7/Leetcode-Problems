// https://www.youtube.com/watch?v=zzqAE1J2ieA

class Solution {
    public int smallestRangeI(int[] A, int K) {
        int minVal = A[0];
        int maxVal = A[0];
        for (int i = 0; i < A.length; i++) {
            minVal = Math.min(minVal, A[i]);
            maxVal = Math.max(maxVal, A[i]);
        }
        
        if (minVal + K >= maxVal - K)
            return 0;
        else return (maxVal - K) - (minVal + K);
    }
}