// https://leetcode.com/problems/remove-covered-intervals/solution/

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1]: o1[0] - o2[0];
            }
        });

        int count = 0;
        int end, prev_end = 0;
        for (int[] curr : intervals) {
            end = curr[1];
            if (prev_end < end) {
                ++count;
                prev_end = end;
            }
        }
        return count;
    }
}