// https://www.youtube.com/watch?v=LA1BnKiarEQ

class Solution {
    public int findComplement(int num) {
        int result = 0;
        int i = 0;
        while (num != 0) {
            if ((num & 1) == 0)
                result += 1 << i;
            i += 1;
            num >>= 1;
        }
        return result;
    }
}