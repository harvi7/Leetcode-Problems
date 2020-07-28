class Solution {
    public int bitwiseComplement(int N) {
        if (N == 0) return 1;
        int result = 0;
        int i = 0;
        while (N != 0) {
            if ((N & 1) == 0)
                result += 1 << i;
            i += 1;
            N >>= 1;
        }
        return result;
    }
}