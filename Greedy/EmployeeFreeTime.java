// https://www.youtube.com/watch?v=tafUkDPWIbM

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {     
        List<int[]> intervals = new ArrayList(); 
        for (List<Interval> employee: schedule) {
            for (Interval interval: employee) {
                intervals.add(new int[]{interval.start, interval.end});
            }
        }
        
        Collections.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]); 
        
        List<Interval> result = new ArrayList();
        int lastEnd = intervals.get(0)[1];
        
        for (int[] interval : intervals) {
            int currStart = interval[0];
            int currEnd = interval[1];
            
            if (currStart > lastEnd) {
                result.add(new Interval(lastEnd, currStart));
            }                
            lastEnd = Math.max(lastEnd, currEnd);
        }
        return result;
    }
}