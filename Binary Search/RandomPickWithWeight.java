// https://www.youtube.com/watch?v=fWS0TCcr-lE
// https://leetcode.com/problems/random-pick-with-weight/solution/

class Solution {
    private int[] prefixSums;
    
    public Solution(int[] w) {
        this.prefixSums = new int[w.length];
        int prefixSum = 0;
        for (int i = 0; i < w.length; ++i) {
            prefixSum += w[i];
            this.prefixSums[i] = prefixSum;
        }
    }
    
    public int pickIndex() {
        double target = this.prefixSums[this.prefixSums.length - 1] * Math.random();
        
        int low = 0, high = this.prefixSums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (target > this.prefixSums[mid])
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}
