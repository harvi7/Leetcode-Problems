// https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
// https://www.youtube.com/watch?v=KqXKT-QlCwY

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if (n * k == 0) return 0;

        int left = 0;
        int right = 0;
        LinkedHashMap<Character, Integer> hashmap = new LinkedHashMap<Character, Integer>(k + 1);

        int max_len = 1;

        while (right < n) {
            Character c = s.charAt(right);
            if (hashmap.containsKey(c))
                hashmap.remove(c);
            hashmap.put(c, right++);

            if (hashmap.size() == k + 1) {
                Map.Entry<Character, Integer> leftmost = hashmap.entrySet().iterator().next();
                hashmap.remove(leftmost.getKey());
                left = leftmost.getValue() + 1;
            }

            max_len = Math.max(max_len, right - left);
        }
        return max_len;
    }
}