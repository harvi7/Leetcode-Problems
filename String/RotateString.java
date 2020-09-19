// https://www.youtube.com/watch?v=GTJr8OvyEVQ&t=4s
// https://leetcode.com/problems/rotate-string/solution/

class Solution {
    public boolean rotateString(String A, String B) {
        int N = A.length();
        if (N != B.length()) return false;
        if (N == 0) return true;
        
        char[] text = (A.concat(A)).toCharArray(); 
        char[] pattern = B.toCharArray();
        
        int lps[] = computeTemporaryArray(pattern);
        int i = 0, j = 0;
        while (i < text.length && j < pattern.length) {
            if (text[i] == pattern[j]) {
                i++;
                j++;
            } else {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
        if (j == pattern.length)
            return true;
        return false;
    }
    
    private int[] computeTemporaryArray(char pattern[]) {
        int [] lps = new int[pattern.length];
        int index = 0;
        int i = 1;
        while (i < pattern.length) {
            if (pattern[i] == pattern[index]) {
                lps[i] = index + 1;
                index++;
                i++;
            } else {
                if (index != 0)
                    index = lps[index - 1];
                else {
                    lps[i] =0;
                    i++;
                }
            }
        }
        return lps;
    }
}