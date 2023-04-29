// https://www.youtube.com/watch?v=MiqoA-yF-0M

class Solution {
    
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int[][] dp = new int[length2+1][length1+1];
        for(int i=1; i<=length1; i++) dp[0][i] = i;
        for(int j=1; j<=length2; j++) dp[j][0] = j;
        
        for(int i=1; i<= length2; i++){
            for(int j=1; j<= length1; j++){
                if(word2.charAt(i-1) == word1.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
            }
        }
        return dp[length2][length1];
    }
}