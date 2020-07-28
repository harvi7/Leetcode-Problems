// https://www.youtube.com/watch?v=zhU7yshJvb0

class Solution {
    public String removeDuplicateLetters(String s) {
        char[] chs = s.toCharArray();
        int[] count = new int[26];
        for (char c : chs) {
            count[c - 'a']++;
        }

        boolean[] used = new boolean[26];
        StringBuilder sb = new StringBuilder();
        for (char c : chs) {
            count[c - 'a']--;

            if (used[c - 'a']) continue;
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c
                && count[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                used[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }

            sb.append((char) c);
            used[c - 'a'] = true;
        }

        return sb.toString();
    }
}