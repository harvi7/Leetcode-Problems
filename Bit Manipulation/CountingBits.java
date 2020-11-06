// https://www.youtube.com/watch?v=iuqr5hHk2MI&list=PL1w8k37X_6L8xh476yG6UNfXBCT1tq2vM&index=29

class Solution {
    public int[] countBits(int num) {
        int[] bitCounts = new int[num + 1];
        for (int i = 1; i <= num; i++)
            bitCounts[i] = bitCounts[i >> 1] + i % 2;
        return bitCounts;
    }
}