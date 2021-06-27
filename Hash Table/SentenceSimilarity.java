// https://leetcode.com/problems/sentence-similarity/discuss/1147240/Java-easy-pairs

class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) return false;
        
        HashSet<Pair<String, String>> set = new HashSet();
        
        for (List<String> pair : similarPairs)
            set.add(new Pair(pair.get(0), pair.get(1)));
        
        for (int i = 0; i < sentence1.length; i++) {
            Pair p1 = new Pair(sentence1[i], sentence2[i]);
            Pair p2 = new Pair(sentence2[i], sentence1[i]);
            if (!sentence1[i].equals(sentence2[i]) && !set.contains(p1) && !set.contains(p2))
                return false;
        }  
        return true;
    }
}