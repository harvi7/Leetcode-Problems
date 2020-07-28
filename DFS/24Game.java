// https://www.youtube.com/watch?v=ET_HIyJTl1E
// https://leetcode.com/problems/24-game/solution/

class Solution {
    public boolean judgePoint24(int[] nums) {
        double[] A = new double[]{nums[0], nums[1], nums[2], nums[3]};
        return helper(A);
    }
    
    private boolean helper(double[] A) {
        if (A.length == 1) return Math.abs(A[0] - 24) < 1e-6;

        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                double[] d = new double[A.length - 1];

                for (int k = 0, index = 0; k < A.length; k++) {
                    if (k != i && k != j) {
                        d[index++] = A[k];
                    }
                }

                for (double num : compute(A[i], A[j])) {
                    d[d.length - 1] = num;
                    if (helper(d)) return true;
                }
            }
        }

        return false;
    }

    private double[] compute(double x, double y) {
        return new double[]{x + y, x - y, y - x, x * y, x / y, y / x};
    }
}