// https://www.youtube.com/watch?v=Y3sZ2bsresI

class Solution {
    public int longestArithSeqLength(int[] A) {
        int length = A.length;
        HashMap<Integer, Integer>[] dp = new HashMap[length];
        int maxValue = 1;
        
        for (int i = 0; i < length; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int difference = A[i] - A[j];
                dp[i].put(difference, dp[j].getOrDefault(difference, 0) + 1);
                maxValue = Math.max(maxValue, dp[i].get(difference));
            }
        }
        return (maxValue + 1);
    }
}