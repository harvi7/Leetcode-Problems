// https://www.youtube.com/watch?v=spiwTAuz1_4&list=PLK0ZC7fyo01Jr4CwyEGPB_YYVYqoJS7LR&index=43
// https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/discuss/252254/JavaC%2B%2BPython-Sort

class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        for (int i = 0; K > 0 && i < A.length && A[i] < 0; ++i, K--)
            A[i] = -A[i];
        int res = 0, min = Integer.MAX_VALUE;
        for (int a : A) {
            res += a;
            min = Math.min(min, a);
        }
        return res - (K % 2) * min * 2;
    }
}