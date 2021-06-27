// https://www.youtube.com/watch?v=5NCjHqx2v-k

class Solution {
    public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0) return null;
        
        List<Integer> res = new ArrayList();
        
        int[] lastIndices = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastIndices[S.charAt(i) - 'a'] = i;
        }
        
        int start = 0, end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, lastIndices[S.charAt(i) - 'a']);
            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
}