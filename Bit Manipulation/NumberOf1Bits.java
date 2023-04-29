public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < Integer.SIZE; i++) {
            res += (n & 1);
            n = n >> 1;
        }
        return res;
    }
}