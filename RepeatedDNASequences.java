class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) return new ArrayList();
        Set seen = new HashSet(), repeated = new HashSet();        
        int i = 0;
        while (i + 10 <= s.length()) {
            String subseq = s.substring(i, i++ + 10);
            if (!seen.add(subseq))
                repeated.add(subseq);
        }
        return new ArrayList(repeated);
    }
}