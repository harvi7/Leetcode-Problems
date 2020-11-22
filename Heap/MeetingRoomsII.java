// https://www.youtube.com/watch?v=PWgFnSygweI

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length < 1) return 0;
        
        Arrays.sort(intervals, ((a, b) -> a[0] - b[0]));
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> a - b);
        
        for (int[] interval : intervals) {
            if (!q.isEmpty() && interval[0] >= q.peek()) {
                q.remove();
            }
            q.add(interval[1]);
        }
        return q.size();
    }
}