// https://www.youtube.com/watch?v=i1u2ChnUvZM

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if (m == 0 || n == 0) return 0;
        if (n < m)
            return longestCommonSubsequence(text2, text1);
        int[] dp = new int[m + 1];
        for (int i = 1; i < n + 1; i++) {
            int prevBest = 0;
            for (int j = 1; j < m + 1; j++) {
                int temp = dp[j];
                dp[j] = (text1.charAt(j - 1) == text2.charAt(i - 1)) ? 1 + prevBest : Math.max(dp[j], dp[j - 1]);
                prevBest = temp;
            }
        }
        return dp[m];
    }
}