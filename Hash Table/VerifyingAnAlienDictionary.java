// https://leetcode.com/problems/verifying-an-alien-dictionary/discuss/812068/Java-Simple-Solution

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length <= 1) {
            return true;
        }
        Map<Character, Integer> map = getOrderMap(order);
        for (int i = 0; i < words.length - 1; i++) {
            if (!compareTwoWords(words[i], words[i + 1], map)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean compareTwoWords(String word1, String word2, Map<Character, Integer> map) {
        for (int i = 0; i < word1.length(); i++) {
            if (i >= word2.length()) {
                return false;
            }
            int c1 = map.get(word1.charAt(i));
            int c2 = map.get(word2.charAt(i));
            if (c1 < c2) {
                return true;
            } else if (c1 > c2) {
                return false;
            }
        }
        return true;
    }
    
    private Map<Character, Integer> getOrderMap(String order) {
        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = order.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            map.put(charArray[i], i);
        }
        return map;
    }
}