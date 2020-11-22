// https://www.youtube.com/watch?v=2Uq7p7HE0TI

class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        int S = -1;
        Arrays.sort(A);
        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            if (A[lo] + A[hi] < K) {
                S = Math.max(S, A[lo] + A[hi]);
                ++lo;
            }
            else
                --hi;
        }
        return S;
        
        // int S = -1;
        // Arrays.sort(A);
        // for (int i = 0; i < A.length; ++i) {
        //     var idx = Arrays.binarySearch(A, i + 1, A.length, K - A[i] - 1);
        //     int j = (idx >= 0 ? idx : ~idx);
        //     if (j == A.length || A[j] > K - A[i] - 1)
        //         --j;
        //     if (j > i) {
        //         S = Math.max(S, A[i] + A[j]);
        //     }
        // }
        // return S;
    }
}