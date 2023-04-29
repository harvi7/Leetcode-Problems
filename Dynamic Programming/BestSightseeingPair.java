// https://www.youtube.com/watch?v=acZLDtayXlU

class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxi = values[0] + 0;
        int ans = -1;
        int n = values.length;
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, maxi + values[i] - i);
            maxi = Math.max(maxi, values[i] + i);
        }
        return ans;
    }
}