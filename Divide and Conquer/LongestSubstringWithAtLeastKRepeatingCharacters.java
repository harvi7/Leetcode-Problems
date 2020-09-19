// https://www.youtube.com/watch?v=bHZkCAcj3dc

class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        if (n == 0 || n < k) return 0;
        if (k <= 1) return n;

        Map<Character, Integer> counts = new HashMap();
        for(char c: s.toCharArray()) 
            counts.put(c, counts.getOrDefault(c, 0) + 1);

        int l = 0;
        while (l < n && counts.get(s.charAt(l)) >= k) l++;
        if (l >= n-1) return l;

        int ls1 = longestSubstring(s.substring(0, l), k);
        while(l < n && counts.get(s.charAt(l)) < k) l++;
        int ls2 = (l < n) ? longestSubstring(s.substring(l), k) : 0;
        return Math.max(ls1, ls2);
    }
}