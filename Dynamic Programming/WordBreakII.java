// https://www.youtube.com/watch?v=9-grHHGUVls

class Solution {
    
    private HashMap<String, List<String>> dp;
    private Set<String> wordSet;
    
    private List<String> helper(String s) {
        if (dp.containsKey(s)) return dp.get(s);
        
        List<String> res = new ArrayList<>();
        if (s.length() == 0) return res;
        if (wordSet.contains(s)) res.add(s);      
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            if (!wordSet.contains(left)) continue;
            for (String word: helper(s.substring(i))) {
                res.add(left + " " + word);
            }
        }
        dp.put(s, res);
        return res;
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (wordDict.size() == 0) return new ArrayList<>();
        dp = new HashMap<>();
        wordSet = new HashSet<>(wordDict);
        return helper(s);
    }
}