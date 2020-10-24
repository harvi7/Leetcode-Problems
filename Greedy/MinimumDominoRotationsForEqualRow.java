// https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/solution/
// https://www.youtube.com/watch?v=9Q73ScVu2GI

class Solution {
    public int check(int x, int[] A, int[] B, int n) {
        int rotations_a = 0, rotations_b = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] != x && B[i] != x) return -1;
            else if (A[i] != x) rotations_a++; 
            else if (B[i] != x) rotations_b++;
        }
        return Math.min(rotations_a, rotations_b);
    }

    public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        int rotations = check(A[0], B, A, n);
        if (rotations != -1 || A[0] == B[0]) return rotations;
        else return check(B[0], B, A, n);
    }
}