// https://www.youtube.com/watch?v=Q1TYVUEr-wY

class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int n = A.length;
        int maxStraightSum = Integer.MIN_VALUE;
        int minStraightSum = Integer.MAX_VALUE;
        int arraySum = 0;
        
        int tempMaxSum = 0;
        int tempMinSum = 0;
        for (int i = 0; i < n; i++) {
            arraySum += A[i];
            
            tempMaxSum += A[i];
            maxStraightSum = maxStraightSum < tempMaxSum ? tempMaxSum : maxStraightSum;
            tempMaxSum = tempMaxSum < 0 ? 0 : tempMaxSum;
            
            tempMinSum += A[i];
            minStraightSum = minStraightSum > tempMinSum ? tempMinSum : minStraightSum;
            tempMinSum = tempMinSum > 0 ? 0 : tempMinSum;
        }
        if (arraySum == minStraightSum)
            return maxStraightSum;
        return Math.max(maxStraightSum, (arraySum - minStraightSum));
    }
}