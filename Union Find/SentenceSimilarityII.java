// https://leetcode.com/problems/sentence-similarity-ii/discuss/109752/JavaC%2B%2B-Clean-Code-with-Explanation

class Solution {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) return false;
        Map<String, String> m = new HashMap<>();
        for (List<String> p : similarPairs) {
            String parent1 = find(m, p.get(0)), parent2 = find(m, p.get(1));
            if (!parent1.equals(parent2)) m.put(parent1, parent2);
        }

        for (int i = 0; i < sentence1.length; i++)
            if (!sentence1[i].equals(sentence2[i]) && !find(m, sentence1[i]).equals(find(m, sentence2[i]))) return false;

        return true;
    }
    
    private String find(Map<String, String> m, String s) {
        if (!m.containsKey(s)) m.put(s, s);
        return s.equals(m.get(s)) ? s : find(m, m.get(s));
    }
}