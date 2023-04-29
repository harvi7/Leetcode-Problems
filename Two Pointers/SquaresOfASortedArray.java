// https://leetcode.com/problems/squares-of-a-sorted-array/solution/

class Solution {
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            int square;
            if (Math.abs(A[left]) < Math.abs(A[right])) {
                square = A[right];
                right--;
            } else {
                square = A[left];
                left++;
            }
            result[i] = square * square;
        }
        return result;
    }
}