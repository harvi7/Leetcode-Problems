// https://leetcode.com/problems/merge-intervals/solution/

class Solution {
    public int[][] merge(int[][] intervals) {
//         if (intervals.length <= 1)
//             return intervals;
//         Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        
//         List<int[]> result = new ArrayList<>();
        
//         int[] currInterval = intervals[0];
//         result.add(currInterval);
        
//         for (int[] interval : intervals) {
//             int currBegin = currInterval[0];
//             int currEnd = currInterval[1];
//             int nextBegin = interval[0];
//             int nextEnd = interval[1];
            
//             if (currEnd >= nextBegin)
//                 currInterval[1] = Math.max(currEnd, nextEnd);
//             else {
//                 currInterval = interval;
//                 result.add(currInterval);   
//             }
//         }      
//         return result.toArray(new int[result.size()][]);
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}