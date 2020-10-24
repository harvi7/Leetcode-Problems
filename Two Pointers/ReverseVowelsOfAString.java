// https://www.youtube.com/watch?v=1NXs_idViuQ

class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;
        char[] chars = s.toCharArray();
        int start = 0, end = s.length() - 1;
        while(start < end){
            while (start < end && !isVowel(chars[start])) start++;
            while (start < end && !isVowel(chars[end])) end--;
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return new String(chars);
    }
    
    public boolean isVowel(char c) {
        return c == 'a' || c == 'A' ||
                c == 'e' || c == 'E' ||
                 c == 'i' || c == 'I' ||
                  c == 'o' || c == 'O' ||
                    c == 'u' || c == 'U';
    }
}