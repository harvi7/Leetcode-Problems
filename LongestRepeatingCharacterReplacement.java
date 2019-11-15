class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] charCount = new int[26];
        
        int windowStart = 0;
        int maxLength = 0;
        int maxCount = 0;
        
        for (int windowEnd = 0; windowEnd < len; windowEnd++) {
            charCount[s.charAt(windowEnd) - 'A']++;
            int currentCharCount = charCount[s.charAt(windowEnd) - 'A'];
            maxCount = Math.max(maxCount, currentCharCount);
            
            while (windowEnd - windowStart - maxCount + 1 > k) {
                charCount[s.charAt(windowStart) - 'A']--;
                windowStart++;
            }
            
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}