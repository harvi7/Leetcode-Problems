// https://www.youtube.com/watch?v=os4B7MlHAbs

class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int total_sum = 0;
        int max_ending_at = 0;
        int min_ending_at = 0;
        int max_sum = Integer.MIN_VALUE;
        int min_sum = Integer.MAX_VALUE;

        for (int x : A) {
            total_sum += x;
            
            max_ending_at = Math.max(max_ending_at + x, x);
            max_sum = Math.max(max_ending_at, max_sum);
            
            min_ending_at = Math.min(min_ending_at + x, x);
            min_sum = Math.min(min_ending_at, min_sum);
        }
        if (max_sum > 0 )
            return Math.max(max_sum, total_sum - min_sum);
        return max_sum;
    }
}