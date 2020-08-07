// https://www.youtube.com/watch?v=dnlB0lvz5LY&t=179s

class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) return false;
        
        HashMap<Character, String> map = new HashMap();
        for (int i = 0; i < pattern.length(); i++) {
            char currChar = pattern.charAt(i);
            if (map.containsKey(currChar)) {
                if (!map.get(currChar).equals(words[i])) {
                    return false;
                }              
            } else {
                if (map.containsValue(words[i])) return false;
                map.put(currChar, words[i]);
            } 
        }
        return true;
    }
}