// https://www.youtube.com/watch?v=gWqbmAS3uxg

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> counts = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        
        for (char c : ransomNote.toCharArray()) {
            if (!counts.containsKey(c) || counts.get(c) <= 0) 
                return false;
            counts.put(c, counts.get(c) - 1);
        }
        return true;
    }
}