// 
// https://www.youtube.com/watch?v=UflHuQj6MVA&ab_channel=TusharRoy-CodingMadeSimple

class Solution {
    public String longestPalindrome(String s) {
        
        // DP Approach
//         int length = s.length();
        
//         if (s == null || length < 2) {
//             return s;
//         }
        
//         boolean[][] isPalindrome = new boolean[length][length];
        
//         int left = 0;
//         int right = 0;
        
//         for (int j = 1; j < length; j++) {
//             for (int i = 0; i < j; i++) {
//                 boolean isInnerWordPalindrome = isPalindrome[i + 1][j - 1] || j - i <= 2;
//                 if (s.charAt(i) == s.charAt(j) && isInnerWordPalindrome) {
//                     isPalindrome[i][j] = true;
                    
//                     if (j - i > right - left) {
//                         left = i;
//                         right = j;
//                     }
//                 }
//             }
//         }
        
//         return s.substring(left, right + 1);    if (s == null || s.length() < 1) return "";
    
        
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}