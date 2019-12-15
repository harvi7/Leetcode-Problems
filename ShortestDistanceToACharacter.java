// https://www.youtube.com/watch?v=YMKpDBmDJQE

class Solution {
    public int[] shortestToChar(String S, char C) {
        int n = S.length();
        int[] res = new int[n];
        int cPosition= -n;
        
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == C)
                cPosition = i;
            res[i] = i - cPosition;
        }
        
        for (int i = n - 1; i >= 0; i--) {
            if (S.charAt(i) == C)
                cPosition = i;
            res[i] = Math.min(res[i], Math.abs(i - cPosition));
        }
        return res;
    }
}