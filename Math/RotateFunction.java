// https://leetcode.com/problems/rotate-function/discuss/87853/Java-O(n)-solution-with-explanation

class Solution {
    public int maxRotateFunction(int[] A) {
        int allSum = 0, len = A.length, F = 0;
        for (int i = 0; i < len; i++) {
            F += i * A[i];
            allSum += A[i];
        }
        int max = F;
        for (int i = len - 1; i >= 1; i--) {
            F = F + allSum - len * A[i];
            max = Math.max(F, max);
        }
        return max;   
    }
}