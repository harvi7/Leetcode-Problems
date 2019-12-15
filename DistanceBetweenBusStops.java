// https://www.youtube.com/watch?v=p3MYMEcLs7E

class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int clockwiseDist = 0, totalDist = 0;
        for (int i = 0; i < distance.length; i++) {
            if (start < destination && (i >= start && i < destination))
                clockwiseDist += distance[i];
            if (start > destination && (i >= start || i < destination))
                clockwiseDist += distance[i];
            totalDist += distance[i];
        }        
        return Math.min(clockwiseDist, totalDist - clockwiseDist);
    }
}