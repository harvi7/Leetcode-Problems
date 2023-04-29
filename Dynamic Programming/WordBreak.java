// https://www.youtube.com/watch?v=WepWFGxiwRs

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // boolean[] dp = new boolean[s.length()+1];
        // int maxLen = 0;
        // for (String word : wordDict) {
        //     maxLen = Math.max(maxLen, word.length());
        // }
        // dp[0] = true
        // for (int end = 1;end < s.length()+1;end++) {
        //     if(wordDict.contains(s.substring(0,end))) {
        //         dp[end] = true;
        //         continue;
        //     }
        //    //Here the starting value of i is optimized from 1 to end-maxLen>1?end-maxLen:1 
        //    //since the difference between i and end cannot be bigger than the maximum length of string in the dictionary.
        //    // If it is set to 1, it will waste a lot of time on computing meaningless i values.
        //     for(int i = end-maxLen>1?end-maxLen:1;i<end;i++){
        //         if(dp[i]==true&&wordDict.contains(s.substring(i,end))){
        //             dp[end] = true;
        //             break;
        //         }
        //     }
        // }
        // if(dp[s.length()]) return true;
        // else return false;
        boolean[] dp = new boolean[s.length() + 1];
        int maxLen = 0;
        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }
        dp[0] = true;
        for (int end = 1; end < s.length() + 1; end++) {
            for (int j = end - 1; j >= 0; j--) {
                if (end - j > maxLen) continue;
                if (dp[j] && wordDict.contains(s.substring(j, end))) {
                    dp[end] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
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
