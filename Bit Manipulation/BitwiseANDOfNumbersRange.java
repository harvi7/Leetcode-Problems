// https://www.youtube.com/watch?v=-qrpJykY2gE&ab_channel=TECHDOSE

class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            count += 1;
        }
        return m <<= count;
    }
}