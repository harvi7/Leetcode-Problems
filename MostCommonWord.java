// https://www.youtube.com/watch?v=qbEtfHjAI8A

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bannedWords = new HashSet();
        HashMap<String, Integer> validWordCounts = new HashMap();
        
        for (String bannedWord : banned)
            bannedWords.add(bannedWord);
        
        String[] words = paragraph.toLowerCase().split("\\W+");
        
        int max = 0;
        String result = "";
        
        for (String word : words) {
            if (!bannedWords.contains(word)) {
                validWordCounts.put(word, validWordCounts.getOrDefault(word, 0) + 1);
                if (validWordCounts.get(word) > max) {
                    max = validWordCounts.get(word);
                    result = word;
                }
            }                                
        }
            
        return result;
    }
}