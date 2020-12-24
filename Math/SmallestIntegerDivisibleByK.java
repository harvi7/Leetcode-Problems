// https://www.youtube.com/watch?v=fV0eOYlYfrM&ab_channel=AlgorithmsMadeEasy

class Solution {
    public int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0) return -1;
        int prevRemainder = 0;
        for (int length_N = 1; length_N <= K; length_N++) {
            prevRemainder = (prevRemainder * 10 + 1) % K;
            if (prevRemainder == 0) {
                return length_N;
            }
        }
        return -1;
    }
}