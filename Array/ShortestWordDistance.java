// https://leetcode.com/problems/shortest-word-distance/solution/

class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1, index2 = -1;
        int ans = Integer.MAX_VALUE;
        for (int i=0; i<words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i; 
                if (index2 != -1)  ans = Math.min(ans, Math.abs(index1 - index2));    
            }
            
            if (words[i].equals(word2)) {
                index2 = i;
                if (index1 != -1) ans = Math.min(ans, Math.abs(index1 - index2));
            }
        }
        return ans;
    }
}