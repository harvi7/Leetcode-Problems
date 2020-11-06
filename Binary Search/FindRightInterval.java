// https://www.youtube.com/watch?v=VEBbumHmps8

class Solution {
    private int binary_search(List<Pair<Pair<Integer, Integer>, Integer>> sorted, int x){
        int n = sorted.size();
        if (sorted.get(n - 1).getKey().getKey() < x) return -1;
        
        int l = 0, r = n - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if (sorted.get(mid).getKey().getKey() >= x) r = mid - 1;
            else l = mid + 1;
        }
        return sorted.get(l).getValue();
    }
    public int[] findRightInterval(int[][] intervals) {
        List<Pair<Pair<Integer, Integer>, Integer>> sorted = new ArrayList();
        int n = intervals.length;
        for (int i = 0; i < n; ++i)
            sorted.add(new Pair(new Pair(intervals[i][0], intervals[i][1]), i));
        
        Collections.sort(sorted, (a,b) -> a.getKey().getKey() - b.getKey().getKey());
        
        int[] result = new int[n];
        for (int i = 0; i < n; ++i)
            result[i] = binary_search(sorted, intervals[i][1]);
        
        return result;
    }
}