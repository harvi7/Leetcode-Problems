// https://www.youtube.com/watch?v=8kwPXbTMSnk

class Solution {
    int totPoints;
    List<Integer> rectCumCount = new ArrayList<>();
    int[][]  rects;
    Random rand = new Random();
    
    public Solution(int[][] rects) {
        totPoints = 0;
        this.rects = rects;
        for (int[] rect: rects) {
            totPoints += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            rectCumCount.add(totPoints);
        }
    }
    
    public int[] pick() {
        int targ = rand.nextInt(totPoints);
        int low = 0, high = rects.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (rectCumCount.get(mid) <= targ) low = mid + 1;
            else high = mid;
        }

        int[] rect = rects[ ];
        int width = rect[2] - rect[0] + 1;
        int height = rect[3] - rect[1] + 1;
        int ptsInRect = width * height;
        int ptStart = rectCumCount.get(low) - ptsInRect;
        int offset = targ - ptStart;
        return new int[]{rect[0] + offset % width, rect[1] + offset / width};
    }
}