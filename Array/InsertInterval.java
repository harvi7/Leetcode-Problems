// https://github.com/eMahtab/insert-interval
// https://www.youtube.com/watch?v=jeKvO1JS-4w&ab_channel=happygirlzt

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<int[]>();
        for (int[] interval : intervals) {
        	if (newInterval == null || interval[1] < newInterval[0]) {
        		res.add(interval);
        	} else if (newInterval[1] < interval[0]) {
        		res.add(newInterval);
        		res.add(interval);
                newInterval = null;
        	} else {
        		newInterval[0] = Math.min(newInterval[0], interval[0]);
        		newInterval[1] = Math.max(newInterval[1], interval[1]);
        	}
        }
        
        if (newInterval != null)
            res.add(newInterval);
        
        return res.toArray(new int[res.size()][]);
    }
}