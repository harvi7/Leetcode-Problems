class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] charCounts = new int[26];
        for (int i = 0; i < text.length(); i++) {
            charCounts[text.charAt(i) - 'a']++;
        }
        int min = charCounts[1]; // b
        min = Math.min(min, charCounts[0]); // a
        min = Math.min(min, charCounts[11] / 2); // l
        min = Math.min(min, charCounts[14] / 2); // 0
        min = Math.min(min, charCounts[13]); // n
        return min;
    }
}