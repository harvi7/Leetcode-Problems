// https://leetcode.com/problems/length-of-last-word/solution/

class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        if (s == null || s.isEmpty())
            return length;
        s = s.trim();
        int n = s.length();
        for (int i = n - 1; i >=0 ; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
            ++length;
        }
        return length;
    }
}