// https://www.youtube.com/watch?v=u9m-hnlcydk

class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int[] counts = new int[K];
        int sum = 0;
        for (int x: A) {
            sum += (x % K + K) % K;
            counts[sum % K]++;
        }

        int result = counts[0];
        for (int c: counts)
            result += (c * (c - 1)) / 2;
        return result;
    }
}