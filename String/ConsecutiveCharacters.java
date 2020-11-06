// https://leetcode.com/problems/consecutive-characters/solution/

class Solution {
    public int maxPower(String s) {
        if (s.length() == 1) return 1;
        int count = 0, maxCount = 0;
        char previous = ' ';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == previous) {
                count++;
            } else {
                count = 1;
                previous = c;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}