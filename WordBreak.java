// https://www.youtube.com/watch?v=WepWFGxiwRs

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int dp[][] = new int[s.length()][s.length()];
        
        for(int i=0; i < dp.length; i++){
            for(int j=0; j < dp[i].length ; j++){
                dp[i][j] = -1;
            }
        }
        
        for(int l = 1; l <= s.length(); l++){
            for(int i=0; i < s.length() - l + 1 ; i++){
                int aj = i + l -1;
                String str = s.substring(i,j+1);
                //if string between i to j is in dictionary T[i][j] is true
                if(wordDict.contains(str)){
                    dp[i][j] = i;
                    continue;
                }
                //find a k between i+1 to j such that T[i][k-1] && T[k][j] are both true 
                for(int k=i+1; k <= j; k++){
                    if(dp[i][k-1] != -1 && dp[k][j] != -1){
                        dp[i][j] = k;
                        break;
                    }
                }
            }
        }
        
        return dp[0][s.length()-1] != -1;
    }
}


// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
        
//         boolean[] f = new boolean[s.length() + 1];
        
//         f[0] = true;
        
        
//         /* First DP
//         for(int i = 1; i <= s.length(); i++){
//             for(String str: dict){
//                 if(str.length() <= i){
//                     if(f[i - str.length()]){
//                         if(s.substring(i-str.length(), i).equals(str)){
//                             f[i] = true;
//                             break;
//                         }
//                     }
//                 }
//             }
//         }*/
        
//         //Second DP
//         for(int i=1; i <= s.length(); i++){
//             for(int j=0; j < i; j++){
//                 if(f[j] && wordDict.contains(s.substring(j, i))){
//                     f[i] = true;
//                     break;
//                 }
//             }
//         }
        
//         return f[s.length()];
//     }
// }
