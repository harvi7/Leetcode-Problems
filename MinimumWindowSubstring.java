// https://www.youtube.com/watch?v=eS6PZLjoaq8
// https://leetcode.com/problems/minimum-window-substring/discuss/26810/Java-solution.-using-two-pointers-%2B-HashMap

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() < t.length() || s.length() == 0) {
            return "";
        }
        
        Map<Character, Integer> requiredCharacters = new HashMap<Character,Integer>();
        for (char c : t.toCharArray()) 
            requiredCharacters.put(c, requiredCharacters.getOrDefault(c, 0) + 1);

        int left = 0;
        int minLeft = 0;
        int minLen = s.length() + 1;
        int count = 0;
        
        for (int right = 0; right < s.length(); right++) {
            if (requiredCharacters.containsKey(s.charAt(right))) {
                requiredCharacters.put(s.charAt(right), requiredCharacters.get(s.charAt(right)) - 1);
                if (requiredCharacters.get(s.charAt(right)) >= 0) count ++;
                while (count == t.length()) {
                    if (right - left + 1 < minLen){
                        minLeft = left;
                        minLen = right - left + 1;
                    }
                    if (requiredCharacters.containsKey(s.charAt(left))) {
                        requiredCharacters.put(s.charAt(left), requiredCharacters.get(s.charAt(left)) + 1);
                        if (requiredCharacters.get(s.charAt(left)) > 0) count --;
                    }
                    left ++ ;
                }
            }
        }
        if (minLen > s.length()) return "";   
    
        return s.substring(minLeft, minLeft + minLen);
    }
}
