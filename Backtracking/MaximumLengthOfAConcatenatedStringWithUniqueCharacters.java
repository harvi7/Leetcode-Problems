// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/discuss/546637/Java-simple-DFS
// https://www.youtube.com/watch?v=pD3cHFNyW2I

class Solution {
    int res = 0;
    public int maxLength(List<String> arr) {
        dfs(arr, 0, "");
        return res;
    }
    
    private void dfs(List<String> arr, int idx, String s) {
        if (unique(s)) res = Math.max(res, s.length());
        else return;
        for (int i = idx; i < arr.size(); i++)
            if (unique(arr.get(i)))
                dfs(arr, i + 1, s + arr.get(i));
    }
    
    private boolean unique(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray())
            if (++count[c - 'a'] > 1) 
                return false;
        return true;
    }
}