// https://www.youtube.com/watch?v=0qep3f9cqVs&list=PLK0ZC7fyo01Jr4CwyEGPB_YYVYqoJS7LR&index=49&t=0s

class Solution {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[] directions = new int[]{0, 1, 0, -1, 0};
        int[][] result = new int[R * C][2];
        int i = 0;
        result[i++] = new int[]{r0, c0};
        int len = 0;
        int d = 0;
        while (i < R * C) {
            if (d == 0 || d == 2) {
                //plus one when moving east or west
                len++;
            }
            for (int k = 0; k < len; k++) {
                r0 += directions[d];
                c0 += directions[d + 1];
                if (r0 >= 0 && r0 < R && c0 >= 0 && c0 < C) {
                    result[i++] = new int[]{r0, c0};
                }
            }
            d = (d + 1) % 4;
        }
        return result;
    }
}