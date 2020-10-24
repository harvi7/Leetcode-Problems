// https://leetcode.com/problems/meeting-rooms/solution/

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] i1, int[] i2) {
                return i1[0] - i2[0];
            }
        });

        for (int i = 0; i < intervals.length - 1; i++) {
          if (intervals[i][1] > intervals[i + 1][0])
            return false;
        }
        return true;
    }
}