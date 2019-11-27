class Solution {
    public boolean isSubsequence(String s, String t) {
        if (t.length() < s.length()) return false;
        int prev = 0;
        for(int i = 0; i < s.length();i++)
        {
            prev = t.indexOf(s.charAt(i), prev);
            if(prev == -1) return false;
            prev++;
        }
        return true;
    }
}