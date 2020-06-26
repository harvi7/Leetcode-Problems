// https://www.youtube.com/watch?v=cqM8HqhuPe8
// https://www.youtube.com/watch?v=LL98HP2hWhs

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int seconds = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int[] first = points[i];
            int[] second = points[i + 1];
            
            int xDiff = Math.abs(first[0] - second[0]);
            int yDiff = Math.abs(first[1] - second[1]);
            
            seconds += Math.max(xDiff, yDiff);
        }
        return seconds;
    }
}